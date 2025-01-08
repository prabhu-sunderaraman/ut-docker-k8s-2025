* Create a console-based **Guessing Game** application where the system generates a random number (for instance, between 1 and 100). 
* The player inputs guesses until they correctly guess the number. 
* Display messages like *Aim higher* or *Aim lower* till the player guesses the number correct
* On finding the number correctly, the system should then:
* Display a message indicating the correct guess has been found.
* Report the total number of attempts it took the player to guess the number.
* Store the total number of attempts, the current date time, and the target random number in a json file for record-keeping.

``` json
{
	"target": 77,
	"attempts": 5,
	"datetime": "2025-01-01T09:24:47.311345"
}
```

### ToDo

* Write failing test cases (covering the game logic and database interactions) before implementing each feature.
* Implement the feature only to make the tests pass.
* Refactor your code while keeping all tests green.
* At a minimum, your test coverage should verify:

* The random number generation (within the expected range).
* Correct handling of user input and guess validation.
* Correct incrementing of the attempt counter.
* Proper data store integration (and potentially retrieve) the final attempt count.
