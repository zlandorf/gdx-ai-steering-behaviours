package com.betomorrow.steeringbehaviours.model.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.betomorrow.steeringbehaviours.model.components.ActorComponent;
import com.betomorrow.steeringbehaviours.model.components.MobileComponent;

public class MovingActorSystem extends IteratingSystem {
    public MovingActorSystem() {
        super(Family.one(ActorComponent.class, MobileComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        Actor actor = entity.getComponent(ActorComponent.class).actor;
        MobileComponent mobileComponent = entity.getComponent(MobileComponent.class);

        Vector2 position = mobileComponent.position;
        Vector2 heading = mobileComponent.heading;

        actor.setRotation((float)Math.toDegrees(Math.atan2(-heading.x, heading.y)));
        actor.setPosition(position.x, position.y);
    }

}
