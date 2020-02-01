package org.atctech.al_quranbangla.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.atctech.al_quranbangla.Model.NamazTimes;
import org.atctech.al_quranbangla.R;
import org.atctech.al_quranbangla.Utilities.Utils;

import java.util.ArrayList;

public class NamazTimeAdapter extends RecyclerView.Adapter<NamazTimeAdapter.NamazTimeViewHolder> {

    ArrayList<NamazTimes> namazTimes;
    private Context context;


    public NamazTimeAdapter(ArrayList<NamazTimes> namazTimes, Context context) {
        this.namazTimes = namazTimes;
        this.context = context;
    }

    @NonNull
    @Override
    public NamazTimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_for_namaz_time_show, parent, false);
        return new NamazTimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NamazTimeViewHolder holder, int position) {

        holder.fajr.setText(Utils.getBnNumber(namazTimes.get(position).getFajr()));
        holder.johor.setText(Utils.getBnNumber(namazTimes.get(position).getDhuhr()));
        holder.asor.setText(Utils.getBnNumber(namazTimes.get(position).getAsr()));
        holder.maghrib.setText(Utils.getBnNumber(namazTimes.get(position).getMaghrib()));
        holder.esha.setText(Utils.getBnNumber(namazTimes.get(position).getIsha()));

    }

    @Override
    public int getItemCount() {
        return namazTimes != null ? namazTimes.size() : 0;
    }

    public class NamazTimeViewHolder extends RecyclerView.ViewHolder {
        TextView fajr, johor, asor, maghrib, esha;

        public NamazTimeViewHolder(View itemView) {
            super(itemView);

            fajr = itemView.findViewById(R.id.fajrTime);
            johor = itemView.findViewById(R.id.johorTime);
            asor = itemView.findViewById(R.id.asorTime);
            maghrib = itemView.findViewById(R.id.maghribTime);
            esha = itemView.findViewById(R.id.ishaTIme);
        }
    }
}
