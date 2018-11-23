package com.example.android.movie.activities.discovery.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.android.movie.R;

public class DiscoveryViewHolder extends RecyclerView.ViewHolder {

    public final ImageView mMoviePoster;

    public DiscoveryViewHolder(@NonNull View itemView) {
        super(itemView);
        mMoviePoster = itemView.findViewById(R.id.imageView1);
    }


}
