package com.betomorrow.steeringbehaviours.ioc;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.betomorrow.steeringbehaviours.model.screens.AIScreen;
import com.betomorrow.steeringbehaviours.model.systems.MovingActorSystem;
import com.betomorrow.steeringbehaviours.model.systems.SteeringSystem;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class GameModule {
    @Provides @Singleton
    static Stage provideStage() {
        return new Stage(new ScreenViewport());
    }

    @Provides @Singleton
    static Engine provideEngine() {
        return new Engine();
    }

    @Provides @Singleton
    static SteeringSystem steeringSystem() {
        return new SteeringSystem();
    }

    @Provides @Singleton
    static MovingActorSystem movingActorSystem() {
        return new MovingActorSystem();
    }
}
