package ca.sheridancollege.prog39402_casestudy3.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ca.sheridancollege.prog39402_casestudy3.data.model.GroceryItem

@Database(
        entities = [GroceryItem::class],
        version = 1,
        exportSchema = false
)
//@TypeConverters(value = [
//    VariantsTypeConverter::class
//])
abstract class AppDatabase : RoomDatabase() {

    abstract fun groceryDAO(): GroceryDAO

    companion object {
        const val DATABASE_NAME = "GroceryDatabase"
    }
}
