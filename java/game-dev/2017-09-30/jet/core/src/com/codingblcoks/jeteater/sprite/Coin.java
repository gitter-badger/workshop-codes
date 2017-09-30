package com.codingblcoks.jeteater.sprite;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Coin extends Sprite {

    public Coin() {
        super(new Texture("coin.png"));
        relocate();

    }

    private void relocate() {
        int  x = (int) (Math.random() * Gdx.graphics.getWidth());
        int  y = (int) (Math.random() * Gdx.graphics.getHeight());
        setPosition(x, y);
    }

    public boolean checkHit(Jet jet){
        Rectangle jRect = jet.getBoundingRectangle();
        Rectangle cRect = this.getBoundingRectangle();

        if ( jRect.overlaps(cRect)){
            relocate();
            return true;
        }

        return false;
    }


}
