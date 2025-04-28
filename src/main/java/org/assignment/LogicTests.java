package org.assignment;

import org.junit.Test;

import java.util.ArrayList;

import static org.assignment.Logic.*;
import static org.junit.Assert.assertEquals;

public class LogicTests {

    @Test
    public void totalVoteCountTest() {
        ArrayList<Candidate> candidatesList = new ArrayList<>();
        Candidate Object1 = new Candidate ("John Smith", 2);
        Candidate Object2 = new Candidate ("Jane Smith", 12);
        Candidate Object3 = new Candidate ("Reginald Smith", 4);
        candidatesList.add(Object1);
        candidatesList.add(Object2);
        candidatesList.add(Object3);

        int receivedValue = totalVoteCount(candidatesList);
        assertEquals(18, receivedValue);
    }

    @Test
    public void totalVoteRangeTest() {
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
    public void voteModeTest() {
        ArrayList<Candidate> candidatesList = new ArrayList<>();
        Candidate Object1 = new Candidate ("John Smith", 2);
        Candidate Object2 = new Candidate ("Jane Smith", 12);
        Candidate Object3 = new Candidate ("Reginald Smith", 4);
        candidatesList.add(Object1);
        candidatesList.add(Object2);
        candidatesList.add(Object3);

        Candidate receivedValue = voteMode(candidatesList);
        assertEquals("Jane Smith", receivedValue.name);
    }

    @Test
    public void getPercentagesTest() {
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
}
