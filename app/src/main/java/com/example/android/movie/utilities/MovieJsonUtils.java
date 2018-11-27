package com.example.android.movie.utilities;

import com.example.android.movie.activities.discovery.entities.DiscoveryModel;
import com.example.android.movie.activities.discovery.entities.DiscoveryPage;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public final class MovieJsonUtils {

    public static DiscoveryModel[] getDiscoveryDataFromJson(String discoveryJsonStr) {

        JsonParser parser = new JsonParser();
        JsonElement mJson =  parser.parse(discoveryJsonStr);
        Gson gson = new Gson();
        DiscoveryPage page = gson.fromJson(mJson, DiscoveryPage.class);

        if(page.getResults() == null) {
            return null;
        }

        DiscoveryModel[] modelArray = new DiscoveryModel[page.getResults().size()];

        return page.getResults().toArray(modelArray);
    }
}
