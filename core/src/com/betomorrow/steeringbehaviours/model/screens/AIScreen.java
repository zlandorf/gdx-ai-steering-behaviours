package com.betomorrow.steeringbehaviours.model.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.betomorrow.steeringbehaviours.model.components.ActorComponent;
import com.betomorrow.steeringbehaviours.model.entities.AIEntity;
import com.betomorrow.steeringbehaviours.model.listeners.ActorEntityListener;
import com.betomorrow.steeringbehaviours.model.listeners.TargetSetterListener;
import com.betomorrow.steeringbehaviours.model.systems.MovingActorSystem;
import com.betomorrow.steeringbehaviours.model.systems.SteeringSystem;

import javax.inject.Inject;

public class AIScreen extends ScreenAdapter {
    private Stage stage;
    private Engine engine;

    @Inject
    public AIScreen(Stage stage, Engine engine, SteeringSystem steeringSystem, MovingActorSystem movingActorSystem) {
        this.stage = stage;
        this.engine = engine;

        engine.addEntityListener(Family.one(ActorComponent.class).get(), new ActorEntityListener());
        engine.addSystem(steeringSystem);
        engine.addSystem(movingActorSystem);

        stage.addListener(new TargetSetterListener(stage, engine));
        Gdx.input.setInputProcessor(stage);

        engine.addEntity(new AIEntity());
        engine.addEntity(new AIEntity());
        engine.addEntity(new AIEntity());
    }

    @Override
    public void render(float delta) {
        engine.update(delta);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }


}
