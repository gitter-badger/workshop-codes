package com.codingblcoks.jeteater.scene;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class HUD {

    public Stage stage;

    int score = 0;
    int life = 3;
    int time = 100;

    Label.LabelStyle style= new Label.LabelStyle(new BitmapFont(), Color.WHITE);

    Label scoreVal = new Label("0", style);
    Label lifeVal = new Label("3 - 3", style);
    Label timeVal = new Label("100", style);

    public HUD() {
        stage = new Stage();

        Table table = new Table();

        Label scoreTitle = new Label("Score", style);
        Label lifeTitle = new Label("Life", style);
        Label timeTitle = new Label("Time", style);

        table.setFillParent(true);

        table.top();
        table.add(scoreTitle).expandX();
        table.add(lifeTitle).expandX();
        table.add(timeTitle).expandX();

        table.row();

        table.add(scoreVal).expandX();
        table.add(lifeVal).expandX();
        table.add(timeVal).expandX();


        stage.addActor(table);

    }

    public void addScore(int i) {
        score += i;
        scoreVal.setText(String.format("%d", score));
    }

    public void kill() {
        life --;
        lifeVal.setText(String.format("%d - 3", life));
    }
}
