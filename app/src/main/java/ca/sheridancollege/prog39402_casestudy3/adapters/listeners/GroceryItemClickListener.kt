package ca.sheridancollege.prog39402_casestudy3.adapters.listeners

import ca.sheridancollege.prog39402_casestudy3.data.model.GroceryItem

interface GroceryItemClickListener {
    fun onGroceryItemClick(groceryItem: GroceryItem)
}
