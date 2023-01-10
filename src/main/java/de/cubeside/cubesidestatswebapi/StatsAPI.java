package de.cubeside.cubesidestatswebapi;

import de.cubeside.cubesidestatswebapi.model.PlayerStatsEntry;
import de.cubeside.cubesidestatswebapi.model.PlayerStatsProvider;

import java.util.Collection;

public interface StatsAPI {
    /**
     * Get a collection of all StatsKeys
     *
     * @return a collection of all StatsKeys
     */
    public Collection<PlayerStatsProvider> getAllStatsKeys();

    /**
     * Get PlayerStatsEntry from a player or uuid
     *
     * @return a PlayerStatsEntry
     */
    public PlayerStatsEntry getStatsFromPlayerOrUUID(String statsKey, String nameOrUUID);

    /**
     * Get a collection of PlayerStatsEntry from players or uuids
     *
     * @return a collection of PlayerStatsEntry
     */
    public Collection<PlayerStatsEntry> getStatsFromPlayersOrUUIDs(String statsKey, Collection<String> listOfNameOrUUID);

    /**
     * Get PlayerStatsEntry from a position
     *
     * @return a PlayerStatsEntry
     */
    public PlayerStatsEntry getStatsFromPosition(String statsKey, int position);

    /**
     * Get a collection of PlayerStatsEntry from positions
     *
     * @return a collection of PlayerStatsEntry
     */
    public Collection<PlayerStatsEntry> getStatsFromPositionRange(String statsKey, int startPos, int endPos);
}
