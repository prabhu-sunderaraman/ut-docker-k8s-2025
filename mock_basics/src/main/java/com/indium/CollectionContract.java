package com.indium;

public interface CollectionContract {
    int getSize();

    void add(int value);

    void remove(int value);

    boolean contains(int value);
}
