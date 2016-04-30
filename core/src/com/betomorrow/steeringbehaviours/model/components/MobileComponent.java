package com.betomorrow.steeringbehaviours.model.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.betomorrow.steeringbehaviours.model.utils.VectorUtils;

public class MobileComponent implements Component {
    public float mass;
    public Vector2 velocity;
    public Vector2 heading;
    public Vector2 side;

    public float maxSpeed = 100;
    public float maxForce = 100;
    public float maxTurnRate = 100;

    public MobileComponent(float mass, Vector2 heading) {
        this.mass = mass;
        this.heading = heading;
        this.velocity = new Vector2();
        this.side = VectorUtils.perp(heading);
    }

}
