package org.assignment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Candidate {
    @JsonProperty("identifier")
    Integer identifier;
    @JsonProperty("name")
    String name;
    @JsonProperty("votes")
    Integer votes;

    // Class constructor
    @JsonCreator
    public Candidate(
            @JsonProperty("identifier") int canIdentifier,
            @JsonProperty("name") String canName,
            @JsonProperty("votes") int canVotes) {
        this.identifier = canIdentifier;
        this.name = canName;
        this.votes = canVotes;
    }

    static void addVote(String candidateName, boolean vote) throws IOException {

    }

    static void addCandidate(ArrayList<Candidate> candidate) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        for (int i = 0; i < candidate.size(); i++) {
            Candidate newEntry = new Candidate(candidate.get(i).identifier, candidate.get(i).name, candidate.get(i).votes);
            objectMapper.writeValue(new File("src/main/java/org/assignment/candidates.json"), newEntry);
        }
    }

    // retrieve, loop, cut out the unwanted one, return?
    static void removeCandidate(String identifier) throws IOException {
    }

    static void clearCandidates() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("src/main/java/org/assignment/candidates.json"), null);
    }

    static Candidate retrieveCandidates() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("src/main/java/org/assignment/candidates.json"), Candidate.class);
    }

    static void endElection() {
    }
}