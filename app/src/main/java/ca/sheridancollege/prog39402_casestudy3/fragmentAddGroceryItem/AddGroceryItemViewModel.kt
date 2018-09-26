package ca.sheridancollege.prog39402_casestudy3.fragmentAddGroceryItem

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import ca.sheridancollege.prog39402_casestudy3.R
import ca.sheridancollege.prog39402_casestudy3.data.Repository
import ca.sheridancollege.prog39402_casestudy3.util.GroceryImage
import ca.sheridancollege.prog39402_casestudy3.util.SingleLiveEvent
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class AddGroceryItemViewModel @Inject constructor(
        private val repository: Repository
) : ViewModel() {

    val saveEventBegin = SingleLiveEvent<Unit>()
    val saveEventComplete = SingleLiveEvent<Unit>()

    val name = ObservableField<String>()
    val price = ObservableField<String>()
    val weight = ObservableField<String>()
    val quantity = ObservableField<String>()
    val image = ObservableField<GroceryImage>(GroceryImage.FOOD)

    // observables for state
    val isSaving = ObservableBoolean()

    val nameErrorState = ObservableBoolean(false)
    val nameError = ObservableField<String?>()

    val priceErrorState = ObservableBoolean(false)
    val priceError = ObservableField<String?>()

    val weightErrorState = ObservableBoolean(false)
    val weightError = ObservableField<String?>()

    val quantityErrorState = ObservableBoolean(false)
    val quantityError = ObservableField<String?>()

    private val mName: String
        get() = name.get() ?: ""

    private val mPrice: Double
        get() = price.get()?.toDouble() ?: 1.0

    private val mWeight: Double
        get() = weight.get()?.toDouble() ?: 1.0

    private val mQuantity: Int
        get() = quantity.get()?.toInt(10) ?: 1

    private val mImage: Int
        get() = image.get()?.resId ?: R.drawable.food

    fun btnSaveClick() {

        if (!isValid())
            return

        GlobalScope.launch {
            //            saveEventBegin.postValue(Unit)
//            isSaving.set(true)
//
//            repository.saveGroceryItem(GroceryItem(mImage, mName, mPrice, mWeight, mQuantity))
            delay(1000)

//            isSaving.set(false)
//            saveEventComplete.postValue(Unit)

        }

    }

    fun btnImageClick(groceryImage: GroceryImage) {
        image.set(groceryImage)
    }

    private fun isValid(): Boolean {

        if (mName.isBlank() || mName.isEmpty()) {
            nameError.set("Name cannot be empty")
            nameErrorState.set(true)
            return false
        } else {
            nameError.set(null)
            nameErrorState.set(false)
        }

        if (mPrice < 0) {
            priceError.set("Price cannot be negative")
            priceErrorState.set(true)
            return false
        } else {
            priceError.set(null)
            priceErrorState.set(false)
        }

        if (mWeight < 0) {
            weightError.set("Weight cannot be negative")
            weightErrorState.set(true)
            return false
        } else {
            weightError.set(null)
            weightErrorState.set(false)
        }

        if (mQuantity < 0) {
            quantityError.set("Quantity cannot be negative")
            quantityErrorState.set(true)
            return false
        } else {
            quantityError.set(null)
            quantityErrorState.set(false)
        }

        return true
    }

    companion object {
        const val TAG = "AddGroceryItemViewModel"
    }
}
