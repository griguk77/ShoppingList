package ru.studyguk.shoppinglist.presentation

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import ru.studyguk.shoppinglist.R

@BindingAdapter("errorInputName")
fun bindErrorInputName(textInputLayout: TextInputLayout, errorInputName: Boolean) {
    if (errorInputName) {
        textInputLayout.error = textInputLayout.context.getString(R.string.nameErrorText)
    } else {
        textInputLayout.error = null
    }
}

@BindingAdapter("errorInputCount")
fun bindErrorInputCount(textInputLayout: TextInputLayout, errorInputCount: Boolean) {
    if (errorInputCount) {
        textInputLayout.error = textInputLayout.context.getString(R.string.countErrorText)
    } else {
        textInputLayout.error = null
    }
}