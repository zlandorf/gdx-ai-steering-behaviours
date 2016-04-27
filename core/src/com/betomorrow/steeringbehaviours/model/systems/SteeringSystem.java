package com.betomorrow.steeringbehaviours.model.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.betomorrow.steeringbehaviours.model.components.AIComponent;
import com.betomorrow.steeringbehaviours.model.components.MobileComponent;
import com.betomorrow.steeringbehaviours.model.utils.VectorUtils;

import java.util.Random;

public class SteeringSystem extends IteratingSystem {
    private Random random;

    public SteeringSystem() {
        super(Family.one(AIComponent.class, MobileComponent.class).get());
        random = new Random();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        MobileComponent mobile = entity.getComponent(MobileComponent.class);
        Vector2 steeringForce = mobile.heading.cpy().rotate(25 - random.nextInt(50)).scl(random.nextInt(500));

        Vector2 acceleration = steeringForce.scl(1 / mobile.mass);
        mobile.velocity.add(acceleration.scl(deltaTime));
        VectorUtils.truncate(mobile.velocity, mobile.maxSpeed);

        if (mobile.velocity.len2() > 0.000001) {
            mobile.heading = mobile.velocity.cpy().nor();
            mobile.side = VectorUtils.perp(mobile.heading);
        }
    }
}
