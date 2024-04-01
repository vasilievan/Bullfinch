package aleksei.vasilev.bullfinch.application

import aleksei.vasilev.oboelib.OboeLib
import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class BullfinchApplication : Application() {
    @Inject
    lateinit var oboeLib: OboeLib
    companion object {
        var applicationScope = MainScope()
    }

    override fun onCreate() {
        super.onCreate()
        applicationScope.launch(Dispatchers.Default) {
            oboeLib.apply {
                setDefaultStreamParameters(this@BullfinchApplication)
                createEngine()
            }
        }
    }

    override fun onLowMemory() {
        super.onLowMemory()
        applicationScope.cancel()
        applicationScope = MainScope()
    }
}