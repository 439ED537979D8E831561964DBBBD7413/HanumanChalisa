package hanumanchalisa.gstech.com.hanumanchalisa;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import chalisa.gamedesigna.hanumanchalisaa.hanumanchalisa.R;

public class SoundManager {
    private static SoundManager singleton;
    SoundPool soundPool;

    int CLICK_SOUND;

    public SoundManager(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            soundPool = (new SoundPool.Builder()).setMaxStreams(1).build();
        }else{
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);
        }
    }

    public void loadSound(Context context){
        CLICK_SOUND = soundPool.load(context, R.raw.shankh, 1);
        // load other sound if you like
    }

    public void playClickSound(){
        soundPool.play(CLICK_SOUND, 1.0F, 1.0F, 0, 0, 1.0F);
    }



    public static void initialize(Context context){
        SoundManager soundManager = getInstance();
        soundManager.loadSound(context);
    }

    public static synchronized SoundManager getInstance(){
        if(singleton == null){
            singleton = new SoundManager();
        }
        return singleton;
    }

}

