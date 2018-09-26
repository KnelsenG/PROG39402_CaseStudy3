package ca.sheridancollege.prog39402_casestudy3.data.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index("id")])
data class GroceryItem(
        @PrimaryKey(autoGenerate = false) val id: Long?,
        val image: Int?,
        val name: String,
        val price: Double,
        val weight: Double,
        val qty: Int
) {
    constructor(
            image: Int,
            name: String,
            price: Double,
            weight: Double,
            qty: Int
    ) : this(null, image, name, price, weight, qty)
}

