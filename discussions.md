* Addressing a group of developers and not testers

### Testing according to developers

* Boring thing
* Punishment
* You are on bench and don't have anything to do; 1) write documentation 2) write test cases

* **Testing** -> A way by which you gain insight into an application
* You look at the tests written by a developer and you begin to understand what the application does

* **Verification** -> Verify what your application or piece of functionality does
* I didn't touch that portion of code; **But it works in my machine though**


### Which part of your code needs tests?

* Test Pyramid (https://martinfowler.com/articles/practical-test-pyramid/testPyramid.png)
* The lowest portion of your code; The critical part of your code which contains the business logic
* **Core processing logic or business logic is the portion that needs testing/verification**


### What is Unit in Unit testing?

* In functional language a function is an unit
* In OO class or a method is an unit

### When do you write unit tests?

* **Unit testing is an act of design and not an act of verification** - Kent Beck

####
* Unit tests need to be written "WHILE" writing code or "BEFORE" writing code

* Requirement is not clear
* Test cases are not clear
* You gain clarity on requirement only after development
* If the code is not ready what is the use of writing test cases before?
* Example: Excel file writing

#### Example

* Create excel files
* Some test data or from db
* test data needs transformation/processing 
* Formatted data needs to be written as excel files
* Pending -> Where do you store the excel files? Frequency of writing? Trigger creation of excel files (**NOT BLOCKERS**)

### What is the first piece of code you will write?

* Create Sample API for now
* Start writing Service
* Start writing DB calls in service

* Create the project(rest api)
* DO NOT WRITE ANY rest controller/api code for now
* Do not write any service class/method for now
* START with the implementation of transformation/processing of test data

### Unit tests should not be written on trivial code but only on critical piece of code



### Structure of  Junit test cases

* junit-jupiter is the latest version; jupiter gives the API + runner
* junit jupiter is also extensible. You can create extensions and plug them in
* Include the dependency in your maven/gradle
* Every class that begins or ends with **Test** or **TestCase** is automatically run
* Every test is a method (non-private) method annotated with **@Test**
* Assertions and check for the conditions
* Every test (test method) is run **independent** of the other; And not sequentially; It's run parallely; So no guarantee on the order
* **AAA** -> Arrange, Act, Assert;  **GWT** -> given, when, then


### TDD

* Unit tests act as users of your code
* Write your unit tests first and fill in the methods to invoke the target class
* Use IDE support to generate methods for the target class
* One of the add on benefits is you write very less redundant code
* You don't really worry about testing private methods etc. Because you drive your code design by writing tests; 
* Your tests ALWAYS invoke the public methods; private methods are the **result of refactoring** public methods



### Need for mocking

* **Seamless development**
* **Isolation**
* **Loose coupling** between classes or entities

* User input say from UI can be mocked
* Avoid the dependencies used for that class! To control the behavior?
* Test cases should run irrespective of the environment; Isolation
* Avoid data retrieval from DB; Mock with dummy data

* Rajan and Sravanthi are working with their code
* Rajan develops a class **MyLibrary**
* Sravanthi develops a class **MyCollection**
* **MyLibrary** uses **MyCollection** class

#### During development

* Rajan is actively coding 
* Sravanthi is off suddenly for 2-3 days, because of some emergency
* Sravanthi is available but has not completed her development work because she gets pulled into some production issue
* Sravanthi's work is getting delayed because the server that she needs to interact with is down
* Sravanthi has completed her code, but whenever Rajan invokes her code, his code crashes

* What will Rajan do?
* Will he comment out all the integration work?
* Will he wait till Sravanthi completes all her other work and comes back?
* Will he wait till Sravanthi comes back from vacation?



























