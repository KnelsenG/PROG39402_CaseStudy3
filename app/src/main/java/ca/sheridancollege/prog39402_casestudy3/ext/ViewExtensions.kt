package ca.sheridancollege.prog39402_casestudy3.ext

import android.widget.ImageView
import ca.sheridancollege.prog39402_casestudy3.R
import com.bumptech.glide.Glide

fun ImageView.loadImage(urlOrResource: Any?) {
    Glide.with(context)
            .load(urlOrResource ?: R.drawable.grocery_item_default)
            .into(this)
}

