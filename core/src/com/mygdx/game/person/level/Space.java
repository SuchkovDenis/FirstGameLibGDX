package com.mygdx.game.person.level;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Space implements Level{
    private Texture backround;

    public Space() {
        backround = new Texture("background.png");
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(backround, 0 ,0);
    }
}
