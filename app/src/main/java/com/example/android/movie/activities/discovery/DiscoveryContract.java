package com.example.android.movie.activities.discovery;

import com.example.android.movie.activities.discovery.entities.DiscoveryModel;
import com.example.android.movie.enums.DiscoveryFilterEnum;

public interface DiscoveryContract {

    interface View{
        void showMovies(DiscoveryModel[] discoveryModels);
        void showLoading();
        void hideLoading();
    }

    interface Presenter {
        void discover(DiscoveryFilterEnum filter);
    }
}
