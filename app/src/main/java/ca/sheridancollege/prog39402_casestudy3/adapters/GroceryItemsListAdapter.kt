package ca.sheridancollege.prog39402_casestudy3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.sheridancollege.prog39402_casestudy3.adapters.listeners.GroceryItemClickListener
import ca.sheridancollege.prog39402_casestudy3.data.model.GroceryItem
import ca.sheridancollege.prog39402_casestudy3.databinding.ListItemGroceryItemBinding

class GroceryItemsListAdapter(
        private val clickListener: GroceryItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var source = emptyList<GroceryItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ListItemGroceryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductListViewHolder(binding)
    }

    override fun getItemCount(): Int = source.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ProductListViewHolder).bind(source[position], clickListener)
    }

    class ProductListViewHolder(val binding: ListItemGroceryItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(groceryItem: GroceryItem, clickListener: GroceryItemClickListener) {
            binding.groceryItem = groceryItem
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

}
