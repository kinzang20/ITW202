package com.example.todo_18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder> {
    private ArrayList<Sport> mSportsData;
    private Context mContext;

    SportsAdapter(Context context, ArrayList<Sport> SportsData){
        this.mSportsData = SportsData;
        this.mContext = context;

    }
    @NonNull
    @Override
    public SportsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SportsAdapter.ViewHolder holder, int position) {
        Sport currentSport = mSportsData.get(position);
        holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return mSportsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mtitleText;
        private TextView mInfoText;
        private ImageButton msportsImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mtitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subtitle);
            msportsImage = (ImageButton) itemView.findViewById(R.id.sportsImage);
        }
        void  bindTo(Sport currentSports){
            mtitleText.setText(currentSports.getTitle());
            mInfoText.setText(currentSports.getInfo());
            Glide.with(mContext).load(currentSports.getImageResource()).into(msportsImage);

        }
    }
}
