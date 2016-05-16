package com.betomorrow.steeringbehaviours.model.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.betomorrow.steeringbehaviours.model.steeringbehaviours.Seek;
import com.betomorrow.steeringbehaviours.model.steeringbehaviours.SteeringBehaviour;

public class SteeringComponent implements Component {
    public List<SteeringBehaviour> steeringBehaviours;
    public Seek seek;

    public SteeringComponent(List<SteeringBehaviour> steeringBehaviours) {
        this.steeringBehaviours = steeringBehaviours;
    }
}
