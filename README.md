[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/W2hKElMX)
# Homework "Whitebox Testing"

**Goal:** writing JUnit tests, measuring code coverage, using class/test mocking

**References:** 
* https://junit.org/junit5/ 
* https://site.mockito.org/ 
* https://www.eclemma.org/jacoco/trunk/doc/maven.html

**General Homework Gitflow Rules:**
1. No direct commits to either the main or develop branch
2. Only the develop branch may be merged into the main branch
3. Only a feature branch may branch off or be merged into the develop branch
4. Only the develop branch may be merged into the feature branch.
5. Branches may only be merged via a Pull Request.

**Homework Specific Rules:**
1. It is prohibited to modify any of the classes in the WBTesting package in the maven source folder (`src/main`)
2. The SQLite database used by the Data animal must be mocked and no actual invocations of the database are permitted

**Steps for Completing the Homework**
1. For each class *c* in the "Sky" package that implements the Animal interface
    1. Create a branch from the develop branch titled "feature/*c*" 
    2. On the feature branch, create a test class named "*c*Test" in the correct package (sub-folder) in the maven test folder (`src/test`)
    3. For each method *m* in {"makeNoise", "move", "eat"} of *c*
        1. Repeat
            1. In the test class, create a test method *t*
            1. Test *m* by invoking *m* from within *t* 
            1. Verify the response of *m* is correct by including an assertion in *t*
        2. Until *m* has 100% statement and 100% branch coverage per the coverage report
    4. Commit all tests to the feature branch and merge the branch to the develop branch via a pull request.
2. Ensure that all test code has been merged via a pull request to the main branch of your repository


**Useful Stuff to Remember:** 
1. Carefully follow the naming conventions or the grading system will not be able to locate your test classes and methods. 
2. Note that all tests must run and pass with the *mvn test* command in order to receive credit for this assignment.  
3. By default, your coverage report will be located in the "target/site/jacoco" directory.
4. A test class must be in the same package as its target class, meaning it will be in a subfolder in the maven test folder that matches the folder structure in the maven source folder.


