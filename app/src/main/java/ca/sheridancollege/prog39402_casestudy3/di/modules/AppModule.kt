package ca.sheridancollege.prog39402_casestudy3.di.modules

import android.app.Application
import android.content.Context
import ca.sheridancollege.prog39402_casestudy3.di.modules.viewmodel.ViewModelModule
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [
    SharedPreferencesModule::class,
    RoomModule::class,
    ViewModelModule::class
])
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideContext(application: Application): Context

}
