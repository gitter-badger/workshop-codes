package com.codingblcoks.jeteater.sprite;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bomb extends Sprite {

    public Bomb() {
        super(new Texture("bomb.png"));
        relocate();

    }

    private void relocate() {
        int  x = (int) (Math.random() * Gdx.graphics.getWidth());
        int  y = (int) (Math.random() * Gdx.graphics.getHeight());
        setPosition(x, y);

    }

    public boolean checkHit(Jet jet){
        Rectangle jRect = jet.getBoundingRectangle();
        Rectangle bRect = this.getBoundingRectangle();

        if ( jRect.overlaps(bRect)){
            relocate();
            return true;
        }

        return false;
    }


}
