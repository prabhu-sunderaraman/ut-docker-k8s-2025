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















