package com.betomorrow.steeringbehaviours.model.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.betomorrow.steeringbehaviours.model.utils.VectorUtils;

public class MobileComponent implements Component {
    public Vector2 position;

    public float mass;
    public Vector2 velocity;
    public Vector2 heading;
    public Vector2 side;

    public float maxSpeed = 150;
    public float maxForce = 100;
    public float maxTurnRate = 100;

    public MobileComponent(Vector2 positon, float mass, Vector2 heading) {
        this.position = positon;
        this.mass = mass;
        this.heading = heading;
        this.velocity = new Vector2();
        this.side = VectorUtils.perp(heading);
    }

    /**
     * Wraps an actor around the world as if it was a toroid
     */
    public void wrapAround() {
        float x = position.x % Gdx.graphics.getWidth();
        float y = position.y % Gdx.graphics.getHeight();

        // % can be negative in Java
        position.set(
            x < 0 ? x + Gdx.graphics.getWidth() : x,
            y < 0 ? y + Gdx.graphics.getHeight() : y
        );
    }

}
