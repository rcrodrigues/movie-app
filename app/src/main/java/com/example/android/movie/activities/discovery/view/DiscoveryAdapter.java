package com.example.android.movie.activities.discovery.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.android.movie.R;
import com.example.android.movie.activities.discovery.entities.DiscoveryModel;
import com.example.android.movie.enums.MoviePosterSizeEnum;
import com.example.android.movie.utilities.NetworkUtils;

import java.net.URL;

public class DiscoveryAdapter extends RecyclerView.Adapter<DiscoveryViewHolder> {

    private DiscoveryModel[] discoveryModels;
    private Activity activity;
    private final DiscoveryAdapterOnClickHandler mClickHandler;
    private static final RequestOptions imageOptions = new RequestOptions().fitCenter();

    public DiscoveryAdapter(Activity activity, DiscoveryAdapterOnClickHandler clickHandler) {
        this.activity = activity;
        mClickHandler = clickHandler;
    }

    @NonNull
    @Override
    public DiscoveryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.discovery_view_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new DiscoveryViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscoveryViewHolder discoveryViewHolder, int i) {

        DiscoveryModel movie = discoveryModels[i];
        URL posterUrl = NetworkUtils.buildMoviePosterUrl(movie.getPosterPath(), MoviePosterSizeEnum.W342);

        Glide.with(activity)
                .load(posterUrl.toString())
                .apply(imageOptions)
                .into(discoveryViewHolder.mMoviePoster);
    }

    @Override
    public int getItemCount() {
        if (null == discoveryModels) return 0;
        return discoveryModels.length;
    }

    public void setDiscoveryModels(DiscoveryModel[] discoveryModels) {
        this.discoveryModels = discoveryModels;
        notifyDataSetChanged();
    }

    protected void callOnClickHandler(int adapterPosition) {

        DiscoveryModel discoveryModel = discoveryModels[adapterPosition];
        mClickHandler.onClick(discoveryModel);

    }


}
