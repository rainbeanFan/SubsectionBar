package com.jyn.subsectionbar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jyn.subsectionprogressbar.SubsectionProgressBar;
import com.jyn.subsectionseekbar.SeekBarBean;
import com.jyn.subsectionseekbar.SubsectionSeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        SubsectionProgressBar subsectionpb = findViewById(R.id.subsectionpb);
        subsectionpb.setMaxProgress(100);
        SubsectionSeekBar rangeSeekBar = findViewById(R.id.range_seek_bar);
        final TextView seekbarTx = findViewById(R.id.seekbar_tx);
        rangeSeekBar.setProgress(50);
//        rangeSeekBar.setSecondaryProgress(700);
        rangeSeekBar.setSeekBarBeans(getSeekBars());
        rangeSeekBar.setOnSubsectionSeekBarChangeListener(new SubsectionSeekBar.onSubsectionSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(View view, int progress, boolean fromUser) {
                Log.i("main", "progress:" + progress);
                seekbarTx.setText("progress:" + progress);
            }

            @Override
            public void onStartTrackingTouch(View view) {

            }

            @Override
            public void onStopTrackingTouch(View view) {

            }
        });
    }

    public List<SeekBarBean> getSeekBars() {
        List<SeekBarBean> seekBarBeans = new ArrayList<>();
        seekBarBeans.add(new SeekBarBean(getResources().getColor(R.color.red1), 200, 300));
        seekBarBeans.add(new SeekBarBean(getResources().getColor(R.color.blue2), 500, 1000));
        return seekBarBeans;
    }
}
