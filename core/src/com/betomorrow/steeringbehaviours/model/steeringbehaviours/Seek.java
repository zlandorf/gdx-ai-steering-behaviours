package com.betomorrow.steeringbehaviours.model.steeringbehaviours;

import com.badlogic.gdx.math.Vector2;
import com.betomorrow.steeringbehaviours.model.components.MobileComponent;

public class Seek implements SteeringBehaviour {
    private MobileComponent vehicle;
    private Vector2 target;

    public Seek(MobileComponent vehicle) {
        this.target = null;
        this.vehicle = vehicle;
    }

    public void setTarget(Vector2 target) {
        this.target = target;
    }

    public Vector2 compute() {
        if (target == null) {
            return new Vector2(0, 0);
        }
        Vector2 desiredVelocity = target.cpy().add(vehicle.position.cpy().scl(-1)).nor().scl(vehicle.maxSpeed);
        return desiredVelocity.add(vehicle.velocity.cpy().scl(-1)).scl(200);
    }
}
