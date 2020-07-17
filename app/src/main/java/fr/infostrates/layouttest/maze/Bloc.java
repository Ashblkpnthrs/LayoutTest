package fr.infostrates.layouttest.maze;

import android.graphics.RectF;

public class Bloc {

    enum  Type { TROU, DEPART, ARRIVEE };

    private Type mType;
    private RectF mRectangle;

    public Type getType() {
        return mType;
    }

    public RectF getRectangle() {
        return mRectangle;
    }

    public Bloc(Type pType, int pX, int pY) {
        this.mType = pType;
        float SIZE = Boule.RAYON * 2;
        this.mRectangle = new RectF(pX * SIZE, pY * SIZE, (pX + 1) * SIZE, (pY + 1) * SIZE);
    }
}
