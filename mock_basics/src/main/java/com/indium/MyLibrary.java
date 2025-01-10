package com.indium;

public class MyLibrary {
    private MyCollection myCollection;

    public int getSize() {
        return myCollection.getSize();
    }

    public void add(int value) {
        myCollection.add(value);
    }

    public void remove(int value) {
        if (!myCollection.contains(value)) {
            throw new ItemNotFoundException("Item %s not found".formatted(value));
        }
        myCollection.remove(value);
    }

    public void setMyCollection(MyCollection myCollection) {
        this.myCollection = myCollection;
    }


    public MyCollection getMyCollection() {
        return myCollection;
    }
}
