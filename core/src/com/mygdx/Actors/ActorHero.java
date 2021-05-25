package com.mygdx.Actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class ActorHero extends Actor {

    private TextureRegion textureHero;
    private boolean alive;

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public ActorHero(TextureRegion textureHero){
        this.textureHero=textureHero;
        this.alive=true;
        setSize(textureHero.getRegionWidth(), textureHero.getRegionHeight());
    }

    public void act (float delta)
    {
        super.act(delta);
    }

    public void draw (Batch batch, float parentAlpha){
        batch.draw(textureHero, getX(), getY());
    }
}
