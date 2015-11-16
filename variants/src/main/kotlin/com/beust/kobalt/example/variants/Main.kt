package com.beust.kobalt.example.variants

fun main(argv: Array<String>) {
    println("Instanting a product: " + Product().type)
    println("Current flavor/type from BuildConfig: " + BuildConfig.PRODUCT_FLAVOR + " " + BuildConfig.BUILD_TYPE)
}
