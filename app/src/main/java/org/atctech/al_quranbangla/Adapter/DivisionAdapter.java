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

import org.atctech.al_quranbangla.Fragment.RamadanTimeFragment;
import org.atctech.al_quranbangla.Interface.OnItemClickListener;
import org.atctech.al_quranbangla.Model.Division;
import org.atctech.al_quranbangla.R;
import org.atctech.al_quranbangla.Utilities.Utils;

import java.util.ArrayList;

public class DivisionAdapter extends RecyclerView.Adapter<DivisionAdapter.DivisionViewHolder> {

    private Context context;
    private ArrayList<Division> divisions;


    public DivisionAdapter(Context context, ArrayList<Division> divisions) {
        this.context = context;
        this.divisions = divisions;
    }

    @NonNull
    @Override
    public DivisionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_for_division_name, parent, false);

        return new DivisionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DivisionViewHolder holder, final int position) {
        holder.id.setText(Utils.getBnNumber(divisions.get(position).getId() + "."));
        holder.name.setText(divisions.get(position).getName());


        holder.SetOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                RamadanTimeFragment ramadanTimeFragment = new RamadanTimeFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("city_id", divisions.get(position).getC_id());
                bundle.putString("division_name", divisions.get(position).getName());
                ramadanTimeFragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_left, R.anim.exit_out_left).replace(R.id.division_fragment, ramadanTimeFragment).addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return divisions != null ? divisions.size() : 0;
    }

    public class DivisionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private OnItemClickListener onItemClickListener;
        private TextView id, name;

        public DivisionViewHolder(View itemView) {
            super(itemView);


            id = itemView.findViewById(R.id.divisionNameId);
            name = itemView.findViewById(R.id.divisionNameView);
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
