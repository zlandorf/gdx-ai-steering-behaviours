package com.betomorrow.steeringbehaviours.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.betomorrow.steeringbehaviours.SteeringBehavioursGame;

public class DesktopLauncher {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//        config.samples = 4;
        new LwjglApplication(new SteeringBehavioursGame(), config);
    }
}
