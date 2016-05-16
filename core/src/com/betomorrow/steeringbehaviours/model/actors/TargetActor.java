package com.betomorrow.steeringbehaviours.model.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TargetActor extends Actor {
    private ShapeRenderer renderer = new ShapeRenderer();
    private float radius;

    public TargetActor() {
        radius = 4;
        setHeight(radius);
        setWidth(radius);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();

        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());

        renderer.translate(getX(), getY(), 0);
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.RED);
        renderer.circle(0, 0, radius);
        renderer.line(- radius * 2, 0, radius * 2, 0);
        renderer.line(0, - radius * 2, 0, radius * 2);
        renderer.end();

        batch.begin();
    }
}
