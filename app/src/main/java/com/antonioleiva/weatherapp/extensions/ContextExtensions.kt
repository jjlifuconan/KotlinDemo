package com.antonioleiva.weatherapp.extensions

import android.content.Context
import android.support.v4.content.ContextCompat
/**
 * @author conanaiflj
 * @date 2019/3/14 0014
 * @description:
 */
fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)