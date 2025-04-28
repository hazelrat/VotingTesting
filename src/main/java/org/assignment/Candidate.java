/*
This is the Candidate class. It contains a constructor for an object that should be used to represent a candidate.
Do not deviate from this object, as automated tests later in the project depend on it.
*/

package org.assignment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Candidate {
    @JsonProperty("name")
    String name;
    @JsonProperty("votes")
    Integer votes;

    // Class constructor
    @JsonCreator
    public Candidate(
            @JsonProperty("name") String canName,
            @JsonProperty("votes") int canVotes) {
        this.name = canName;
        this.votes = canVotes;
    }

    /*
    Populates the candidates json file.
    Note that this is not additive! This will replace anything previous.
    */
    static void addCandidates(ArrayList<Candidate> candidate) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("src/main/java/org/assignment/candidates.json"), candidate);
    }

    /*
    Clears all contents of the json file.
    */
    static void clearCandidates() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("src/main/java/org/assignment/candidates.json"), null);
    }

    /*
    Retrieves candidate list from json file.
    */
    static ArrayList<Candidate> retrieveCandidates() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("src/main/java/org/assignment/candidates.json"), new TypeReference<>() {});
    }

    /*
    Adds a singular candidate to the existing list, beginning at zero votes.
    */
    static void addSingleCandidate(String candidateName) throws IOException {
        ArrayList<Candidate> currentValues = retrieveCandidates();
        Candidate newAddition = new Candidate(candidateName, 0);
        currentValues.add(newAddition);
        addCandidates(currentValues);
    }

    /*
    Adds a single vote to a single candidate, as differentiated by their name.
    */
    static void addVote(String candidateName) throws IOException {
        ArrayList<Candidate> currentValues = retrieveCandidates();
        for (Candidate currentValue : currentValues) {
            if (Objects.equals(currentValue.name, candidateName)) {
                currentValue.votes += 1;
            }
        }
        addCandidates(currentValues);
    }

    /*
    Indiscriminately clears all stored votes.
    */
    static void clearVotes() throws IOException {
        ArrayList<Candidate> currentValues = retrieveCandidates();
        for (Candidate currentValue : currentValues) {
            currentValue.votes = 0;
        }
        addCandidates(currentValues);
    }

    /*
    Removes a single candidate from the list, as differentiated by their name.
     */
    static void removeCandidate(String candidateName) throws IOException {
        ArrayList<Candidate> currentValues = retrieveCandidates();
        currentValues.removeIf(currentValue -> Objects.equals(currentValue.name, candidateName));
        addCandidates(currentValues);
    }

    /*
    Calculates the winner of the election. This should work based on absolute majority.
    If absolute majority via a single candidate is achieved, this should return an empty string.
    */
    static String calculateWinner() throws IOException {
        ArrayList<Candidate> currentValues = retrieveCandidates();
        Integer totalVotes = 0;

        // Finding total number of votes.
        for (Candidate candidate : currentValues) {
            totalVotes += candidate.votes;
        }

        // Checking percentage.
        ArrayList<Double> percentageValues = new ArrayList<>();
        for (Candidate candidate : currentValues) {
            Double percent = Double.valueOf(candidate.votes);
            percentageValues.add(percent + totalVotes * 100);
        }

        // Returns no absolute majority by standard.
        String returnValue = "No absolute majority detected.";

        // Checks for an absolute majority.
        for (int i = 0; i < percentageValues.size(); i++) {
            if (percentageValues.get(i) >= 50) {
                returnValue = "Absolute majority has been achieved by: " + currentValues.get(i).name + ", who has thereby won the election!";
            }
        }

        return returnValue;
    }
}