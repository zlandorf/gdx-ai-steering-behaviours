package com.betomorrow.steeringbehaviours.model.listeners;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.betomorrow.steeringbehaviours.model.Mapper;
import com.betomorrow.steeringbehaviours.model.actors.TargetActor;
import com.betomorrow.steeringbehaviours.model.components.SteeringComponent;

public class TargetSetterListener extends ClickListener {
    private TargetActor targetActor = null;

    private Stage stage;
    private Engine engine;

    public TargetSetterListener(Stage stage, Engine engine) {
        this.stage = stage;
        this.engine = engine;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);

        if (targetActor == null) {
            targetActor = new TargetActor();
            stage.addActor(targetActor);
        }

        targetActor.setPosition(x, y);
        engine.getEntitiesFor(Family.one(SteeringComponent.class).get())
            .forEach(e -> Mapper.steering.get(e).seek.setTarget(new Vector2(x, y)));
    }
}
