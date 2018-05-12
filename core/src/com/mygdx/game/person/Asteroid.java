package com.mygdx.game.person;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    private Texture texture;
    public Vector2 position;

    public Asteroid() {
        texture = new Texture("asteroid64.png");
        position = new Vector2(MathUtils.random(0, 1280), MathUtils.random(0, 720));
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - 32, position.y - 32);
    }

    public void move() {
        position = new Vector2(MathUtils.random(0, 1280), MathUtils.random(0, 720));
    }
}
