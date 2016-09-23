package com.betomorrow.steeringbehaviours;

import com.betomorrow.steeringbehaviours.ioc.DaggerGameComponent;
import com.betomorrow.steeringbehaviours.ioc.GameComponent;

public class DI {
    private static GameComponent gameComponent = null;

    public static GameComponent getGameComponent() {
        if (gameComponent == null) {
            gameComponent = DaggerGameComponent.create();
        }
        return gameComponent;
    }
}
