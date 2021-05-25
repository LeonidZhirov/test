package com.mygdx.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.Actors.ActorHero;
import com.mygdx.Actors.AnalogStick;


public class MainGameScreen extends BaseScreen {


    private Batch batch;

    public MainGameScreen(MainGame game) {
        super(game);
        asMove = new AnalogStick(15,15);
        Gdx.input.setInputProcessor(stage);
        textureHero = new Texture("CharacterTilesSet-Right.png");
        spriteHero = new Sprite(textureHero);
    }

    private Stage stage;
    private ActorHero actorHero;
    private Texture textureHero;
    private Sprite spriteHero;
    private AnalogStick asMove;

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport(), batch);
        actorHero = new ActorHero(spriteHero);
        actorHero.setPosition(stage.getWidth() / 3, stage.getHeight() / 2);
        stage.addActor(actorHero);
        stage.addActor(asMove);
        Gdx.input.setInputProcessor(stage);
//        actorHero.rotateBy(180);
//        actorHero.act(100);
        asMove.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                float deltaX = ((Touchpad) actor).getKnobPercentX();
                float deltaY = ((Touchpad) actor).getKnobPercentY();

            }
        });
    }

    @Override
    public void hide() {
        stage.dispose();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }


    @Override
    public void dispose()
    {
        textureHero.dispose();
    }
}
