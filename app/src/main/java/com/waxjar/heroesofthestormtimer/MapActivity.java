package com.waxjar.heroesofthestormtimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        final Button start_button = (Button) findViewById(R.id.main_button);
        final View inside_circle = findViewById(R.id.timer);
        final TextView info_text = (TextView) findViewById(R.id.info_text);
        final TextView bruiser = (TextView) findViewById(R.id.bruiser);
        final TextView merc = (TextView) findViewById(R.id.merc);
        final TextView boss = (TextView) findViewById(R.id.boss);
        RelativeLayout main_layout = (RelativeLayout) findViewById(R.id.activity_main);
        // Keeps the phone from shutting off
        main_layout.setKeepScreenOn(true);

        // Get Map
        final Map map = (Map) getIntent().getSerializableExtra("MAP");

        // Set camps text - currently not used
        bruiser.setText(map.getBruiserInfo());
        merc.setText(map.getMercInfo());
        boss.setText(map.getBossInfo());

        // Set background
        main_layout.setBackgroundResource(map.getTallImage());

        // Countdown timer
        final CountDownTimer timer = new CountDownTimer(map.getTimer(), 1000) {

            public void onTick(long millisUntilFinished) {
                long time = millisUntilFinished / 1000;
                start_button.setText(Long.toString(time));
            }

            public void onFinish() {
                start_button.setText(map.timeText());
                info_text.setText(map.getInfoText());
                // The first timer may be different the the rest so update to the second time
                map.setFirst();
            }
        };

        // Animation for growing circle
        final float scale = this.getResources().getDisplayMetrics().density;
        final int anim_start_size = (int) (10 * scale + 0.5f);
        final ScaleAnimation growAnim = new ScaleAnimation(1.0f, 19.4f, 1.0f, 19.4f, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        growAnim.setDuration(map.getTimer());
        growAnim.setFillEnabled(true);
        growAnim.setFillAfter(true);

        // Button click
        start_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Start the animation
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) inside_circle.getLayoutParams();
                layoutParams.height = anim_start_size;
                layoutParams.width  = anim_start_size;
                inside_circle.setLayoutParams(layoutParams);
                inside_circle.startAnimation(growAnim);
                timer.start();
            }
        });


    }
}
