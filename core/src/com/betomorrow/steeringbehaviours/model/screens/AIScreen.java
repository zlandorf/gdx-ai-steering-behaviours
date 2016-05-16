package com.betomorrow.steeringbehaviours.model.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.betomorrow.steeringbehaviours.model.Mapper;
import com.betomorrow.steeringbehaviours.model.actors.TargetActor;
import com.betomorrow.steeringbehaviours.model.components.ActorComponent;
import com.betomorrow.steeringbehaviours.model.components.SteeringComponent;
import com.betomorrow.steeringbehaviours.model.entities.AIEntity;
import com.betomorrow.steeringbehaviours.model.systems.MovingActorSystem;
import com.betomorrow.steeringbehaviours.model.systems.SteeringSystem;

public class AIScreen extends ScreenAdapter {
    private Stage stage;
    private Engine engine;
    private TargetActor targetActor;

    public AIScreen() {
        engine = new Engine();
        engine.addEntityListener(Family.one(ActorComponent.class).get(), new EntityListener() {
            @Override
            public void entityAdded(Entity entity) {
                stage.addActor(Mapper.actor.get(entity).actor);
            }

            @Override
            public void entityRemoved(Entity entity) {
                Mapper.actor.get(entity).actor.remove();
            }
        });

        engine.addSystem(new SteeringSystem());
        engine.addSystem(new MovingActorSystem());

        stage = new Stage(new ScreenViewport());
        stage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                System.out.println(x + ", " + y);
                if (targetActor == null) {
                    targetActor = new TargetActor();
                    stage.addActor(targetActor);
                }

                targetActor.setPosition(x, y);
                engine.getEntitiesFor(Family.one(SteeringComponent.class).get())
                    .forEach(e -> Mapper.steering.get(e).seek.setTarget(new Vector2(x, y)));
            }
        });
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
