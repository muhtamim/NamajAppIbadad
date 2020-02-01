package org.atctech.al_quranbangla;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import org.atctech.al_quranbangla.Fragment.AyatFragment;

public class SurahDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_details);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);


        Bundle bundle = this.getIntent().getExtras();
        String title = bundle.getString("sura_name");

        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        android.support.v4.app.FragmentManager fragmentManager;
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_frame, AyatFragment.newInstance())
                .commit();
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
}
