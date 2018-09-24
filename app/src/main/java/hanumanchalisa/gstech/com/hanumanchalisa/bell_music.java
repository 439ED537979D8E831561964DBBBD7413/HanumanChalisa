package hanumanchalisa.gstech.com.hanumanchalisa;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import chalisa.gamedesigna.hanumanchalisaa.hanumanchalisa.R;

class Bell_music {

    private static Bell_music bellsingleton;
    SoundPool soundPool;

    int CLICK_SOUND;

    public Bell_music(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            soundPool = (new SoundPool.Builder()).setMaxStreams(1).build();
        }else{
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);
        }
    }

    public void bellloadSound(Context context){
        CLICK_SOUND = soundPool.load(context, R.raw.bellmusic, 1);
        // load other sound if you like
    }

    public void bellplayClickSound(){
        soundPool.play(CLICK_SOUND, 1.0F, 1.0F, 0, 0, 1.0F);
    }



    public static void bellinitialize(Context context){
        Bell_music bellsoundManager = getInstance();
        bellsoundManager.bellloadSound(context);
    }

    public static synchronized Bell_music getInstance(){
        if(bellsingleton == null){
            bellsingleton = new Bell_music();
        }
        return bellsingleton;
    }




}
