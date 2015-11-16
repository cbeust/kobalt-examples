package com.beust.kobalt.example.mixed

fun main(argv: Array<String>) {
    println("Kotlin calling Java: " + JavaClass().sayHello())
    val date = org.joda.time.LocalDate()
    println("Time from Kotlin: $date}")
}
