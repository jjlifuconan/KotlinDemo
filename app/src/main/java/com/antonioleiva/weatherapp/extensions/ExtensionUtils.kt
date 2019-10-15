package com.antonioleiva.weatherapp.extensions

import java.text.DateFormat
import java.util.*
/**
 * @author conanaiflj
 * @date 2019/3/16 0014
 * @description:
 */
fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}
