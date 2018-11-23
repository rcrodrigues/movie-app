package com.example.android.movie.activities.discovery;

import com.example.android.movie.enums.DiscoveryFilterEnum;

public class DiscoveryPresenter implements DiscoveryContract.Presenter{

    DiscoveryContract.View view;
    DiscoveryContract.Interactor interactor;

    public DiscoveryPresenter(DiscoveryContract.View view) {
        this.view = view;
        this.interactor = new DiscoveryInteractor();
    }

    @Override
    public void discover() {
        DiscoveryModel[] discoveryModels = interactor.loadData(DiscoveryFilterEnum.POPULAR_MOVIES_PATH, view);
        view.showMovies(discoveryModels);
    }
}
