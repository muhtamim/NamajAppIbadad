package org.atctech.al_quranbangla;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.atctech.al_quranbangla.Utilities.Utils;
import static org.atctech.al_quranbangla.Utilities.Utils.getPreferencesInt;
import static org.atctech.al_quranbangla.Utilities.Utils.savePreferencesInt;

public class TasbeehActivity extends AppCompatActivity {

    int counter;

    Button add;
    Button reset, save;
    TextView display;
    Context context;
    PowerManager.WakeLock wakeLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbeeh);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        context = this;

//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.custom_action_bar_2);
        getSupportActionBar().setTitle("তসবীহ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Lock");
        wakeLock.acquire();

        add = findViewById(R.id.bAdd);
        reset = findViewById(R.id.ivresettasbeeh);
        save = findViewById(R.id.ivsavetasbeeh);
        display = findViewById(R.id.tvDisplay);

        counter = getPreferencesInt("Tasbeeh", context);
        display.setText(Utils.getBnNumber("" + counter));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePreferencesInt("Tasbeeh", counter, context);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                counter++;
                display.setText(Utils.getBnNumber("" + counter));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                savePreferencesInt("Tasbeeh", 0, context);
                counter = 0;
                display.setText(Utils.getBnNumber("" + counter));
            }
        });

    }


    @Override
    protected void onPause() {
        super.onPause();
        wakeLock.release();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_VOLUME_UP:
                    // Volume up key detected
                    counter++;
                    display.setText(Utils.getBnNumber("" + counter));
//                    Toast.makeText(context, "Up", Toast.LENGTH_SHORT).show();
                    return true;
                case KeyEvent.KEYCODE_VOLUME_DOWN:
                    // Volume down key detected
                    if (counter != 0) {
                        counter--;
                        display.setText(Utils.getBnNumber("" + counter));
                    }

                    return true;
            }
        }

        return super.dispatchKeyEvent(event);
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
