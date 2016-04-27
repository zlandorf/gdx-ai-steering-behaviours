package com.betomorrow.steeringbehaviours.model.entities;

import com.badlogic.ashley.core.Entity;
import com.betomorrow.steeringbehaviours.model.actors.AIActor;
import com.betomorrow.steeringbehaviours.model.components.AIComponent;
import com.betomorrow.steeringbehaviours.model.components.ActorComponent;

public class AIEntity extends Entity {
    public AIEntity() {
        super();
        ActorComponent actorComponent = new ActorComponent();
        actorComponent.actor = new AIActor();

        add(new AIComponent());
        add(actorComponent);
    }
}
