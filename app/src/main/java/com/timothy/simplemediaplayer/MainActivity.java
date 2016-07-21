package com.timothy.simplemediaplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    private static final String VIDEO_URL = "http://techslides.com/demos/sample-videos/small.mp4";
    private MediaPlayer mMediaPlayer;
    private SurfaceHolder mSurfaceHolder;
    private SurfaceView mSurfaceView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSurfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        mSurfaceHolder = mSurfaceView.getHolder();

        mSurfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                try{
                    mMediaPlayer = new MediaPlayer();
                    mMediaPlayer.setDisplay(surfaceHolder);
                    mMediaPlayer.setDataSource(VIDEO_URL);
                    mMediaPlayer.prepare();
                    ///7785852852
                    mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            Log.d(TAG, "onPrepared: ");
                            mediaPlayer.start();
                        }
                    });
                    mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                } catch (IOException e){
                    Log.e(TAG, "surfaceCreated: ", e);
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
    }
}
