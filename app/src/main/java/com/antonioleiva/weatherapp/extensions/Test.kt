package com.antonioleiva.weatherapp.extensions

import android.animation.Animator
import android.os.Build
import com.antonioleiva.weatherapp.test.PathAnimatorDefaultListener
import kotlin.properties.Delegates

/**
 * @author conanaiflj
 * @date 2019/3/14 0014
 * @description:
 */
class Test{
    val adHoc = object {
        var x:Int = 0
        var y:Int = 0
    }

    val sum = {x:Int,y:Int -> x+y}
//    val sum = {var x:Int,var y:Int -> x+y}//语法错误
    val sum2:(Int,Int) -> Int = {x,y -> x+y}
//    val sum2:(Int,Int) -> Int = {(x,y) -> x+y}//语法错误


//    fun test(){
//        print(adHoc.x+adHoc.y)
//    }

    inline fun supportLolip(code:()->Unit){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            code()
        }
    }

}

class TypeClass<T:Any>(param:T){
    val value:T = param

    fun <R> typefunc(item:R):List<R>{
        return ArrayList<R>()
    }
}


fun setAnimatorListener(animatorListener: Animator.AnimatorListener) {
//    mAnimatorListener = animatorListener
//    (mAnimatorListener as PathAnimatorDefaultListener).setTarget(this)
//    if (mAnimator != null) {
//        mAnimator!!.removeAllListeners()
//        mAnimator!!.addListener(mAnimatorListener)
//    }
}

fun setPathAnimatorDefaultListener(listener: PathAnimatorDefaultListener.() -> Unit){
    val ca = PathAnimatorDefaultListener()
    ca.listener()
    setAnimatorListener(ca)
}

//class D {
//    fun bar() { println("D bar") }
//}
//
//class C {
//    fun bar() { println("C bar") }  // 与 D 类 的 bar 同名
//
//    fun D.foo() {
//        bar()         // 调用 D.bar()，扩展接收者优先
//        this@C.bar()  // 调用 C.bar()
//    }
//
//    fun caller(d: D) {
//        d.foo()   // 调用扩展函数
//    }
//}
//
//fun main(args: Array<String>) {
//    val c: C = C()
//    val d: D = D()
//    c.caller(d)
//
//}

open class D {
}

class D1 : D() {
}

open class C {
    open fun D.foo() {
        println("D.foo in C")
    }

    open fun D1.foo() {
        println("D1.foo in C")
    }

    fun caller(d: D) {
        d.foo()   // 调用扩展函数
    }
}

class C1 : C() {
    override fun D.foo() {
        println("D.foo in C1")
    }

    override fun D1.foo() {
        println("D1.foo in C1")
    }
}


fun main(args: Array<String>) {
    C().caller(D())   // 输出 "D.foo in C"
    C1().caller(D())  // 输出 "D.foo in C1" —— 分发接收者虚拟解析
    C().caller(D1())  // 输出 "D.foo in C" —— 扩展接收者静态解析
    C1().caller(D1())  // 输出 "D.foo in C1" —— 分发接收者虚拟解析

    val foo = Foo()
    foo.notNullBar = "bar"
    println(foo.notNullBar)

    println(text)


}

class Foo {
    var notNullBar: String by Delegates.notNull<String>()
}

val text = """
        |First Line
        |Second Line
        |Third Line
        """.trimMargin()

data class Customer(var name: String, val email: String)
object Resource {
    val name = "Name"
}


interface Bar
interface Fooe<out T : Any> : Bar{
    fun foo(a: Int): T
}