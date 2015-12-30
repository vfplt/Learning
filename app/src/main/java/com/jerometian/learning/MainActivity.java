package com.jerometian.learning;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by jjtian on 2015/12/30.
 */

public class MainActivity extends AppCompatActivity {

    RoundProgressBar barStroke;
    RoundProgressBar barStrokeText;
    RoundProgressBar barFill;
    Timer updateTimer;
    TimerTask updateTimerTask;
    int currentValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barStroke = (RoundProgressBar) findViewById(R.id.barStroke);
        barStroke.setMax(100);

        barStrokeText = (RoundProgressBar) findViewById(R.id.barStrokeText);
        barStrokeText.setMax(100);

        barFill = (RoundProgressBar) findViewById(R.id.barFill);
        barFill.setMax(100);

        updateTimer = new Timer();

        updateTimerTask = new TimerTask() {
            @Override
            public void run() {
                currentValue += 1;
                barStroke.setValue(currentValue);
                barStrokeText.setValue(currentValue);
                barFill.setValue(currentValue);

                if (currentValue >= 100)
                    currentValue = 0;
            }
        };
        updateTimer.schedule(updateTimerTask, 0, 50);
    }
}
