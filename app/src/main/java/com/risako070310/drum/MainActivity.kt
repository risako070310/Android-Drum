package com.risako070310.drum

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mSoundPool: SoundPool
    private lateinit var mSoundId: Array<Int?>

    private val mSoundResources = arrayOf(
        R.raw.cymbal1,
        R.raw.cymbal2,
        R.raw.cymbal3,
        R.raw.tom1,
        R.raw.tom2,
        R.raw.tom3,
        R.raw.hihat,
        R.raw.snare,
        R.raw.bass,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cymbal1.setOnClickListener{
            mSoundPool.play(mSoundId[0] as Int, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        cymbal2.setOnClickListener{
            mSoundPool.play(mSoundId[1] as Int, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        cymbal3.setOnClickListener{
            mSoundPool.play(mSoundId[2] as Int, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        tom1.setOnClickListener{
            mSoundPool.play(mSoundId[3] as Int, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        tom2.setOnClickListener{
            mSoundPool.play(mSoundId[4] as Int, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        tom3.setOnClickListener{
            mSoundPool.play(mSoundId[5] as Int, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        hihat.setOnClickListener{
            mSoundPool.play(mSoundId[6] as Int, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        snare.setOnClickListener{
            mSoundPool.play(mSoundId[7] as Int, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        bass.setOnClickListener{
            mSoundPool.play(mSoundId[8] as Int, 1.0f, 1.0f, 0, 0, 1.0f)
        }


    }

    override fun onResume() {
        super.onResume()

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()

        mSoundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .setMaxStreams(mSoundResources.size)
            .build()

        mSoundId = arrayOfNulls(mSoundResources.size)

        for(i in 0..(mSoundResources.size - 1)){
            mSoundId[i] = mSoundPool.load(applicationContext, mSoundResources[i], 0)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mSoundPool.release()
    }
}

