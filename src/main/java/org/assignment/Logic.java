package org.assignment;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Logic {

    // Should return total number of votes cast.
    static Integer totalVoteCount(ArrayList<Candidate> candidates) {
        int totalValue = 0;
        for (Candidate candidate : candidates) {
            totalValue += candidate.votes;
        }
        return totalValue;
    }

    // Should return range of votes cast, as a String.
    static String totalVoteRange(ArrayList<Candidate> candidates) {
        ArrayList<Integer> rangeValues = new ArrayList<>();
        for (Candidate candidate : candidates) {
            rangeValues.add(candidate.votes);
        }
        return Collections.min(rangeValues) + " - " + Collections.max(rangeValues);
    }

    // Should return the percentage of all the candidates, as Strings.
    static ArrayList<String> getPercentages(ArrayList<Candidate> candidates) {
        ArrayList<Integer> integerValues = new ArrayList<>();
        Integer totalVotes = 0;

        for (Candidate candidate : candidates) {
            integerValues.add(candidate.votes);
            totalVotes += candidate.votes;
        }

        ArrayList<Double> percentageValues = new ArrayList<>();
        for (Integer integerValue : integerValues) {
            Double percent = Double.valueOf(integerValue);
            percentageValues.add(percent / totalVotes * 100);
        }

        DecimalFormat numberFormat = new DecimalFormat("#.00");
        ArrayList<String> completeValues = new ArrayList<>();
        for (int i = 0; i < candidates.size(); i++) {
            Candidate candidateValue = candidates.get(i);
            String nameValue = candidateValue.name;
            completeValues.add(nameValue + " - " + numberFormat.format(percentageValues.get(i)) + "%");
        }

        return completeValues;
    }

    // Should provide percentage estimates for the candidates.
    static Double getCandidateEstimate(String candidateName) {
        return null;
    }

    // Should return the possible coalitions as a result of the vote.
    static String possibleCoalitions(ArrayList<Candidate> candidates) {
        return null;
    }
}
