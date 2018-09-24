package hanumanchalisa.gstech.com.hanumanchalisa;


import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import chalisa.gamedesigna.hanumanchalisaa.hanumanchalisa.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static MainActivity singleton;
    SoundPool soundPool;
    ViewFlipper viewFlipper;
    Button next;
    int resumePosition;
    ImageView buttonPlayStop, pausebutton, lyric_button, share_button, shankh_button, bell_button;
    Button previous;
    private SeekBar mSeekBar;
    private Handler mHandler;
    private Runnable mRunnable;
    private Context mContext;
    private MediaPlayer mPlayer;
    private Activity mActivity;
    private  MediaPlayer shanks_play;
    private  MediaPlayer bell_play;
    private TextView mPass;
    private TextView mDuration;
    private TextView mDue;
    private InterstitialAd mInterstitialAd;
    public final String YOUR_ADMOB_APP_ID = "ca-app-pub-3940256099942544~3347511713";
    ImageView img1, img2, img3, img4, img5, img6,img7,img8,img9,img10,img11,img12;
    ImageView effect;
    private AdView mAdView;
    boolean isActivityVisible=true;
    ObjectAnimator objectanimator1,
            objectanimator2,
            objectanimator3,
            objectanimator4,
            objectanimator5,
            objectanimator6,
            objectanimator7,objectanimator8,objectanimator9,objectanimator10,objectanimator11,objectanimator12;




                    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");

        //placing toolbar in place of actionbar
        setSupportActionBar(toolbar);
        mContext = getApplicationContext();
        mActivity = MainActivity.this;
   prepareAd();
        img1 = (ImageView) findViewById(R.id.imageViewone);
        img2 = (ImageView) findViewById(R.id.imageViewtwo);
        img3 = (ImageView) findViewById(R.id.imageViewthree);
        img4 = (ImageView) findViewById(R.id.imageViewfour);
        img5 = (ImageView) findViewById(R.id.imageViewfive);
        img6 = (ImageView) findViewById(R.id.imageViewsix);
        img7 = (ImageView) findViewById(R.id.imageViewseven);
        img8 = (ImageView) findViewById(R.id.imageViewsaight);
        img9 = (ImageView) findViewById(R.id.imageViewsnine);
        img10 = (ImageView) findViewById(R.id.imageViewten);
        img11 = (ImageView) findViewById(R.id.imageVieweleven);
        img12 = (ImageView) findViewById(R.id.imageViewtwelve);




        effect = (ImageView) findViewById(R.id.flower_id);

        objectanimator1 = ObjectAnimator.ofFloat(img1, "y", 951);
        objectanimator2 = ObjectAnimator.ofFloat(img2, "y", 952);
        objectanimator3 = ObjectAnimator.ofFloat(img3, "y", 953);
        objectanimator4 = ObjectAnimator.ofFloat(img4, "y", 954);
        objectanimator5 = ObjectAnimator.ofFloat(img5, "y", 955);
        objectanimator6 = ObjectAnimator.ofFloat(img6, "y", 956);
        objectanimator7 = ObjectAnimator.ofFloat(img7, "y", 957);
        objectanimator8 = ObjectAnimator.ofFloat(img8, "y", 958);
        objectanimator9 = ObjectAnimator.ofFloat(img9, "y", 959);
        objectanimator10 = ObjectAnimator.ofFloat(img10, "y", 960);
        objectanimator11 = ObjectAnimator.ofFloat(img11, "y", 961);
        objectanimator12 = ObjectAnimator.ofFloat(img12, "y", 962);


        effect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {





              img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.VISIBLE);
                img3.setVisibility(View.VISIBLE);
                img4.setVisibility(View.VISIBLE);
                img5.setVisibility(View.VISIBLE);
                img6.setVisibility(View.VISIBLE);
                img7.setVisibility(View.VISIBLE);
                img8.setVisibility(View.VISIBLE);
                img9.setVisibility(View.VISIBLE);
                img10.setVisibility(View.VISIBLE);
                img11.setVisibility(View.VISIBLE);
                img12.setVisibility(View.VISIBLE);


                objectanimator1.setDuration(500);
                objectanimator2.setDuration(1000);
                objectanimator3.setDuration(700);
                objectanimator4.setDuration(800);
                objectanimator5.setDuration(900);
                objectanimator6.setDuration(3000);
                objectanimator7.setDuration(3000);
                objectanimator8.setDuration(3000);
                objectanimator9.setDuration(3000);
                objectanimator10.setDuration(3000);
                objectanimator11.setDuration(3000);
                objectanimator12.setDuration(3000);

                objectanimator1.start();
                objectanimator2.start();
                objectanimator3.start();
                objectanimator4.start();
                objectanimator5.start();
                objectanimator6.start();
                objectanimator7.start();
                objectanimator8.start();
                objectanimator9.start();
                objectanimator10.start();
                objectanimator11.start();
                objectanimator12.start();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {


                        img1.setVisibility(View.INVISIBLE);
                        img2.setVisibility(View.INVISIBLE);
                        img3.setVisibility(View.INVISIBLE);
                        img4.setVisibility(View.INVISIBLE);
                        img5.setVisibility(View.INVISIBLE);
                        img6.setVisibility(View.INVISIBLE);
                        img7.setVisibility(View.INVISIBLE);
                        img8.setVisibility(View.INVISIBLE);
                        img9.setVisibility(View.INVISIBLE);
                        img10.setVisibility(View.INVISIBLE);
                        img11.setVisibility(View.INVISIBLE);
                        img12.setVisibility(View.INVISIBLE);



                    }
                }, 8000);   //5 seconds


            }
        });


        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        next = (Button) findViewById(R.id.next);
        previous = (Button) findViewById(R.id.previous);
        next.setOnClickListener(this);
        previous.setOnClickListener(this);
        buttonPlayStop = (ImageView) findViewById(R.id.playbutton);
        pausebutton = (ImageView) findViewById(R.id.pausebutton);
        lyric_button = (ImageView) findViewById(R.id.lyric_button);
        share_button = (ImageView) findViewById(R.id.share_button);

        mPass = findViewById(R.id.tv_pass);
        mDuration = findViewById(R.id.tv_duration);
        mDue = findViewById(R.id.tv_due);
        shankh_button = (ImageView)findViewById(R.id.shankh_id);
        bell_button = (ImageView)findViewById(R.id.bell_id);
        mSeekBar = findViewById(R.id.seek_bar);
      /*  mAdView = findViewById(R.id.adView);
        MobileAds.initialize(this, "ca-app-pub-4879468622760851~8884385861");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/
        mHandler = new Handler();




        SoundManager.initialize(getApplicationContext());
        Bell_music.bellinitialize(getApplicationContext());






share_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=hanumanchalisa.gamedesigna.com.hanumanchalisaa");

        intent.putExtra(Intent.EXTRA_SUBJECT, "Share the app!");

        startActivity(Intent.createChooser(intent, "Share"));
    }
});


        lyric_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 /* if(mInterstitialAd.isLoaded()){

                      mInterstitialAd.show();

                  }
               else {
                      prepareAd();

                  }*/
                     Intent secondActivity = new Intent(MainActivity.this, Lyrics_activity.class);

                        startActivity(secondActivity);




            }
        });




        shankh_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
       /*       shanks_play = MediaPlayer.create(mContext, R.raw.shankh);
          shanks_play.start();
*/
                SoundManager.getInstance().playClickSound();

            }
        });

        bell_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         /*       bell_play =  MediaPlayer.create(mContext, R.raw.bellmusic);
           bell_play.start();
*/
        Bell_music.getInstance().bellplayClickSound();


            }
        });




        buttonPlayStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              buttonPlayStop.setVisibility(View.INVISIBLE);
              pausebutton.setVisibility(View.VISIBLE);

                // Initialize media player
                mPlayer = MediaPlayer.create(mContext, R.raw.musicplay);

                // Start the media player
                if (!mPlayer.isPlaying()) {
                    mPlayer.seekTo(resumePosition);
                    mPlayer.start();
                }
             //   Toast.makeText(mContext, "Media Player is playing.", Toast.LENGTH_SHORT).show();


              mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                  @Override
                  public void onCompletion(MediaPlayer mp) {
              //   mInterstitialAd.show();
                  }
              });


                // Get the current audio stats
               // getAudioStats();
                // Initialize the seek bar
                initializeSeekBar();
            }
        });

        pausebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlaying();
                buttonPlayStop.setVisibility(View.VISIBLE);
                pausebutton.setVisibility(View.INVISIBLE);

            }
        });


        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (mPlayer != null && b) {



                    mPlayer.seekTo(i * 1000);



                }
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


      /*  prepareAd();
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                Log.i("hello", "world");
                runOnUiThread(new Runnable() {
                    public void run() {
                        if (mInterstitialAd.isLoaded() ) {

                             mInterstitialAd.show();

                        }

                        else {
                            Log.d("TAG", "Interstitial not loaded");
                        }
                        prepareAd();
                    }
                });
            }
        }, 5, 5, TimeUnit.MINUTES);

*/





















    }

    private void prepareAd() {

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-4879468622760851/2271818008");


      mInterstitialAd.loadAd(new AdRequest.Builder().build());




    }






    void initializeSeekBar () {
        mSeekBar.setMax(mPlayer.getDuration() / 1000);

        if (mPlayer != null) {
            int mCurrentPosition = mPlayer.getCurrentPosition() / 1000; // In milliseconds
            mSeekBar.setProgress(mCurrentPosition);
            //getAudioStats();
        }


        /*mRunnable = new Runnable() {
            @Override
            public void run() {
                if (mPlayer != null) {
                    int mCurrentPosition = mPlayer.getCurrentPosition() / 1000; // In milliseconds
                    mSeekBar.setProgress(mCurrentPosition);
                    //getAudioStats();
                }
                mHandler.postDelayed(mRunnable, 1000);
            }
        };
        mHandler.postDelayed(mRunnable, 1000);*/
    }
    void getAudioStats() {
        int duration = mPlayer.getDuration() / 1000; // In milliseconds
        int due = (mPlayer.getDuration() - mPlayer.getCurrentPosition()) / 1000;
        int pass = duration - due;

        mPass.setText("" + pass + " seconds");
        mDuration.setText("" + duration + " seconds");
        mDue.setText("" + due + " seconds");


 /*if(duration==568800)
            mInterstitialAd.show();*/
}
    void stopPlaying () {
        // If media player is not null then try to stop it
        if (mPlayer.isPlaying()) {

            mPlayer.pause();
            resumePosition = mPlayer.getCurrentPosition();


/*
            if (mHandler != null) {
                mHandler.removeCallbacks(mRunnable);
            }*/
        }




    }


    int getPosition(){

        return resumePosition;

    }



    @Override
    public void onClick(View v) {
        if (v == next) {
            viewFlipper.showNext();
        } else if (v == previous) {
            viewFlipper.showPrevious();
        }
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
               //   mInterstitialAd.show();

                     if(mPlayer!=null)
                     {
                         mPlayer.stop();
                         finish();

                     }

                     else {finish();}


                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    @Override
    protected void onStop() {
        super.onStop();


        }








    @Override
    protected void onPause() {
        super.onPause();


    }


    @Override
    protected void onResume() {
        super.onResume();
    }
}


















