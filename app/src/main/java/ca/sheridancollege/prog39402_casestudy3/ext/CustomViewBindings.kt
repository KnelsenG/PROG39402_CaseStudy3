package ca.sheridancollege.prog39402_casestudy3.ext

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("toggleVisibility", requireAll = false)
fun toggleVisibility(view: View, show: Boolean) {
    view.visibility = if (show) View.VISIBLE else View.GONE
}

@BindingAdapter("glideImage")
fun imageResource(imageView: ImageView, source: Any) {
    imageView.loadImage(source)
}

@BindingAdapter("textDouble")
fun textDouble(textView: TextView, value: Double) {
    textView.text = value.toString()
}

@BindingAdapter("textInt")
fun textInt(textView: TextView, value: Int) {
    textView.text = value.toString()
}

@BindingAdapter("textLong")
fun textInt(textView: TextView, value: Long) {
    textView.text = value.toString()
}

@BindingAdapter("tilError")
fun tilError(textInputLayout: TextInputLayout, value: String?) {
    textInputLayout.error = value
}