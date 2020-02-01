package org.atctech.al_quranbangla;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        MediaPlayer.create(SplashActivity.this, R.raw.bismillah).start();

        TextView splashAppName = findViewById(R.id.splashText);
        //ImageView splashImage = findViewById(R.id.splashImage);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.transition_anim);
        //splashImage.setAnimation(animation);
        splashAppName.setAnimation(animation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,IntroActivity.class));
                finish();
            }
        }, 6000);
    }
}
