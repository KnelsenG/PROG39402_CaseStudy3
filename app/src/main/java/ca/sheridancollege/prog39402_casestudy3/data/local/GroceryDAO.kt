package ca.sheridancollege.prog39402_casestudy3.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ca.sheridancollege.prog39402_casestudy3.data.model.GroceryItem

@Dao
interface GroceryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGroceryItem(groceryItem: GroceryItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGroceryItems(groceryItems: List<GroceryItem>)

    @Query("SELECT * FROM GroceryItem")
    fun allGroceryItems(): LiveData<List<GroceryItem>>

    @Query("SELECT COUNT(*) FROM GroceryItem WHERE name=:name")
    fun countItemsByName(name: String): Int

}
