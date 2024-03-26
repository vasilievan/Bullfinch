package aleksei.vasilev.bullfinch.navigation

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