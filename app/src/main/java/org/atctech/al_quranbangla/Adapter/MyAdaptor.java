package org.atctech.al_quranbangla.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.atctech.al_quranbangla.Model.Constant;
import org.atctech.al_quranbangla.R;

import java.util.ArrayList;


public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.ViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<Constant> values = null;

    public MyAdaptor(Context context, ArrayList<Constant> values) {
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ramadan_times_row_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String seh = values.get(position).getSeheri();
        String ifta = values.get(position).getIftar();
        String date = values.get(position).getDate();
        holder.date.setText(date);
        holder.sehar.setText(seh);
        holder.iftar.setText(ifta);

    }

    @Override
    public int getItemCount() {
        return values != null ? values.size() : 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView date;
        public TextView sehar;
        public TextView iftar;

        public ViewHolder(View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.dateRamadan);
            sehar = itemView.findViewById(R.id.seharRamadan);
            iftar = itemView.findViewById(R.id.aftarRamadan);
        }
    }
}
