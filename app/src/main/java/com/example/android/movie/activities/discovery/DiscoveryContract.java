package com.example.android.movie.activities.discovery;

import com.example.android.movie.enums.DiscoveryFilterEnum;

public interface DiscoveryContract {

    interface View{
        void showMovies(DiscoveryModel[] texto);
    }

    interface Interactor {
    }

    interface Presenter {
        void discover(DiscoveryFilterEnum filter);
    }
}
