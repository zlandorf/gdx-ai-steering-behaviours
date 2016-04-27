package com.betomorrow.steeringbehaviours.model.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorComponent implements Component {
    public Actor actor;

    public ActorComponent(Actor actor) {
        this.actor = actor;
        actor.setPosition(50, 50);
    }
}
