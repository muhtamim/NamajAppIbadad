package org.atctech.al_quranbangla.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.atctech.al_quranbangla.Fragment.NamazTimeFragment;
import org.atctech.al_quranbangla.Interface.OnItemClickListener;
import org.atctech.al_quranbangla.Model.CityName;
import org.atctech.al_quranbangla.R;
import org.atctech.al_quranbangla.Utilities.Utils;

import java.util.ArrayList;

public class CityNameAdapter extends RecyclerView.Adapter<CityNameAdapter.CityNameViewHolder> {

    private ArrayList<CityName> cityNames;
    private Context context;

    public CityNameAdapter(ArrayList<CityName> cityNames, Context context) {
        this.cityNames = cityNames;
        this.context = context;
    }

    @NonNull
    @Override
    public CityNameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_for_city_name, parent, false);
        return new CityNameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityNameViewHolder holder, final int position) {

        holder.id.setText(Utils.getBnNumber(cityNames.get(position).getId() + "."));
        holder.name.setText(cityNames.get(position).getName());

        holder.SetOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                NamazTimeFragment namazTimeFragment = new NamazTimeFragment();
                Bundle bundle = new Bundle();
                bundle.putString("city_id", cityNames.get(position).getId());
                bundle.putString("city_name", cityNames.get(position).getName());
                namazTimeFragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_left, R.anim.exit_out_left).replace(R.id.namaz_time_fragment, namazTimeFragment).addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return cityNames != null ? cityNames.size() : 0;
    }

    public class CityNameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private OnItemClickListener onItemClickListener;
        private TextView id, name;


        public CityNameViewHolder(View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.cityNameId);
            name = itemView.findViewById(R.id.cityNameView);
            itemView.setOnClickListener(this);
        }

        public void SetOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(v);
        }


    }
}
