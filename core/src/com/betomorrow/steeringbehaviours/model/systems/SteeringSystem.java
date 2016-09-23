package com.betomorrow.steeringbehaviours.model.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.betomorrow.steeringbehaviours.model.components.MobileComponent;
import com.betomorrow.steeringbehaviours.model.components.SteeringComponent;
import com.betomorrow.steeringbehaviours.model.utils.VectorUtils;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Random;

public class SteeringSystem extends IteratingSystem {
    private Random random;

    @Inject
    public SteeringSystem() {
        super(Family.one(SteeringComponent.class, MobileComponent.class).get());
        random = new Random();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        MobileComponent mobile = entity.getComponent(MobileComponent.class);
        SteeringComponent steering = entity.getComponent(SteeringComponent.class);

        Vector2 steeringForce = steering.seek.compute();
        if (steeringForce.len2() <= 0) {

//            steeringForce = mobile.heading.cpy().rotate(50 - random.nextInt(100)).scl(random.nextInt(500));
        }

        VectorUtils.truncate(steeringForce, mobile.maxForce);


        Vector2 acceleration = steeringForce.scl(1 / mobile.mass);
        mobile.velocity.add(acceleration.scl(deltaTime));
        VectorUtils.truncate(mobile.velocity, mobile.maxSpeed);

        if (mobile.velocity.len2() > 0.00000001) {
            mobile.heading = mobile.velocity.cpy().nor();
            mobile.side = VectorUtils.perp(mobile.heading);
        }

        mobile.position.add(mobile.velocity.x * deltaTime, mobile.velocity.y * deltaTime);
        mobile.wrapAround();
    }
}
