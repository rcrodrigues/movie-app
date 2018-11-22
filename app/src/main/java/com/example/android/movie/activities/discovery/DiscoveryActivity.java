package com.example.android.movie.activities.discovery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.example.android.movie.R;

public class DiscoveryActivity extends AppCompatActivity implements DiscoveryContract.View {

    private DiscoveryContract.Presenter presenter;
    private Button btButao;
    private TextView tvText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discovery);

        // Instantiate an interactor for the Discovery Activity
        presenter = new DiscoveryPresenter(this);

        initComponents();
    }

    void initComponents() {
        tvText = findViewById(R.id.textView);
        btButao = findViewById(R.id.button);
        btButao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                presenter.presentText();
            }
        });
    }


    @Override
    public void showText(String texto) {
        tvText.setText(texto);
    }
}
