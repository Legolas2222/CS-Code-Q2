package com.abiaufgabe1graph;

public class Person extends Vertex {
    private char geschlecht;

    public Person(String pID, char geschlecht) {
        super(pID);
        this.geschlecht = geschlecht;
    }

    public char getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(char geschlecht) {
        this.geschlecht = geschlecht;
    }

}
