package fr.infostrates.layouttest.maze;

import android.graphics.RectF;

import fr.infostrates.layouttest.R;

public class Boule {
    public static final int RAYON = 10;

    public int getCouleur() {
        return R.color.yellowBlock;
    }

    private static final float MAX_SPEED = 2.0f;
    private static final float COMPENSATEUR = 8.0f;
    private static final float REBOND = 1.75f;
    private RectF mInitialRectangle = null;


    public void setInitialRectangle(RectF pInitialRectangle) {
        this.mInitialRectangle = pInitialRectangle;
        this.mX = pInitialRectangle.left + RAYON;
        this.mY = pInitialRectangle.top + RAYON;
    }


    private RectF mRectangle = null;

    private float mX;
    public float getX() {
        return mX;
    }
    public void setPosX(float pPosX) {
        mX = pPosX;

        if(mX < RAYON) {
            mX = RAYON;
            mSpeedY = -mSpeedY / REBOND;
        } else if(mX > mWidth - RAYON) {
            mX = mWidth - RAYON;
            mSpeedY = -mSpeedY / REBOND;
        }
    }

    private float mY;
    public float getY() {
        return mY;
    }

    public void setPosY(float pPosY) {
        mY = pPosY;
        if(mY < RAYON) {
            mY = RAYON;
            mSpeedX = -mSpeedX / REBOND;
        } else if(mY > mHeight - RAYON) {
            mY = mHeight - RAYON;
            mSpeedX = -mSpeedX / REBOND;
        }
    }

    private float mSpeedX = 0;
    public void changeXSpeed() {
        mSpeedX = -mSpeedX;
    }

    private float mSpeedY = 0;
    public void changeYSpeed() {
        mSpeedY = -mSpeedY;
    }

    // Taille de l'écran en hauteur
    private int mHeight = -1;
    public void setHeight(int pHeight) {
        this.mHeight = pHeight;
    }

    // Taille de l'écran en largeur
    private int mWidth = -1;
    public void setWidth(int pWidth) {
        this.mWidth = pWidth;
    }

    public Boule() {
        mRectangle = new RectF();
    }

    public RectF putXAndY(float pX, float pY) {
        mSpeedX += pX / COMPENSATEUR;
        if(mSpeedX > MAX_SPEED)
            mSpeedX = MAX_SPEED;
        if(mSpeedX < -MAX_SPEED)
            mSpeedX = -MAX_SPEED;

        mSpeedY += pY / COMPENSATEUR;
        if(mSpeedY > MAX_SPEED)
            mSpeedY = MAX_SPEED;
        if(mSpeedY < -MAX_SPEED)
            mSpeedY = -MAX_SPEED;

        setPosX(mX + mSpeedY);
        setPosY(mY + mSpeedX);

        mRectangle.set(mX - RAYON, mY - RAYON, mX + RAYON, mY + RAYON);

        return mRectangle;
    }

    public void reset() {
        mSpeedX = 0;
        mSpeedY = 0;
        this.mX = mInitialRectangle.left + RAYON;
        this.mY = mInitialRectangle.top + RAYON;
    }
}
