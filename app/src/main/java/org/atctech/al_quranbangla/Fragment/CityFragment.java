package org.atctech.al_quranbangla.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.atctech.al_quranbangla.Adapter.CityNameAdapter;
import org.atctech.al_quranbangla.DB.NamazAndRamadanTImeDB;
import org.atctech.al_quranbangla.Model.CityName;
import org.atctech.al_quranbangla.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CityFragment extends Fragment {

    private ArrayList<CityName> cityNames;
    private RecyclerView cityRecyclerView;
    private CityNameAdapter adapter;


    public CityFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        CityFragment cityFragment = new CityFragment();
        return cityFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NamazAndRamadanTImeDB tImeDB = new NamazAndRamadanTImeDB(getContext());
        cityNames = new ArrayList<>();
        cityNames = tImeDB.GetAllCityName();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_city, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setCustomView(R.layout.custom_action_bar_2);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cityRecyclerView = view.findViewById(R.id.cityNameRecyclerView);
        adapter = new CityNameAdapter(cityNames, getContext());

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cityRecyclerView.setHasFixedSize(true);
        cityRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        cityRecyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration itemDecorator = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.devider));
        cityRecyclerView.addItemDecoration(itemDecorator);
        cityRecyclerView.setAdapter(adapter);
    }
}
