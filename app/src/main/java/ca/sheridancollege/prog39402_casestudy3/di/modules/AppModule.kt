package ca.sheridancollege.prog39402_casestudy3.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import ca.sheridancollege.prog39402_casestudy3.di.modules.viewmodel.ViewModelModule
import javax.inject.Singleton

@Module(includes = [
    RoomModule::class,
    ViewModelModule::class
])
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideContext(application: Application): Context

}
