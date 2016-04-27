package com.betomorrow.steeringbehaviours.model.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.betomorrow.steeringbehaviours.model.actors.AIActor;
import com.betomorrow.steeringbehaviours.model.components.AIComponent;
import com.betomorrow.steeringbehaviours.model.components.ActorComponent;
import com.betomorrow.steeringbehaviours.model.components.MobileComponent;

public class AIEntity extends Entity {
    public AIEntity() {
        super();
        add(new AIComponent());
        add(new ActorComponent(new AIActor()));
        add(new MobileComponent(1, new Vector2(1, 1)));
    }
}
