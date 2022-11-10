# GildedRose Refactoring

The refactoring process was fairly simple and straight to the point.  

## GildedRose.java

Implemented **Move Method** by creating methods from `GildedRose.java` and moving them into `Items.java`.   
Used for `definition classes`, `getters` and `setters`, and `cunstructors` that will be used in `Items.java`.  

## Items.java

Added `getters` and `setters` and several `variables` for widely used `Strings` and `Integers` created a `setQuality()` method that specifies if a given quality is the minimum or maximum quality. This improves the performance and quality of code.

### updateQuality()

I removed the `for loop` and nested `if conditions` and replaced them with `switch cases` switching between the names.
Furthermore, I removed redundancies in the `nested ifs` assigned the default values outside of the `switch cases` and kept a small `if condition` for Sulfuras which has no conditions, I kept it to insure 100% testing.
Lastly, I created the variable `Conjured` and applied the requested conditions in the `switch case`.
