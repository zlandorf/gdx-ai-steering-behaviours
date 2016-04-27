package com.betomorrow.steeringbehaviours;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.betomorrow.steeringbehaviours.model.screens.AIScreen;

public class SteeringBehavioursGame extends Game {

    @Override
    public void create () {
        setScreen(new AIScreen());
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(.9f, .9f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
    }
}
