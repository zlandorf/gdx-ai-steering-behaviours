package com.betomorrow.steeringbehaviours.model.listeners;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.betomorrow.steeringbehaviours.DI;
import com.betomorrow.steeringbehaviours.model.Mapper;

public class ActorEntityListener implements EntityListener {
    @Override
    public void entityAdded(Entity entity) {
        DI.getGameComponent().stage().addActor(Mapper.actor.get(entity).actor);
    }

    @Override
    public void entityRemoved(Entity entity) {
        Mapper.actor.get(entity).actor.remove();
    }
}
