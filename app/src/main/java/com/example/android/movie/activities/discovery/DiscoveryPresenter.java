package com.example.android.movie.activities.discovery;

public class DiscoveryPresenter implements DiscoveryContract.Presenter{

    DiscoveryContract.View view;
    DiscoveryContract.Interactor interactor;

    public DiscoveryPresenter(DiscoveryContract.View view) {
        this.view = view;
        this.interactor = new DiscoveryInteractor();
    }

    @Override
    public void presentText() {

        String text = interactor.fetchText();
        view.showText(text);
    }

}
