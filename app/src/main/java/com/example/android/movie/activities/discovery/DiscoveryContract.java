package com.example.android.movie.activities.discovery;

import android.app.Activity;

import com.example.android.movie.enums.DiscoveryFilterEnum;

import java.net.URL;

public interface DiscoveryContract {

    interface View{
        void showMovies(DiscoveryModel[] texto);
        DiscoveryModel[] getMovies(URL endpoint);
    }

    interface Interactor {
        DiscoveryModel[] loadData(DiscoveryFilterEnum filter, DiscoveryContract.View view);
    }

    interface Presenter {
        void discover();
    }

}
