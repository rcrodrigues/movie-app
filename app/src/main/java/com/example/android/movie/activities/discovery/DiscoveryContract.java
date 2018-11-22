package com.example.android.movie.activities.discovery;

public interface DiscoveryContract {

    interface View{
        void showText(String texto);
    }

    interface Interactor {
        String fetchText();
    }

    interface Presenter {
        void presentText();
    }

}
