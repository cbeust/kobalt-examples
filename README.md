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
