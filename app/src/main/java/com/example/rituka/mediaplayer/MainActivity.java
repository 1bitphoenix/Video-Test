package com.example.rituka.mediaplayer;

import android.widget.MediaController;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.media.MediaPlayer;
import android.widget.VideoView;
import android.widget.FrameLayout;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       videoView= (VideoView) findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse(
                "android.resource://"+getPackageName()+"/"+R.raw.samplevideo)
        );
        videoView.start();
//        MediaController controller=new MediaController(this);
//        controller.setAnchorView(this.videoView);
//        controller.setMediaPlayer(this.videoView);
        //videoView.setMediaController(new MediaController(this,));

        final MediaPlayer mp=MediaPlayer.create(this, R.raw.crowd);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer p) {
                p.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer p1, int width, int height) {
                       MediaController p2=new MediaController(MainActivity.this);
                        videoView.setMediaController(p2);
                    }
                });
            }
        });
       findViewById(R.id.btnPlay).setOnClickListener(new View.OnClickListener(){

           @Override
           public void onClick(View view) {
               mp.start();
           }
       });
        findViewById(R.id.btnPause).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });
    }
}
