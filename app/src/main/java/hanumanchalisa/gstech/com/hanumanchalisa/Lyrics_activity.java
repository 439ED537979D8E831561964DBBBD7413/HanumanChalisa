package hanumanchalisa.gstech.com.hanumanchalisa;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import chalisa.gamedesigna.hanumanchalisaa.hanumanchalisa.R;

public class Lyrics_activity extends AppCompatActivity {
    SeekBar seekBar;
    private AdView mAdView;
    ScrollView scrollView;

    ImageView buttonPlayStop, pauseaudio;
    int textSize = 3;
    int saveProgress;
    private InterstitialAd mInterstitialAd;
    TextView lyrics_text, select_language_text, ok_button, reset_button;
    ImageView select_language, share_button, back_buttton, font_size_button, rate_us;

    RadioButton english, hinid, telgu, tamil, bangali, gujrati, kannada, malayam, oriya;
    Handler mHandler = new Handler();
    private Runnable mRunnable;
    String[] values = new String[]{"English",
            "हिन्दी",
            "తెలుగు",
            "தமிழ்",
            "বাংলা",
            "ગુજરાતી",
            "ಕನ್ನಡ",
            "മലയാളം",
            "ନୀୟ"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics_activity);

        MobileAds.initialize(this, "ca-app-pub-4879468622760851~8884385861");
        share_button = (ImageView) findViewById(R.id.share_button);
        back_buttton = (ImageView) findViewById(R.id.back_button);
        lyrics_text = (TextView) findViewById(R.id.lyrics_text);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        select_language_text = (TextView) findViewById(R.id.select_language_text);
        select_language = (ImageView) findViewById(R.id.select_language_button);
        font_size_button = (ImageView) findViewById(R.id.font_size_button);
        rate_us = (ImageView) findViewById(R.id.rate_button);


        String string = getString(R.string.english_lyric);

        lyrics_text.setText(string);
        lyrics_text.setMovementMethod(new ScrollingMovementMethod());

       /* mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();

        Log.d("ADMOB", "ADMOB LOADED");
        mAdView.loadAd(adRequest);
*/

        MainActivity mainActivity = new MainActivity();
        int pos = mainActivity.getPosition();


        rate_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=hanumanchalisa.gamedesigna.com.hanumanchalisaa"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        font_size_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(Lyrics_activity.this);
                View view = getLayoutInflater().inflate(R.layout.custom_font_dialogue, null);

                dialog.show();

                ok_button = (TextView) view.findViewById(R.id.ok_button);
                reset_button = (TextView) view.findViewById(R.id.reset_buttton);


                seekBar = (SeekBar) view.findViewById(R.id.seekbar1);

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                        lyrics_text.setTextSize(progress);
                    }
                });


                dialog.setContentView(view);


                ok_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                reset_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lyrics_text.setTextSize(9);
                        dialog.dismiss();
                    }
                });


            }
        });


        back_buttton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //  startActivity(new Intent(Lyrics_activity.this,MainActivity.class));
                finish();


            }
        });

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


        select_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(Lyrics_activity.this);
                View view = getLayoutInflater().inflate(R.layout.custom_dialogue, null);

                ListView listView = (ListView) view.findViewById(R.id.listview);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(Lyrics_activity.this, android.R.layout.simple_list_item_1, values);
                listView.setAdapter(arrayAdapter);
                dialog.setContentView(view);

                dialog.show();

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String selectedItem = (String) parent.getItemAtPosition(position);

                        // Toast.makeText(Lyrics_activity.this,""+ selectedItem,Toast.LENGTH_SHORT).show();

                        if (values[0] == selectedItem) {
                            Toast.makeText(Lyrics_activity.this, "English", Toast.LENGTH_SHORT).show();
                            lyrics_text.setText(getString(R.string.english_lyric));
                            dialog.dismiss();
                        } else if (values[1] == selectedItem) {
                            Toast.makeText(Lyrics_activity.this, "Hindi", Toast.LENGTH_SHORT).show();
                            lyrics_text.setText(getString(R.string.hindi));
                            dialog.dismiss();

                        } else if (values[2] == selectedItem) {
                            Toast.makeText(Lyrics_activity.this, "Telgu", Toast.LENGTH_SHORT).show();
                            lyrics_text.setText(getString(R.string.telgu));
                            dialog.dismiss();

                        } else if (values[3] == selectedItem) {
                            Toast.makeText(Lyrics_activity.this, "Tamil", Toast.LENGTH_SHORT).show();
                            lyrics_text.setText(getString(R.string.tamil));
                            dialog.dismiss();

                        } else if (values[4] == selectedItem) {
                            Toast.makeText(Lyrics_activity.this, "Bengali", Toast.LENGTH_SHORT).show();
                            lyrics_text.setText(getString(R.string.Bengali));
                            dialog.dismiss();

                        } else if (values[5] == selectedItem) {
                            Toast.makeText(Lyrics_activity.this, "Gujarati", Toast.LENGTH_SHORT).show();
                            lyrics_text.setText(getString(R.string.gujarati));
                            dialog.dismiss();

                        } else if (values[6] == selectedItem) {
                            Toast.makeText(Lyrics_activity.this, "Kannada", Toast.LENGTH_SHORT).show();
                            lyrics_text.setText(getString(R.string.kannada));
                            dialog.dismiss();

                        } else if (values[7] == selectedItem) {
                            Toast.makeText(Lyrics_activity.this, "Malayalam", Toast.LENGTH_SHORT).show();
                            lyrics_text.setText(getString(R.string.malayalam));
                            dialog.dismiss();

                        } else if (values[8] == selectedItem) {
                            Toast.makeText(Lyrics_activity.this, "Oriya", Toast.LENGTH_SHORT).show();
                            lyrics_text.setText(getString(R.string.oriya));
                            dialog.dismiss();

                        }


                    }

                });


            }
        });


     /*   prepareAd();
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                Log.i("hello", "world");
                runOnUiThread(new Runnable() {
                    public void run() {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", " Interstitial not loaded");
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
    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();
    }
}





