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
public class MyLibraryUsingMockitoTest {
    @Mock
    private MyCollection myCollection;

    @InjectMocks
    private MyLibrary myLibrary;

    @Test
    void test_set_up() {
        assertNotNull(myLibrary);
        assertNotNull(myLibrary.getMyCollection());
    }

    @Test
    void collection_is_zero_in_the_beginning() {
        // Training the mock to return 0 when getSize() is called
        when(myCollection.getSize()).thenReturn(0);

        // Not really useful because we are mocking anyway
        assertTrue(myLibrary.getSize() == 0);

        // check if the mock was called
        verify(myCollection, times((1))).getSize();
    }

    @Test
    void add_a_value_and_check_size() {
        // Training the mock to return nothing when add(1) is called
        doNothing().when(myCollection).add(1);
        // Training the mock to return 1 when getSize() is called
        when(myCollection.getSize()).thenReturn(1);

        myLibrary.add(1);
        assertTrue(myLibrary.getSize() == 1);

        verify(myCollection, times(1)).add(1);
        verify(myCollection, times(1)).getSize();
    }

}
