package com.example

import java.util.Properties
import java.io.FileReader

class Main {	
}

fun main(argv: Array<String>) {
    val p = Properties()
    p.load(Main::class.java.classLoader.getResourceAsStream("example.properties"))

    println("Flavor class: " + Flavor.NAME)
    println("Property read: " + p.getProperty("string"))
}