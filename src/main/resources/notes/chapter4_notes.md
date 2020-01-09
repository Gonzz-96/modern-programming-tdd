# Test Construction

### File Organization

Tests are note limited to 1 file per class.

The file should be named based on the tests it contains.


### Fixtures

A fixture is an environment that contains a series of tools (initialization, 
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
When you change a small bit of code, you want to know immedi- ately whether your change was correct.**

1. Unit tests: super fast (almost immediately)
2. Integration tests: slower (they involve external code, such as db connection, services, etc.)
3. (ANDROID ONLY) Instrumented tests: hyper slow (using espresso, involve UI)

