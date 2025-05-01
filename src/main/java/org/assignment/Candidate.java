/*
This is the Candidate class. It contains a constructor for an object that should be used to represent a candidate.
Do not deviate from this object, as automated tests later in the project depend on it.
*/

package org.assignment;

public class Candidate {
    String name;
    Integer votes;

    // Class constructor
    public Candidate(String canName, int canVotes) {
        this.name = canName;
        this.votes = canVotes;
    }
}