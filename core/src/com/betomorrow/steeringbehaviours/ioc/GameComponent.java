package com.betomorrow.steeringbehaviours.ioc;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.betomorrow.steeringbehaviours.model.screens.AIScreen;
import com.betomorrow.steeringbehaviours.model.systems.MovingActorSystem;
import com.betomorrow.steeringbehaviours.model.systems.SteeringSystem;
import dagger.Component;

import javax.inject.Singleton;

@Component(
    modules = GameModule.class
)
@Singleton
public interface GameComponent {
    AIScreen aiScreen();
    Stage stage();
    Engine engine();

    SteeringSystem steeringSystem();
    MovingActorSystem movingActorSystem();

}
