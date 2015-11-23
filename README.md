This repository contains various example projects built with Kobalt.

# `simple`

A simple project.

# `mixed`

A project that mixes Java and Kotlin sources.

# `variants`

This module demonstrates the use of variants with Kobalt, which let you produce different artifacts with similar sources based on which task you run:

```
$ ./kobaltw runFreeDebug
...
========== flavors:runFreeDebug
Instanting a product: Free product

$ ./kobaltw runProDebug
...
========== flavors:runProDebug
Instanting a product: Pro product
```

This project has two `Products.kt` source files in the `src/free/kotlin` and `src/pro/kotlin` directories respectively. The task you run decides which one gets compiled and run.

# `android`

A basic Android example.

# `android-flavors`

An Android example showing resource merging and flavors. Try the following target:

```
./kobaltw installFreeDebug
```

Then launch the app called "Kobalt Helloworld" on your device. Other targets of interest:

 - `installFreeRelease`
 - `installProDebug`
 - `installProRelease`

 Each of these will display their product flavor and build type on the main screen along with a different background color (green for "free" and red for "pro") to demonstrate various layouts based on the product flavor.



