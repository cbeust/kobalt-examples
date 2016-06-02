This repository contains various example projects built with Kobalt. You can build them all from the root directory with `./kobaltw assemble`.

# `simple`

A simple project.

# `mixed`

A project that mixes Java and Kotlin sources.

# `flavors`

This project demonstrates the use of flavors with Kobalt, which let you produce different artifacts with similar sources based on which task you run:

```
$ ./kobaltw flavors:runFreeDebug
...
========== flavors:runFreeDebug
Instanting a product: Free product

$ ./kobaltw flavors:runProDebug
...
========== flavors:runProDebug
Instanting a product: Pro product
```

This project has two `Products.kt` source files in the `src/free/kotlin` and `src/pro/kotlin` directories respectively. The task you run decides which one gets compiled and run.

# `android`

A basic Android example.

# `androidFlavors`

An Android example showing resource merging and flavors. Try the following target:

```
./kobaltw androidFlavors:runFreeDebug
```

Then launch the app called "Kobalt Helloworld" on your device. Other targets of interest:

 - `androidFlavors:runFreeRelease`
 - `androidFlavors:runProDebug`
 - `androidFlavors:runProRelease`

 Each of these will display their product flavor and build type on the main screen along with a different background color (green for "free" and red for "pro") to demonstrate various layouts based on the product flavor.

# `processor` and `sample`

Illustrate how to run an annotation processor with Kobalt. All you need to do is declare that your project depends on the annotation
processor project and Kobalt will automatically run the annotation processor before building your project.

See it in action with: `./kobaltw sample:run`.


