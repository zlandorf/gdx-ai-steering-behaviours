package com.betomorrow.steeringbehaviours.model;

import com.badlogic.ashley.core.ComponentMapper;
import com.betomorrow.steeringbehaviours.model.components.AIComponent;
import com.betomorrow.steeringbehaviours.model.components.ActorComponent;
import com.betomorrow.steeringbehaviours.model.components.SteeringComponent;

public class Mapper {
    public static ComponentMapper<AIComponent> ai = ComponentMapper.getFor(AIComponent.class);
    public static ComponentMapper<ActorComponent> actor = ComponentMapper.getFor(ActorComponent.class);
    public static ComponentMapper<SteeringComponent> steering = ComponentMapper.getFor(SteeringComponent.class);
}
