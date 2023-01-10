package de.cubeside.cubesidestatswebapi.model;

import java.util.Collection;

public class PlayerStatsProviderList {
    private Collection<PlayerStatsProvider> providers;

    public PlayerStatsProviderList() {}

    public Collection<PlayerStatsProvider> getProviders() {
        return providers;
    }

    public void setProviders(Collection<PlayerStatsProvider> providers) {
        this.providers = providers;
    }
}
