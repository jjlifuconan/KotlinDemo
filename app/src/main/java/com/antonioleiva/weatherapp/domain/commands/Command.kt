package com.antonioleiva.weatherapp.domain.commands
/**
 * @author conanaiflj
 * @date 2019/3/14 0014
 * @description:
 */
interface Command<out T> {
    suspend fun execute(): T
}