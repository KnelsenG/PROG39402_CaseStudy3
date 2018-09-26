package ca.sheridancollege.prog39402_casestudy3.fragmentAddGroceryItem

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import ca.sheridancollege.prog39402_casestudy3.data.Repository
import ca.sheridancollege.prog39402_casestudy3.data.model.GroceryItem
import ca.sheridancollege.prog39402_casestudy3.util.GroceryImage
import ca.sheridancollege.prog39402_casestudy3.util.SingleLiveEvent
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject
import ca.sheridancollege.prog39402_casestudy3.R

class AddGroceryItemViewModel @Inject constructor(
        private val repository: Repository
) : ViewModel() {

    val saveEventBegin = SingleLiveEvent<Unit>()
    val saveEventComplete = SingleLiveEvent<Unit>()

    val name = ObservableField<String>()
    val price = ObservableField<String>()
    val weight = ObservableField<String>()
    val quantity = ObservableField<String>()
    val image = ObservableField<Int>()

    val isSaving = ObservableBoolean()

    private val mName: String
        get() = name.get() ?: "No Name"

    private val mPrice: Double
        get() = price.get()?.toDouble() ?: 1.0

    private val mWeight: Double
        get() = weight.get()?.toDouble() ?: 1.0

    private val mQuantity: Int
        get() = quantity.get()?.toInt(10) ?: 1

    private val mImage: Int
        get() = image.get() ?: R.drawable.food

    fun btnSaveClick() {

        GlobalScope.launch {
            saveEventBegin.postValue(Unit)
            isSaving.set(true)

            if (mName == "No Name") {
                val noNameCount = repository.countByNoName();
                name.set("No Name $noNameCount")
            }

            repository.saveGroceryItem(GroceryItem(mImage, mName, mPrice, mWeight, mQuantity))
            delay(1000)

//            isSaving.set(false)
            saveEventComplete.postValue(Unit)

        }

    }

    fun btnImageClick(groveryImage: GroceryImage){
        image.set(groveryImage.resId)
    }

    companion object {
        const val TAG = "AddGroceryItemViewModel"
    }
}
