#### Lab02
* Create a java project and add the following dependencies

``` xml
    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.10.3</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>5.11.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-junit-jupiter</artifactId>
            <version>5.11.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

* Develop a Book service in a library management system to handle book borrowing and notification operations. 

#### Requirements:

* **BookService**: A service that manages the availability of books.
* **Method**: boolean isAvailable(String bookId) checks if a book is available for borrowing.
* **Method**: void borrow(String bookId, String userId) marks the book as borrowed by the user.

* **NotificationService**: A service that handles user notifications.
* **Method**: void sendNotification(String userId, String message) sends a notification to a user.

* **BorrowBookManager**: A class you need to implement that coordinates book borrowing and notification operations.
* **Method**: boolean borrowBook(String bookId, String userId) performs the following:
* Checks if the book is available using BookService.
* **If the book is available**: Marks the book as borrowed using BookService; Sends a notification to the user confirming the borrowing using NotificationService; Returns true.
* **If the book is unavailable**: Sends a notification to the user saying the book is not available. Returns false.

#### ToDo
* Write unit tests for **BorrowBookManager** using **Mockito**. Mock BookService and NotificationService to:

* Verify interactions (e.g., borrow and sendNotification methods are called with the correct arguments).
* Simulate scenarios where the book is available and unavailable.

#### Note

* You **cannot modify** the BookService or NotificationService interfaces.
* Ensure all methods in BorrowBookManager are tested thoroughly with mock verifications.
