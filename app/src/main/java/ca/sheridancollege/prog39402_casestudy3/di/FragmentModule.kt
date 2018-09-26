package ca.sheridancollege.prog39402_casestudy3.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ca.sheridancollege.prog39402_casestudy3.fragmentAddGroceryItem.FragmentAddGroceryItem
import ca.sheridancollege.prog39402_casestudy3.fragmentGroceryList.FragmentGroceryList

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindGroceryListFragment(): FragmentGroceryList

    @ContributesAndroidInjector
    abstract fun bindAddGroceryItemFragment(): FragmentAddGroceryItem

}
