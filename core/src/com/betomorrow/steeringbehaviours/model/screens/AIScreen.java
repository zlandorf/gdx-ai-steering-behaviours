package com.betomorrow.steeringbehaviours.model.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.betomorrow.steeringbehaviours.model.components.ActorComponent;
import com.betomorrow.steeringbehaviours.model.entities.AIEntity;
import com.betomorrow.steeringbehaviours.model.systems.AISystem;

public class AIScreen extends ScreenAdapter {
    private Stage stage;
    private Engine engine;

    public AIScreen() {
        engine = new Engine();
        engine.addEntityListener(Family.one(ActorComponent.class).get(), new EntityListener() {
            @Override
            public void entityAdded(Entity entity) {
                stage.addActor(entity.getComponent(ActorComponent.class).actor);
            }

            @Override
            public void entityRemoved(Entity entity) {
                entity.getComponent(ActorComponent.class).actor.remove();
            }
        });

        engine.addSystem(new AISystem());

        stage = new Stage(new ScreenViewport());
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
