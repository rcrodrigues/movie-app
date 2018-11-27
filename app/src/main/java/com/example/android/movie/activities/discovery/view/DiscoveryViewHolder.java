package com.example.android.movie.activities.discovery.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.android.movie.R;

public class DiscoveryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public final ImageView mMoviePoster;
    private final DiscoveryAdapter mDiscoveryAdapter;

    public DiscoveryViewHolder(@NonNull View itemView, DiscoveryAdapter adapter) {
        super(itemView);
        mDiscoveryAdapter = adapter;
        mMoviePoster = itemView.findViewById(R.id.poster_image);
        mMoviePoster.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int adapterPosition = getAdapterPosition();
        mDiscoveryAdapter.callOnClickHandler(adapterPosition);

    }
}
