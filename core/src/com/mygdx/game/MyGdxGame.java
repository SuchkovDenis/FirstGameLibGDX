package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame extends ApplicationAdapter {
     class Hero {
        private Texture texture;
        private Vector2 position;
        private float speed;
        private float angle;

        public Hero() {
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

    class Asteroid {
        private Texture texture;
        private Vector2 position;

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


    private SpriteBatch batch;
    private Hero hero;
    private Asteroid asteroid;
    private Texture backround;
    @Override
    public void create() {
        batch = new SpriteBatch();
        hero = new Hero();
        asteroid = new Asteroid();
        backround = new Texture("background.png");
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        update(dt);
        Gdx.gl.glClearColor(0, 0, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(backround, 0 ,0);
        hero.render(batch);
        asteroid.render(batch);
        batch.end();
    }

    public void update(float dt) {
        hero.update(dt);
        if (Math.sqrt(Math.pow(hero.position.x - asteroid.position.x, 2) + Math.pow(hero.position.y - asteroid.position.y, 2))<100)
            asteroid.move();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
