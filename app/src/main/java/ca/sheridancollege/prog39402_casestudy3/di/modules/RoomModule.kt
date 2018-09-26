package ca.sheridancollege.prog39402_casestudy3.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ca.sheridancollege.prog39402_casestudy3.data.local.*
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        val database: AppDatabase?
        database = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
        ).build()
        return database
    }

    @Provides
    @Singleton
    fun provideGroceryDao(appDatabase: AppDatabase): GroceryDAO {
        return appDatabase.groceryDAO()
    }

}
