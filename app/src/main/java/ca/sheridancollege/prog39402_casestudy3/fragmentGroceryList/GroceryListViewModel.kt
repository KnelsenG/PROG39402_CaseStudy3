package ca.sheridancollege.prog39402_casestudy3.fragmentGroceryList

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import ca.sheridancollege.prog39402_casestudy3.adapters.listeners.GroceryItemClickListener
import ca.sheridancollege.prog39402_casestudy3.data.Repository
import ca.sheridancollege.prog39402_casestudy3.data.model.GroceryItem
import ca.sheridancollege.prog39402_casestudy3.util.SingleLiveEvent
import javax.inject.Inject

class GroceryListViewModel @Inject constructor(
        repository: Repository
) : ViewModel() {

    val isEmpty = ObservableBoolean()

    private val refreshTrigger = MutableLiveData<Boolean>()

    val fabClickEvent = SingleLiveEvent<Unit>()
    val groceryItemClickEvent = SingleLiveEvent<GroceryItem>()

    val source = Transformations.switchMap(
            refreshTrigger
    ) {
        Log.v(TAG, "refresh the list")
        repository.allGroceryItems()
    }

    private val isEmptCheck = Transformations.map(
            source
    ) {
        isEmpty.set(!it.isEmpty())
    }

    fun fabNewClick(){
        fabClickEvent.value = Unit
    }

    val groceryItemClickListener: GroceryItemClickListener by lazy {
        object : GroceryItemClickListener {
            override fun onGroceryItemClick(groceryItem: GroceryItem) {
                groceryItemClickEvent.value = groceryItem
            }
        }
    }

    fun refresh() {
        refreshTrigger.value = true
    }

    companion object {
        const val TAG = "GroceryListViewModel"
    }
}
