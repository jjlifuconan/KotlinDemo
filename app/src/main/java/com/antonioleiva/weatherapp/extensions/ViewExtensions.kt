package com.antonioleiva.weatherapp.extensions

import android.content.Context
import android.view.View
import android.widget.TextView
/**
 * @author conanaiflj
 * @date 2019/3/16 0014
 * @description:
 */
val View.ctx: Context
    get() = context

var TextView.textColor: Int
    get() = currentTextColor
    set(v) = setTextColor(v)

var TextView.text:CharSequence
 get() = getText()
set(value) = setText(value)



fun View.slideExit() {
    if (translationY == 0f) animate().translationY(-height.toFloat())
}

fun View.slideEnter() {
    if (translationY < 0f) animate().translationY(0f)
}