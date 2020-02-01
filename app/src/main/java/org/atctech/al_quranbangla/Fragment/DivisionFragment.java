package org.atctech.al_quranbangla.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.atctech.al_quranbangla.Adapter.DivisionAdapter;
import org.atctech.al_quranbangla.DB.NamazAndRamadanTImeDB;
import org.atctech.al_quranbangla.Model.Division;
import org.atctech.al_quranbangla.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DivisionFragment extends Fragment {
    private ArrayList<Division> divisionNames;
    private RecyclerView divisionRecyclerView;
    private DivisionAdapter adapter;

    public DivisionFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        DivisionFragment divisionFragment = new DivisionFragment();
        return divisionFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NamazAndRamadanTImeDB tImeDB = new NamazAndRamadanTImeDB(getContext());
        divisionNames = new ArrayList<>();
        divisionNames = tImeDB.GetAllDivisionName();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_division, container, false);

        divisionRecyclerView = view.findViewById(R.id.divisionNameRecyclerView);
        adapter = new DivisionAdapter(getContext(), divisionNames);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        divisionRecyclerView.setHasFixedSize(true);
        divisionRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        divisionRecyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration itemDecorator = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.devider));
        divisionRecyclerView.addItemDecoration(itemDecorator);
        divisionRecyclerView.setAdapter(adapter);
    }
}
