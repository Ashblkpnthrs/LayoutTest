package fr.infostrates.layouttest

import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.animation.ValueAnimator.AnimatorUpdateListener
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.LinearLayout
import android.widget.TextView

class SuperSwitchView : LinearLayout {
    private var mMoveDuration: Long = 0
    private var mHighlightBounds: RectF? = null
    private var mAnimator: ValueAnimator? = null
    private var mBorderPaint: Paint? = null
    private var mHighlightPaint: Paint? = null
    private var mBorderPath: Path? = null
    private var mHighlightPath: Path? = null
    private var mBorderColor = 0
    private var mBaseTextColor = 0
    private var mHighlightColor = 0
    private var mHighlightTextColor = 0
    private var mCurrent = 0
    private var mBorderWidth = 0f
    private var mDirty = false
    private var mCallback: ISelectionCallback? = null

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        if (attrs == null) {
            mBorderColor = DEFAULT_BORDER_COLOR
            mBorderWidth = DEFAULT_BORDER_WIDTH
            mHighlightColor = DEFAULT_HIGHLIGHT_COLOR
            mHighlightTextColor = Color.BLACK
            mBaseTextColor = Color.BLACK
            mMoveDuration = DEFAULT_MOVE_DURATION
        } else {
            val ta = context.obtainStyledAttributes(attrs, R.styleable.SuperSwitchView, 0, 0)
            mBorderColor = ta.getColor(R.styleable.SuperSwitchView_borderColor, resources.getColor(R.color.colorPrimaryDark))
            mBorderWidth = ta.getDimension(R.styleable.SuperSwitchView_borderWidth, DEFAULT_BORDER_WIDTH)
            mHighlightColor = ta.getColor(R.styleable.SuperSwitchView_highlightColor, resources.getColor(R.color.yellowBlock))
            mHighlightTextColor = ta.getColor(R.styleable.SuperSwitchView_highlightTextColor, Color.BLACK)
            mBaseTextColor = ta.getColor(R.styleable.SuperSwitchView_baseTextColor, Color.BLACK)
            mMoveDuration = ta.getInt(R.styleable.SuperSwitchView_moveDuration, DEFAULT_MOVE_DURATION.toInt()).toLong()
            ta.recycle()
        }
        mHighlightPath = Path()
        mHighlightBounds = RectF()
        mHighlightPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mHighlightPaint!!.color = mHighlightColor
        mBorderPath = Path()
        mBorderPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mBorderPaint!!.color = mBorderColor
        mBorderPaint!!.style = Paint.Style.STROKE
        mBorderPaint!!.strokeWidth = mBorderWidth
        mDirty = true
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mDirty = true
    }

    override fun dispatchDraw(canvas: Canvas) {
        if (mDirty) {
            mBorderPath!!.reset()
            drawPill(mBorderPath, RectF(0f, 0f, width.toFloat(), height.toFloat()), mBorderWidth / 2f)
            reinitHighlight()
            mDirty = false
        }
        canvas.drawPath(mBorderPath!!, mBorderPaint!!)
        canvas.drawPath(mHighlightPath!!, mHighlightPaint!!)
        super.dispatchDraw(canvas)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return true
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (event.action == MotionEvent.ACTION_DOWN) {
            checkCollision(event.x, event.y)
        } else super.onTouchEvent(event)
    }

    fun setCallback(callback: ISelectionCallback?) {
        mCallback = callback
    }

    private fun reinitHighlight() {
        if (childCount < 1) {
            return
        }
        for (i in 0 until childCount) {
            val child = getChildAt(i) as TextView
            child.setTextColor(mBaseTextColor)
        }
        val child = getChildAt(mCurrent) as TextView
        child.setTextColor(mHighlightTextColor)
        mHighlightBounds!![child.left.toFloat(), child.top.toFloat(), child.right.toFloat()] = child.bottom.toFloat()
        updateHighlightPath()
    }

    private fun updateHighlightPath() {
        mHighlightPath!!.reset()
        val radius = mHighlightBounds!!.height() / 2f
        mHighlightPath!!.addRect(
                mHighlightBounds!!.left + radius,
                mHighlightBounds!!.top,
                mHighlightBounds!!.right - radius,
                mHighlightBounds!!.bottom,
                Path.Direction.CW
        )
        mHighlightPath!!.addCircle(mHighlightBounds!!.left + radius, mHighlightBounds!!.centerY(), radius, Path.Direction.CW)
        mHighlightPath!!.addCircle(mHighlightBounds!!.right - radius, mHighlightBounds!!.centerY(), radius, Path.Direction.CW)
    }

    private fun checkCollision(x: Float, y: Float): Boolean {
        val childCount = childCount
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            if (x >= child.left && x <= child.right && y >= child.top && y <= child.bottom) {
                if (i != mCurrent) {
                    onNewSelection(mCurrent, i)
                    mCurrent = i
                }
                return true
            }
        }
        return false
    }

    fun refreshAfterVisibilityChange() {
        mDirty = true
    }

    var selected: Int
        get() = mCurrent
        set(selected) {
            reinitHighlight()
            mCurrent = selected
            mDirty = true
        }

    private fun onNewSelection(oldIndex: Int, newIndex: Int) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onNewSelection() called with: oldIndex = [$oldIndex], newIndex = [$newIndex]")
        if (mCallback != null) {
            mCallback!!.onNewSelected(oldIndex, newIndex)
        }
        val child = getChildAt(newIndex) as TextView
        val leftHolder = PropertyValuesHolder.ofFloat("left", mHighlightBounds!!.left, child.left.toFloat())
        val topHolder = PropertyValuesHolder.ofFloat("top", mHighlightBounds!!.top, child.top.toFloat())
        val rightHolder = PropertyValuesHolder.ofFloat("right", mHighlightBounds!!.right, child.right.toFloat())
        val bottomHolder = PropertyValuesHolder.ofFloat("bottom", mHighlightBounds!!.bottom, child.bottom.toFloat())
        if (mAnimator != null && mAnimator!!.isRunning) {
            mAnimator!!.cancel()
        }
        mAnimator = ValueAnimator.ofPropertyValuesHolder(leftHolder, topHolder, rightHolder, bottomHolder)
        mAnimator?.addUpdateListener(AnimatorUpdateListener { animation ->
            mHighlightBounds!![animation.getAnimatedValue(leftHolder.propertyName) as Float, animation.getAnimatedValue(topHolder.propertyName) as Float, animation.getAnimatedValue(rightHolder.propertyName) as Float] = animation.getAnimatedValue(bottomHolder.propertyName) as Float
            updateHighlightPath()
            invalidate()
        })
        mAnimator?.setDuration(mMoveDuration)
        mAnimator?.setInterpolator(AccelerateDecelerateInterpolator())
        mAnimator?.start()
        val oldChild = getChildAt(oldIndex) as TextView
        oldChild.setTextColor(mBaseTextColor)
        child.setTextColor(mHighlightTextColor)
    }

    fun setBaseTextColor(color: Int) {
        mBaseTextColor = color
        (getChildAt(1) as TextView).setTextColor(mBaseTextColor)
    }

    private fun drawPill(path: Path?, bounds: RectF, padding: Float) {
        bounds.inset(padding, padding)
        val radius = bounds.height()
        path!!.moveTo(bounds.left + radius, bounds.top)
        path.lineTo(bounds.right - radius, bounds.top)
        path.arcTo(bounds.right - radius, bounds.top, bounds.right, bounds.bottom, -90f, 180f, false)
        path.lineTo(bounds.left + radius, bounds.bottom)
        path.arcTo(bounds.left, bounds.top, bounds.left + radius, bounds.bottom, 90f, 180f, false)
        path.close()
    }

    interface ISelectionCallback {
        fun onNewSelected(oldIndex: Int, newIndex: Int)
    }

    companion object {
        private const val TAG = "SuperSwitchView"
        private const val DEFAULT_MOVE_DURATION = 150L
        private const val DEFAULT_BORDER_COLOR = -0xFBE3B0
        private const val DEFAULT_HIGHLIGHT_COLOR = -0xFBE3B0
        private const val DEFAULT_BORDER_WIDTH = 5f
    }
}