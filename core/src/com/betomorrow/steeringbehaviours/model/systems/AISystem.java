package com.betomorrow.steeringbehaviours.model.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.betomorrow.steeringbehaviours.model.components.AIComponent;
import com.betomorrow.steeringbehaviours.model.components.ActorComponent;

import java.util.Random;

public class AISystem extends IteratingSystem {
    private Random random;

    public AISystem() {
        super(Family.all(AIComponent.class, ActorComponent.class).get());
        random = new Random();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        // move actor randomly
        Actor actor = entity.getComponent(ActorComponent.class).actor;
        actor.moveBy(random.nextInt(4), random.nextInt(4));
        actor.rotateBy(random.nextInt(2));
    }
}
