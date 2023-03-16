package com.foofinc.mods.JavaFX;

import java.net.URL;

public enum CssManager {

    INSTANCE;

    //TODO Css paths
    private final String CssPath = "fakePath";

    public String getCssUrl() {
        URL cssUrl = getClass().getResource(CssPath);
        if (cssUrl == null) {
            System.out.println("Resource not found. Aborting application.");
            System.exit(-1);
        }
        return cssUrl.toExternalForm();
    }

    /*
    TODO Example of using persistence (Optional)

    TODO Css paths
    private final String lightCssPath = "/css/light.css";
    private final String darkCssPath = "/css/dark.css";

    TODO Settings persistence
    private final SerializableSettings settings = PersistenceManager.INSTANCE.getSettings();

    public String getCssUrl() {
        URL cssUrl = !settings.isDarkMode() ?
                getClass().getResource(lightCssPath) : getClass().getResource(darkCssPath);

        if (cssUrl == null) {
            System.out.println("Resource not found. Aborting application.");
            System.exit(-1);
        }
        return cssUrl.toExternalForm();
    }
    */
}
