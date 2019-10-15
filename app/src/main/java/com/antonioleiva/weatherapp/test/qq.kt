package com.antonioleiva.weatherapp.test

/**
 * @author Administrator
 * @date 2019/8/23 0023
 * @description:
 */
val ints = arrayOf(1,3,4,0,7)
fun main(args: Array<String>) {
    foo()
}

fun foo() {
    ints.forEach(fun(value: Int) {
        if (value == 0) return
        print(value)
    })
}