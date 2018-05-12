package com.mygdx.game.person;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Ship {
    private Texture texture;
    public Vector2 position;
    private float speed;
    private float angle;

    public Ship() {
        texture = new Texture("ship.png");
        position = new Vector2(608, 328);
        speed = 300.0f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - 32, position.y - 32, 32, 32, 128, 72, 1, 1, angle, 0, 0, 128, 72, false, false);
        // для плавности
        batch.draw(texture, position.x -1280 - 32, position.y - 32, 32, 32, 128, 72, 1, 1, angle, 0, 0, 128, 72, false, false);
        batch.draw(texture, position.x + 1280 - 32, position.y - 32, 32, 32, 128, 72, 1, 1, angle, 0, 0, 128, 72, false, false);
        batch.draw(texture, position.x - 32, position.y - 720 - 32, 32, 32, 128, 72, 1, 1, angle, 0, 0, 128, 72, false, false);
        batch.draw(texture, position.x - 32, position.y + 720 - 32, 32, 32, 128, 72, 1, 1, angle, 0, 0, 128, 72, false, false);

    }

    public void update(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            angle -= 180.0f * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            angle += 180.0f * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            position.x += speed * (float)Math.cos(Math.toRadians(angle)) * dt;
            position.y += speed * (float)Math.sin(Math.toRadians(angle)) * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            position.x -= speed * (float)Math.cos(Math.toRadians(angle)) * 0.5f * dt;
            position.y -= speed * (float)Math.sin(Math.toRadians(angle)) * 0.5f * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            speed = 600;
        } else {
            speed = 300;
        }
        if (position.x > 1280)
            position.x -= 1280;
        if (position.x < 0)
            position.x += 1280;
        if (position.y > 720)
            position.y -= 720;
        if (position.y < 0)
            position.y += 720;
    }
}