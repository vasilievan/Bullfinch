package aleksei.vasilev.oboelib

class OboeLib {
    external fun stringFromJNI(): String

    companion object {
        init {
            System.loadLibrary("oboelib")
        }
    }
}