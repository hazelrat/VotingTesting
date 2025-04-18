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

    // Getters
    String getIdentifier() {
        return this.name;
    }

    Integer getVotes() {
        return this.votes;
    }

    static void addCandidates(ArrayList<Candidate> candidate) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("src/main/java/org/assignment/candidates.json"), candidate);
    }

    static void clearCandidates() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("src/main/java/org/assignment/candidates.json"), null);
    }

    static ArrayList<Candidate> retrieveCandidates() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("src/main/java/org/assignment/candidates.json"), new TypeReference<>() {});
    }

    // Reliant on retrieveCandidates.
    static void addVote(String candidateName) throws IOException {
        ArrayList<Candidate> currentValues = retrieveCandidates();
        for (Candidate currentValue : currentValues) {
            if (Objects.equals(currentValue.name, candidateName)) {
                currentValue.votes += 1;
            }
        }
        addCandidates(currentValues);
    }

    // retrieve, loop, cut out the unwanted one, return?
    static void removeCandidate(String candidateName) throws IOException {
        ArrayList<Candidate> currentValues = retrieveCandidates();
        currentValues.removeIf(currentValue -> Objects.equals(currentValue.name, candidateName));
        addCandidates(currentValues);
    }


    static String calculateWinner() throws IOException {
        ArrayList<Candidate> currentValues = retrieveCandidates();
        return "";
    }
}