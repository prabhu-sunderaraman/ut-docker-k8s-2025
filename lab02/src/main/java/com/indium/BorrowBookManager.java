package com.indium;

public class BorrowBookManager {
    private BookService bookService;
    private NotificationService notificationService;

    public BookService getBookService() {
        return bookService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public boolean borrow(String bookId, String userId) {
        checkIfBookIdIsValid(bookId);
        checkIfUserIdIsValid(userId);
        boolean available = bookService.isAvailable(bookId);
        String message = "Book " + bookId + " is available for you to borrow";
        if (available) {
            bookService.borrow(bookId, userId);
        } else {
            message = "Book " + bookId + " is not available for you to borrow";
        }
        notificationService.sendNotification(userId, message);
        return available;
    }

    private void checkIfUserIdIsValid(String userId) {
        if (userId == null || userId.isEmpty()) {
            throw new InvalidUserIdException("UserId is invalid");
        }
    }

    private void checkIfBookIdIsValid(String bookId) {
        if (bookId == null || bookId.isEmpty()) {
            throw new InvalidBookIdException("BookId is invalid");
        }
    }
}
