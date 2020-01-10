# Test Construction

### File Organization

Tests are note limited to 1 file per class.

The file should be named based on the tests it contains.


### Fixtures

A fixture is an environment containing a series of tools (initialization, 
variables, helper functions) used by the tests of that file.

Example:
```
@RunWith(...)
class SoundexClass {

    val soundex = Soundex()

    @Test
    fun verifyFirstCharacter_isLetter() {
        soundex.encode("...")
    }
}
```

Here, the `soundex` variable is part of the fixture.

### Given-When-Then

This is explained in notes of chapter 3.

We can se the GWT as a way to organize our tests.

```
TEST_F(ARetweetCollection, IgnoresDuplicateTweetAdded) {

// Given 
Tweet tweet("msg", "@user");
Tweet duplicate(tweet);

// When
collection.add(tweet);
collection.add(duplicate);

// Then
ASSERT_THAT(collection.size(), Eq(1u));
}
```

IMPORTANT: TDD verifies behavior, not only running tests.

This is a very important statement:
**A core goal of doing TDD is to obtain as much feedback as possible as often as possible.
When you change a small bit of code, you want to know immediately whether your change was correct.**

1. Unit tests: super fast (almost immediately)
2. Integration tests: slower (they involve external code, such as db connection, services, etc.)
3. (ANDROID ONLY) Instrumented tests: hyper slow (using espresso, involve UI)

The ability of splitting tests in fast tests and slow tests is crucial for TDD. Since
the every iteration of the TDD cycle requires to run all of the tests, if there are some
tests that took more than 10 seconds, the process will become very slow and the TDD will turn
less viable.

Hamcrest assertions were introduced to increase the readability of all the tests. `Hamcrest`
is an anagram for `matcher`, which is the main principle of this type of assertions.

For example:

```
string actual = string("al") + "pha";
ASSERT_THAT(actual, Eq("alpha"));
```

This assertions is read as follow: ssert that the `actual` value is `equal` to `"alpha"`.

It's ok to expose some members of a class just for testing purposes.
In kotlin, we have the `internal` modifier, which  is useful to prevent the visibility
outside the current module.

