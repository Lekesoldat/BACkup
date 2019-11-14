# The domain- and persistence-logic is located in the core module

`/src/main/java/backend/json` contains the JSONHandler.java and uses GSON to serialize and deserialize Objects when reading and writing to files. This is utilized on the landingpage and trackerpage, respectively. This, in other words, is the source code for the persistence layer.

Its adjacent folder, `/src/main/java/backend/core`, holds the core logic.
Indeed, all the .java-files (classes for BAC, Person, Drink, etc) is located here.

**Color.java** is only included to simplify printing with colors, and is used extensively to accompany the feedback printed in the terminal when launching the app. The other files handles the logic, and are split up into different intuitive classes, for better re-use of code and modularization.

`/test/java/backend/core` is naturally for the tests. For complete test coverage, we have one test for each class, and the JSONHandler is also tested.
We have tested most, if not all, of the class's intended functionality. The folder structure is pretty much identical to the _src_ folder, for better overview.
