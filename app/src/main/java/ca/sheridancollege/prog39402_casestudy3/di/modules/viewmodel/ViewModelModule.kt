package ca.sheridancollege.prog39402_casestudy3.di.modules.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ca.sheridancollege.prog39402_casestudy3.fragmentAddGroceryItem.AddGroceryItemViewModel
import ca.sheridancollege.prog39402_casestudy3.fragmentGroceryList.GroceryListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(GroceryListViewModel::class)
    abstract fun bindGroceryListViewModel(viewModel: GroceryListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddGroceryItemViewModel::class)
    abstract fun bindAddGroceryItemViewModel(viewModel: AddGroceryItemViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
