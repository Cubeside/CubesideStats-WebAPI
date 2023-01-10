package de.cubeside.cubesidestatswebapi.model;

public class PlayerStatsProvider {
    private String id;
    private String title;
    private String defaultValue;

    public PlayerStatsProvider() {}

    public PlayerStatsProvider(String id, String title, String defaultValue) {
        this.id = id;
        this.title = title;
        this.defaultValue = defaultValue;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
