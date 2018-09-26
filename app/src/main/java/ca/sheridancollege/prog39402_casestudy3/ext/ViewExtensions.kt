package ca.sheridancollege.prog39402_casestudy3.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import ca.sheridancollege.prog39402_casestudy3.R

fun ImageView.loadImage(urlOrResource: Any?) {
    Glide.with(context)
            .load(urlOrResource ?: R.drawable.grocery_item_default)
            .into(this)
}

