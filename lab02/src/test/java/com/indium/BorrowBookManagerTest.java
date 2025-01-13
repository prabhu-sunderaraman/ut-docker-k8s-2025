package com.indium;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BorrowBookManagerTest {
    @InjectMocks
    private BorrowBookManager borrowBookManager;
    @Mock
    private BookService bookService;
    @Mock
    private NotificationService notificationService;

    @Test
    void instances_are_not_null() {
        assertNotNull(borrowBookManager);
        assertNotNull(borrowBookManager.getBookService());
        assertNotNull(borrowBookManager.getNotificationService());
    }

    @Test
    void book_is_available() {
        String bookId = "b101";
        String userId = "u101";
        when(bookService.isAvailable(bookId)).thenReturn(true);
        doNothing().when(bookService).borrow(bookId, userId);
        doNothing().when(notificationService).sendNotification("u101", "Book b101 is available for you to borrow");

        boolean available = borrowBookManager.borrow(bookId, userId);
        assertTrue(available);
        verify(bookService, times(1)).isAvailable(bookId);
        verify(bookService, times(1)).borrow(bookId, userId);
        verify(notificationService, times(1)).sendNotification(userId, "Book b101 is available for you to borrow");
    }

    @Test
    void book_is_not_available() {
        String bookId = "b101";
        String userId = "u101";
        when(bookService.isAvailable(bookId)).thenReturn(false);
        doNothing().when(notificationService).sendNotification("u101", "Book b101 is not available for you to borrow");
        boolean available = borrowBookManager.borrow(bookId, userId);
        assertFalse(available);
        verify(bookService, times(1)).isAvailable(bookId);
        verify(bookService, times(0)).borrow(bookId, userId);
        verify(notificationService, times(1)).sendNotification(userId, "Book b101 is not available for you to borrow");
    }

    @Test
    void invalid_bookId() {
        String bookId = null;
        String userId = "u101";
        assertThrows(InvalidBookIdException.class, () -> borrowBookManager.borrow(bookId, userId));
    }

    @Test
    void invalid_userId() {
        String bookId = "b101";
        String userId = null;
        assertThrows(InvalidUserIdException.class, () -> borrowBookManager.borrow(bookId, userId));
    }
}
