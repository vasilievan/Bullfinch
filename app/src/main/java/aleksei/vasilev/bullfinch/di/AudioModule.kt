package aleksei.vasilev.bullfinch.di

import aleksei.vasilev.oboelib.OboeLib
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AudioModule {
    @Provides
    @Singleton
    fun provideOboeLib(): OboeLib = OboeLib()
}