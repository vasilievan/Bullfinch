package aleksei.vasilev.oboelib

import android.content.Context
import android.media.AudioManager
import jakarta.inject.Inject

class OboeLib @Inject constructor() {
    external fun stringFromJNI(): String

    external fun createEngine(): Boolean

    external fun start()

    external fun closeStreams()

    private external fun setDefaultStreamParameters(sampleRate: Int, framesPerBurst: Int)

    fun setDefaultStreamParameters(context: Context) {
        val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val sampleRate = audioManager.getProperty(AudioManager.PROPERTY_OUTPUT_SAMPLE_RATE).toInt()
        val framesPerBurstStr =
            audioManager.getProperty(AudioManager.PROPERTY_OUTPUT_FRAMES_PER_BUFFER).toInt()
        setDefaultStreamParameters(sampleRate, framesPerBurstStr)
    }

    companion object {
        init {
            System.loadLibrary("oboelib")
        }
    }
}