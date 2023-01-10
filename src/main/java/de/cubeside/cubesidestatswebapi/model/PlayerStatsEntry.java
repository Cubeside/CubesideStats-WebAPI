package de.cubeside.cubesidestatswebapi.model;

import java.util.UUID;

public class PlayerStatsEntry {

    private UUID uuid;
    private String name;
    private int position;
    private int displayPosition;
    private String value;

    public PlayerStatsEntry() {
    }

    public PlayerStatsEntry(UUID uuid, String name, int position, int displayPosition, String value) {
        this.uuid = uuid;
        this.name = name;
        this.position = position;
        this.displayPosition = displayPosition;
        this.value = value;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getDisplayPosition() {
        return displayPosition;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setDisplayPosition(int displayPosition) {
        this.displayPosition = displayPosition;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
