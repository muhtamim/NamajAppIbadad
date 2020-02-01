package org.atctech.al_quranbangla.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.atctech.al_quranbangla.Model.RamadanTimes;
import org.atctech.al_quranbangla.R;

import java.util.ArrayList;

public class RamadanTimeAdapter extends RecyclerView.Adapter<RamadanTimeAdapter.RamadanTimeViewHolder> {

    ArrayList<RamadanTimes> timesArrayList;
    Context context;


    public RamadanTimeAdapter(ArrayList<RamadanTimes> timesArrayList, Context context) {
        this.timesArrayList = timesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RamadanTimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_for_ramadan_time, parent, false);
        return new RamadanTimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RamadanTimeViewHolder holder, int position) {


        holder.date.setText(timesArrayList.get(position).getDate());
        holder.day.setText(timesArrayList.get(position).getDay());
        holder.sehri.setText(timesArrayList.get(position).getSeheri());
        holder.iftar.setText(timesArrayList.get(position).getIftar());

    }

    @Override
    public int getItemCount() {
        return timesArrayList != null ? timesArrayList.size() : 0;
    }

    public class RamadanTimeViewHolder extends RecyclerView.ViewHolder {
        private TextView date, day, sehri, iftar;


        public RamadanTimeViewHolder(View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.ramadanDate);
            day = itemView.findViewById(R.id.ramadanDay);
            sehri = itemView.findViewById(R.id.ramadanSehri);
            iftar = itemView.findViewById(R.id.ramadanIftar);
        }
    }
}
