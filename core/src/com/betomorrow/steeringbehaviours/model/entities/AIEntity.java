package com.betomorrow.steeringbehaviours.model.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.betomorrow.steeringbehaviours.model.actors.AIActor;
import com.betomorrow.steeringbehaviours.model.components.AIComponent;
import com.betomorrow.steeringbehaviours.model.components.ActorComponent;
import com.betomorrow.steeringbehaviours.model.components.MobileComponent;
import com.betomorrow.steeringbehaviours.model.components.SteeringComponent;
import com.betomorrow.steeringbehaviours.model.steeringbehaviours.Seek;

public class AIEntity extends Entity {
    public AIEntity() {
        super();

        MobileComponent mobileComponent = new MobileComponent(
            new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2),
            1f,//mass
            new Vector2(1, 0));
        SteeringComponent steeringComponent = new SteeringComponent(null);
        steeringComponent.seek = new Seek(mobileComponent);

        add(new AIComponent());
        add(new ActorComponent(new AIActor()));
        add(mobileComponent);
        add(steeringComponent);
    }
}
