package de.cubeside.cubesidestatswebapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.cubeside.cubesidestatswebapi.model.PlayerStatsEntry;
import de.cubeside.cubesidestatswebapi.model.PlayerStatsObject;
import de.cubeside.cubesidestatswebapi.model.PlayerStatsProvider;
import de.cubeside.cubesidestatswebapi.model.PlayerStatsProviderList;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CubesideStats implements StatsAPI {

    public static final Logger logger = Logger.getLogger("CubesideStats-WebAPI");
    private static final String url = "https://webinterface.cubeside.de/api/stats/";

    private final Gson gson;

    public CubesideStats() {
        this.gson = new GsonBuilder().create();
    }

    @Override
    public Collection<PlayerStatsProvider> getAllStatsKeys() {
        //https://webinterface.cubeside.de/api/stats/list
        try {
            String json = Jsoup.connect(url + "list")
                    .ignoreContentType(true)
                    .execute()
                    .body();

            return gson.fromJson(json, PlayerStatsProviderList.class).getProviders();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "", e);
            return null;
        }
    }

    @Override
    public PlayerStatsEntry getStatsFromPlayerOrUUID(String statsKey, String nameOrUUID) {
        return getStatsFromPlayersOrUUIDs(statsKey, Collections.singleton(nameOrUUID)).stream().findFirst().get();
    }

    @Override
    public Collection<PlayerStatsEntry> getStatsFromPlayersOrUUIDs(String statsKey, Collection<String> listOfNameOrUUID) {
        //https://webinterface.cubeside.de/api/stats/entries?id=christmas&player=brokkonaut&player=fantahund
        StringBuilder sb = new StringBuilder();
        sb.append(url).append("entries?id=").append(statsKey);
        for (String s : listOfNameOrUUID) {
            sb.append("&player=").append(s);
        }
        try {
            String json = Jsoup.connect(sb.toString()).ignoreContentType(true).execute().body();
            return gson.fromJson(json, PlayerStatsObject.class).getEntries();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "", e);
            return null;
        }
    }

    @Override
    public PlayerStatsEntry getStatsFromPosition(String statsKey, int position) {
        return getStatsFromPositionRange(statsKey, position, position).stream().findFirst().get();
    }

    @Override
    public Collection<PlayerStatsEntry> getStatsFromPositionRange(String statsKey, int startPos, int endPos) {
        //https://webinterface.cubeside.de/api/stats/top?id=questxp&start=30&count=30
        StringBuilder sb = new StringBuilder();
        sb.append(url).append("top?id=").append(statsKey).append("&start=").append(startPos).append("&count=").append(endPos);
        try {
            String json = Jsoup.connect(sb.toString()).ignoreContentType(true).execute().body();
            return gson.fromJson(json, PlayerStatsObject.class).getEntries();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "", e);
            return null;
        }
    }
}
