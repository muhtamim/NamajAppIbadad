package org.atctech.al_quranbangla.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import org.atctech.al_quranbangla.Adapter.AyatAdapter;
import org.atctech.al_quranbangla.DB.GetAllSurahList;
import org.atctech.al_quranbangla.Model.Ayat;
import org.atctech.al_quranbangla.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener{

    AyatAdapter ayatAdapter;
    private RecyclerView ayatRecyclerView;
    private ArrayList<Ayat> ayatArrayList;

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        SearchFragment searchFragment = new SearchFragment();
        return searchFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        ayatArrayList = new ArrayList<>();
        GetAllSurahList getAllSurahList = new GetAllSurahList(getContext());
        ayatArrayList = getAllSurahList.GetAllAyat();

        ayatRecyclerView = view.findViewById(R.id.searchRecyclerView);
        ayatAdapter = new AyatAdapter(getContext(), ayatArrayList);
        ayatRecyclerView.setHasFixedSize(true);
        ayatRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        ayatRecyclerView.setItemAnimator(new DefaultItemAnimator());
        ayatRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        ayatRecyclerView.setAdapter(ayatAdapter);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.go_to_menu, menu);


        final MenuItem item = menu.findItem(R.id.goto_action_btn);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(item,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        ayatAdapter.setFilter(ayatArrayList);
                        return true;
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        return true;
                    }
                });

        super.onCreateOptionsMenu(menu, inflater);
    }

    private List<Ayat> filter( List<Ayat> models, String query) {
        query = query.toLowerCase();
        final List<Ayat> filteredModelList = new ArrayList<>();
        for (Ayat model : models) {
            final String text = model.getPara().toLowerCase() + ":" + model.getSura_id().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<Ayat> filteredModelList = filter(ayatArrayList, newText);
        ayatAdapter.setFilter(filteredModelList);
        return true;
    }
}
