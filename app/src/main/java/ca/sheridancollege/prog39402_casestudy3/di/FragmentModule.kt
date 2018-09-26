package ca.sheridancollege.prog39402_casestudy3.di

import ca.sheridancollege.prog39402_casestudy3.fragmentAddGroceryItem.FragmentAddGroceryItem
import ca.sheridancollege.prog39402_casestudy3.fragmentGroceryList.FragmentGroceryList
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindGroceryListFragment(): FragmentGroceryList

    @ContributesAndroidInjector
    abstract fun bindAddGroceryItemFragment(): FragmentAddGroceryItem

}
