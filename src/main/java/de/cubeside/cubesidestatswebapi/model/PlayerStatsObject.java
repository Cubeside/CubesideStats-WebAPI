package de.cubeside.cubesidestatswebapi.model;

import java.util.Collection;

public class PlayerStatsObject {
    private PlayerStatsProvider provider;
    private Collection<PlayerStatsEntry> entries;

    public PlayerStatsObject() {}

    public PlayerStatsProvider getProvider() {
        return provider;
    }

    public Collection<PlayerStatsEntry> getEntries() {
        return entries;
    }

    public void setProvider(PlayerStatsProvider provider) {
        this.provider = provider;
    }

    public void setEntries(Collection<PlayerStatsEntry> entries) {
        this.entries = entries;
    }
}
