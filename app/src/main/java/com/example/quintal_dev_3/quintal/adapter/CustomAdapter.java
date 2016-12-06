package com.example.quintal_dev_3.quintal.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quintal_dev_3.quintal.R;

/**
 * Created by quintal-dev-3 on 05/12/16.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private static final String TAG = CustomAdapter.class.getName();

    private String[] dataDate;
    private String[] dataContent;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView eventDate;
        private final TextView eventContent;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View view) {
                    Log.d(TAG, "Element: " + getAdapterPosition() + " clicked");
                }
            });
            eventDate = (TextView) itemView.findViewById(R.id.tvEvent_date);
            eventContent = (TextView) itemView.findViewById(R.id.tvEvent);
        }

        public TextView getEventDate() {
            return eventDate;
        }

        public TextView getEventContent() {
            return eventContent;
        }
    }

    public CustomAdapter(String[] dataDateSet, String[] dataContentSet) {
        dataDate = dataDateSet;
        dataContent = dataContentSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.upcoming_events, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "Element: " + position + " set");

        holder.getEventDate().setText(dataDate[position]);
        holder.getEventContent().setText(dataContent[position]);
    }

    @Override
    public int getItemCount() {
        return dataDate.length;
    }
}
