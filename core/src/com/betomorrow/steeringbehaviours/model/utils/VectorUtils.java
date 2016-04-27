package com.betomorrow.steeringbehaviours.model.utils;

import com.badlogic.gdx.math.Vector2;

public class VectorUtils {
    public static Vector2 truncate(Vector2 vector, float max) {
        if (vector.len2() > max * max) {
            return vector.nor().scl(max, max);
        }
        return vector;
    }

    public static Vector2 perp(Vector2 vector) {
        return new Vector2(vector.y, -vector.x);
    }
}
