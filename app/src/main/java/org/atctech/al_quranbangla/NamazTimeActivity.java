package org.atctech.al_quranbangla;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import org.atctech.al_quranbangla.Fragment.CityFragment;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NamazTimeActivity extends AppCompatActivity {

    TextView currentDate, currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namaz_time);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy");
        String cdate = df.format(Calendar.getInstance().getTime());
//        DateFormat tf = new SimpleDateFormat("h:mm a");
//        String ctime = tf.format(Calendar.getInstance().getTime());

//
//        currentTime =findViewById(R.id.idTvTimeHomeRamadan);
//        currentTime.setText(ctime);
        currentDate = findViewById(R.id.idTvDateHomeRamdan);
        currentDate.setText(cdate);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.namaz_time_fragment, CityFragment.newInstance())
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
