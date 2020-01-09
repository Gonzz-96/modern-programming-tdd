# Test-driven Development Foundations

### Unit Test and TDD Fundamentals
The result of doing TDD is `unit tests`. This unit verifies the behavior of a **code unit**, 
which is the smallest testable piece of testable piece of code of an application.

 A unit test is organized in four (ordered) parts
 
 1. (Optional) Statements that set up a context for execution (GIVEN)
 2. One or more statements to invoke the behavior you want to verify (WHEN)
 3. One or more statements to verify the expected outcome (THEN)
 4. (Optional) Cleanup statements (for example, to release allocated memory)
 
 Some authors use the term AAA (Arrange-Act-Assert), that is the same of GWT
 
 When doing TDD, the granularity of the tests keeps small, because every test is a small increment in
 the construction of the behavior of code.
 
 How much code can you meaningfully verify in a single assert?
 
 The tests that cover behavior of code end-to-end are called **integration tests**
 
 Integration tests verify code that must `integrate` with other code or with external entities
 (the file system, databases, web protocols, and other API's).
 
 Unit tests allow you to verify unit in isolation from other code.
 
 ### The TDD Cycle: RED-GREEN-REFACTOR
 
 1. Write a test [that fails] (RED)
 2. Get the test to pass (GREEN)
 3. Optimize the design (REFACTOR)
 
 ### The three rules of TDD
 
 1. Write production code only to pass a failing unit tests.
 2. Write no more of a unit test than sufficient to fail (compilation failures are failures)
 3. Write no more production code than necessary to pass the on failing unit test.
 
 