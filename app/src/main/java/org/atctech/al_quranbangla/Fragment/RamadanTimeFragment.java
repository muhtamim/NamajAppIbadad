package org.atctech.al_quranbangla.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.atctech.al_quranbangla.Adapter.RamadanTimeAdapter;
import org.atctech.al_quranbangla.DB.NamazAndRamadanTImeDB;
import org.atctech.al_quranbangla.Model.RamadanTimes;
import org.atctech.al_quranbangla.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RamadanTimeFragment extends Fragment {

    ArrayList<RamadanTimes> ramadanTimesArrayList;
    RecyclerView ramadanRecyclerView;
    RamadanTimeAdapter adapter;
    String division_name;

    public RamadanTimeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        int city_id = bundle.getInt("city_id");
        division_name = bundle.getString("division_name");
        NamazAndRamadanTImeDB tImeDB = new NamazAndRamadanTImeDB(getContext());
        ramadanTimesArrayList = new ArrayList<>();
        ramadanTimesArrayList = tImeDB.GetAllCitysRamadanTime(city_id);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ramadan_time, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(division_name);

        ramadanRecyclerView = view.findViewById(R.id.ramadanTimeShowRecyclerView);

        adapter = new RamadanTimeAdapter(ramadanTimesArrayList, getContext());


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ramadanRecyclerView.setHasFixedSize(true);
        ramadanRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        ramadanRecyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.devider));
        ramadanRecyclerView.addItemDecoration(itemDecoration);
        ramadanRecyclerView.setAdapter(adapter);
    }
}
