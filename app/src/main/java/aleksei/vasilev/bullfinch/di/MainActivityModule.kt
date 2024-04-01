package aleksei.vasilev.bullfinch.di

import aleksei.vasilev.bullfinch.navigation.NavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainActivityModule {
    @Provides
    @Singleton
    fun provideNavigatorImpl() : NavigatorImpl = NavigatorImpl()
}