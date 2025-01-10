package com.indium;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MyLibraryTest {
    private MyLibrary myLibrary;

    @BeforeEach
    public void setUp() {
        myLibrary = new MyLibrary();
        //myLibrary.setMyCollection(new MyCollection());
        myLibrary.setMyCollection(new MyMockCollection1());
    }

    @AfterEach
    public void tearDown() {
        myLibrary = null;
    }

    @Test
    void collection_is_zero_in_the_beginning() {
        assertEquals(0, myLibrary.getSize());
    }

    @Test
    void add_some_value_and_check_size() {
        myLibrary.add(1);
        assertEquals(1, myLibrary.getSize());
    }

    @Test
    void remove_value_and_check_size() {
        myLibrary.add(10);
        myLibrary.add(20);
        myLibrary.remove(20);
        assertEquals(1, myLibrary.getSize());
    }

    @Test
    void remove_a_non_existing_value() {
        myLibrary.add(10);
        myLibrary.add(20);
        assertThrows(ItemNotFoundException.class, () -> {
            myLibrary.remove(30);
        });

    }
}

class MyMockCollection1 extends MyCollection {
    private int size = 0;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void add(int value) {
        size++;
    }

    @Override
    public void remove(int value) {
        size--;
    }

    @Override
    public boolean contains(int value) {
        if (value == 30) {
            return false;
        }
        return true;
    }
}
