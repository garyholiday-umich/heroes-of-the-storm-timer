package com.waxjar.heroesofthestormtimer;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MapAdapter extends RecyclerView.Adapter<MapAdapter.ViewHolder> {
    private Map[] maps;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mapName;
        public ImageView mapImage;
        public ViewHolder(View v) {
            super(v);
            mapName = (TextView) v.findViewById(R.id.map_name);
            mapImage = (ImageView) v.findViewById(R.id.map_image);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MapAdapter(Map[] maps, Context context) {
        this.maps = maps;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MapAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.map_card, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mapName.setText(maps[position].getTitle());
        holder.mapImage.setBackgroundResource(maps[position].getImage());

        holder.mapImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MapActivity.class);
                intent.putExtra("MAP", maps[position]);
                context.startActivity(intent);
            }

        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return maps.length;
    }
}