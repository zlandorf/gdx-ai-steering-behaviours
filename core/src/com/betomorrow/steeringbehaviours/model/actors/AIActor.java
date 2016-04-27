package com.betomorrow.steeringbehaviours.model.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class AIActor extends Actor {
    private ShapeRenderer renderer = new ShapeRenderer();

    public AIActor() {
        setHeight(30);
        setWidth(20);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();

        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
        renderer.translate(getX(), getY(), 0);
        renderer.rotate(0, 0, 1, getRotation());

        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.BLUE);
        renderer.triangle(
            -getWidth() / 2, 0,
            0, getHeight(),
            getWidth() / 2, 0
        );
        renderer.end();

        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.RED);
        renderer.line(0, 0, 0, getHeight() * 2);
        renderer.end();

        batch.begin();
    }
}
