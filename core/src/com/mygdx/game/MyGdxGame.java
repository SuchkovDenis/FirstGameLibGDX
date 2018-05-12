package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.person.Asteroid;
import com.mygdx.game.person.Ship;
import com.mygdx.game.person.level.Level;
import com.mygdx.game.person.level.Space;

public class MyGdxGame extends ApplicationAdapter {

    private SpriteBatch batch;

    private Level level;
    private Ship ship;
    private Asteroid asteroid;

    @Override
    public void create() {
        batch = new SpriteBatch();
        ship = new Ship();
        asteroid = new Asteroid();
        level = new Space();
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        update(dt);
        batch.begin();
        level.render(batch);
        ship.render(batch);
        asteroid.render(batch);
        batch.end();
    }

    public void update(float dt) {
        ship.update(dt);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
