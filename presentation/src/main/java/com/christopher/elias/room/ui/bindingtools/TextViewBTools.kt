package com.christopher.elias.room.ui.bindingtools

import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * Created by Christopher Elias on 3/02/2020.
 * christopher.mike.96@gmail.com
 *
 * Peru Apps
 * Lima, Peru.
 **/

@BindingAdapter("setCustomErrorMessage")
fun setCustomErrorMessage(tv: TextView, message: Any?) {
    tv.text = when(message) {
        is String -> message
        is Int -> tv.resources.getString(message)
        else -> ""
    }
}