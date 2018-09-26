package ca.sheridancollege.prog39402_casestudy3.data

import androidx.lifecycle.LiveData
import ca.sheridancollege.prog39402_casestudy3.data.local.GroceryDAO
import ca.sheridancollege.prog39402_casestudy3.data.model.GroceryItem
import javax.inject.Inject

class Repository @Inject constructor(
        private val groceryDAO: GroceryDAO
) {

    fun saveGroceryItem(groceryItem: GroceryItem) {
        groceryDAO.insertGroceryItem(groceryItem)
    }

    fun allGroceryItems(): LiveData<List<GroceryItem>> {
        return groceryDAO.allGroceryItems()
    }

    fun countByNoName(): Int {
        return groceryDAO.countItemsByName("No Name");
    }

    companion object {
        const val TAG = "Repository"
    }

}
