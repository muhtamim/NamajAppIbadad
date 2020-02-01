package org.atctech.al_quranbangla.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.atctech.al_quranbangla.Adapter.NamazTimeAdapter;
import org.atctech.al_quranbangla.DB.NamazAndRamadanTImeDB;
import org.atctech.al_quranbangla.Model.NamazTimes;
import org.atctech.al_quranbangla.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NamazTimeFragment extends Fragment {

    NamazTimeAdapter adapter;
    TextView choosedCityName;
    String city_name;
    private ArrayList<NamazTimes> namazTimes;
    private RecyclerView namazRecyclerView;

    public NamazTimeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        int city_id = Integer.parseInt(bundle.getString("city_id"));
        city_name = bundle.getString("city_name");
        namazTimes = new ArrayList<>();
        NamazAndRamadanTImeDB ramadanTImeDB = new NamazAndRamadanTImeDB(getContext());
        namazTimes = ramadanTImeDB.GetAllCitysNamazTime(city_id);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_namaz_time, container, false);

//        ((AppCompatActivity)getActivity()).getSupportActionBar ().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        ((AppCompatActivity)getActivity()).getSupportActionBar ().setCustomView(R.layout.custom_action_bar_2);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("নামাজের সময়সূচি");

//        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy");
//        String cdate = df.format(Calendar.getInstance().getTime());
//        DateFormat tf = new SimpleDateFormat("h:mm a");
//        String ctime = tf.format(Calendar.getInstance().getTime());
//
//        currentTime =view.findViewById(R.id.idTvTimeHomeRamadan);
//        currentTime.setText(ctime);
//        currentDate = view.findViewById(R.id.idTvDateHomeRamdan);
//        currentDate.setText(cdate);


        namazRecyclerView = view.findViewById(R.id.namaz_show_recycler_view);
        choosedCityName = view.findViewById(R.id.choosedCityName);
        choosedCityName.setText(city_name);
        adapter = new NamazTimeAdapter(namazTimes, getContext());

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        namazRecyclerView.setHasFixedSize(true);
        namazRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
//        namazRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
//        itemDecoration.setDrawable(ContextCompat.getDrawable(getContext(),R.drawable.devider));
//        namazRecyclerView.addItemDecoration(itemDecoration);
        namazRecyclerView.setAdapter(adapter);
    }
}
