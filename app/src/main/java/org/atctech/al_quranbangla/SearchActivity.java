package org.atctech.al_quranbangla;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import org.atctech.al_quranbangla.Fragment.SearchFragment;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().setTitle("খুজুন");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.search_frame, SearchFragment.newInstance())
                .commitAllowingStateLoss();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_from_right,R.anim.exit_out_right);
    }
}
