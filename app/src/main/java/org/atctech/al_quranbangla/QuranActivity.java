package org.atctech.al_quranbangla;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import org.atctech.al_quranbangla.Fragment.SearchFragment;
import org.atctech.al_quranbangla.Fragment.SurahFragment;

public class QuranActivity extends AppCompatActivity {

    private static Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("সূরা সমুহ");

        android.support.v4.app.FragmentManager fragmentManager;
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_fragment, SurahFragment.newInstance())
                .commit();


//        class SuraNameAdapter extends RecyclerView.Adapter<SuraNameAdapter.SuraViewHolder>
//        {
//
//
//            @NonNull
//            @Override
//            public SuraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_for_sura_name,parent,false);
//                return new SuraViewHolder(view);
//            }
//
//            @Override
//            public void onBindViewHolder(@NonNull SuraViewHolder holder, int position) {
//
//            }
//
//            @Override
//            public int getItemCount() {
//                return 0;
//            }
//
//            class SuraViewHolder extends RecyclerView.ViewHolder
//            {
//                TextView suraName;
//                public SuraViewHolder(View itemView) {
//                    super(itemView);
//
//                    suraName = itemView.findViewById(R.id.suraNameText);
//
//
//                }
//            }
//        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_out_right);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getSupportActionBar().setTitle("সূরা সমুহ");
    }

    @Override
    public void onBackPressed() {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        int count = fragmentManager.getBackStackEntryCount();
        if (count <= 0) {
            finish();
        } else {
            getSupportActionBar().setTitle("সূরা সমুহ");
        }
        super.onBackPressed();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//
//        getMenuInflater().inflate(R.menu.go_to_menu,menu);
//
//        MenuItem goto_btn  = menu.findItem(R.id.goto_action_btn);
//        goto_btn.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//
//                dialog = new Dialog(QuranActivity.this);
//                dialog.requestWindowFeature(1);
//                dialog.setContentView(R.layout.goto_layout);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.CYAN));
//                dialog.setCanceledOnTouchOutside(true);
//                dialog.show();
//                TextView dialougeSurah = dialog.findViewById(R.id.dialougeSurahNameList);
//                dialougeSurah.setText("");
//
//                return false;
//            }
//        });
//
//        return super.onCreateOptionsMenu(menu);
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.goto_btn,menu);
        MenuItem item = menu.findItem(R.id.action_btn);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(QuranActivity.this,SearchActivity.class));
                overridePendingTransition(R.anim.enter_from_left,R.anim.exit_out_left);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}
