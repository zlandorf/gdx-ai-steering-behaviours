package com.betomorrow.steeringbehaviours.model.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
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

        Vector2 velocity = mobileComponent.velocity;
        Vector2 heading = mobileComponent.heading;

        actor.setRotation((float)Math.toDegrees(Math.atan2(-heading.x, heading.y)));
        actor.moveBy(velocity.x * deltaTime, velocity.y * deltaTime);
        wrapAroundWorld(actor);
    }

    /**
     * Wraps an actor around the world as if it was a toroid
     * @param actor
     */
    private void wrapAroundWorld(Actor actor) {
        float x = actor.getX() % Gdx.graphics.getWidth();
        float y = actor.getY() % Gdx.graphics.getHeight();

        // % can be negative in Java
        actor.setPosition(
            x < 0 ? x + Gdx.graphics.getWidth() : x,
            y < 0 ? y + Gdx.graphics.getHeight() : y
        );
    }
}
