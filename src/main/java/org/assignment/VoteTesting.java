package org.assignment;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.assignment.Candidate.*;
import static org.assignment.Logic.*;
import static org.junit.Assert.assertEquals;

public class VoteTesting {

    @Test
    public void totalVoteCountTest() throws IOException {
        ArrayList<Candidate> candidatesList = new ArrayList<>();
        Candidate Object1 = new Candidate ("John Smith", 2);
        Candidate Object2 = new Candidate ("Jane Smith", 12);
        Candidate Object3 = new Candidate ("Reginald Smith", 4);
        candidatesList.add(Object1);
        candidatesList.add(Object2);
        candidatesList.add(Object3);
        addCandidates(candidatesList);

        ArrayList<Candidate> candidates = retrieveCandidates();
        int receivedValue = totalVoteCount(candidates);
        assertEquals(18, receivedValue);
    }

    @Test
    public void totalVoteRangeTest() throws IOException {
        ArrayList<Candidate> candidatesList = new ArrayList<>();
        Candidate Object1 = new Candidate ("John Smith", 2);
        Candidate Object2 = new Candidate ("Jane Smith", 12);
        Candidate Object3 = new Candidate ("Reginald Smith", 4);
        candidatesList.add(Object1);
        candidatesList.add(Object2);
        candidatesList.add(Object3);

        String receivedValue = totalVoteRange(candidatesList);
        assertEquals("2 - 12", receivedValue);
    }

    @Test
    public void getPercentagesTest() throws IOException {
        ArrayList<Candidate> candidatesList = new ArrayList<>();
        Candidate Object1 = new Candidate ("John Smith", 5);
        Candidate Object2 = new Candidate ("Jane Smith", 10);
        Candidate Object3 = new Candidate ("Reginald Smith", 5);
        candidatesList.add(Object1);
        candidatesList.add(Object2);
        candidatesList.add(Object3);

        ArrayList<String> receivedValue = getPercentages(candidatesList);
        assertEquals("John Smith - 25.00%", receivedValue.get(0));
        assertEquals("Jane Smith - 50.00%", receivedValue.get(1));
        assertEquals("Reginald Smith - 25.00%", receivedValue.get(2));
    }

    @Test
    public void getCandidateEstimateTest() throws IOException {
    }

    public void possibleCoalitionsTest() throws IOException {
    }
}
