package com.example.retrofittestjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofittestjava.Data.Entity;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView rank, title, todayCnt, totalCnt, upDown;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rank = itemView.findViewById(R.id.rank);
            title = itemView.findViewById(R.id.title);
            todayCnt = itemView.findViewById(R.id.todayCount);
            totalCnt = itemView.findViewById(R.id.totalCount);
            upDown = itemView.findViewById(R.id.upDown);

        }
    }

    public RecyclerAdapter() {

    }

    public RecyclerAdapter(ArrayList<Entity> data) {
        changeData(data);
    }

    public void changeData(ArrayList<Entity> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    private ArrayList<Entity> data = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Entity item = data.get(position);

        holder.rank.setText(item.getRank());
        holder.title.setText(item.getMovieNm());
        holder.todayCnt.setText(item.getAudiCnt());
        holder.totalCnt.setText(item.getAudiAcc());

        int rankUpDownCount = Integer.parseInt(item.getRankInten());
        String upDownText = "-";
        if (rankUpDownCount > 0) {
            upDownText = "+" + rankUpDownCount;
        } else if (rankUpDownCount < 0) {
            upDownText = rankUpDownCount + "";
        } else {
            upDownText = "-";
        }
        holder.upDown.setText(upDownText);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
