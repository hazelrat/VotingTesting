/*
This is the Logic class. It contains a number of pre-defined functions providing statistical analysis of the election.
Do not add or retract any functions from this class, or change their arguments or qualities.
These are automatically tested by the testing file in this project! Please use the automated tests to check your work.
*/

package org.assignment;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Logic {

    /*
    Should return total number of votes cast between candidates.
    */
    static Integer totalVoteCount(ArrayList<Candidate> candidates) {
        int totalValue = 0;
        for (Candidate candidate : candidates) {
            totalValue += candidate.votes;
        }
        return totalValue;
    }

    /*
    Should return range of votes cast, as a String.
    The format of the return value should be as follows: [minimum value of range] + " - " + [maximum value of range]
    */
    static String totalVoteRange(ArrayList<Candidate> candidates) {
        ArrayList<Integer> rangeValues = new ArrayList<>();
        for (Candidate candidate : candidates) {
            rangeValues.add(candidate.votes);
        }
        return Collections.min(rangeValues) + " - " + Collections.max(rangeValues);
    }

    /*
    Should return the candidate with the most votes, as a Candidate object.
    */
    static Candidate voteMode(ArrayList<Candidate> candidates) {
        Candidate returnCandidate = new Candidate("PLACEHOLDER", 0);
        for (Candidate candidate : candidates) {
            if (candidate.votes > returnCandidate.votes) {
                returnCandidate = candidate;
            }
        }
        return returnCandidate;
    }

    /*
    Should return the percentage of all the candidates as a list of strings, each containing the name and percentage.
    Each percentage value should be rounded correctly to within two decimal digits.
    The format of the returned entries should be as follows: [name] + " - " + [percentage number] + "%"
    Refer to the automated test for this function if you believe you have a formatting error.
    */
    static ArrayList<String> getPercentages(ArrayList<Candidate> candidates) {
        // Using prior function to retrieve total number of votes. Necessary for percentage calculation.
        Integer totalVotes = totalVoteCount(candidates);

        // Populating list with percentages!
        ArrayList<Double> percentageValues = new ArrayList<>();
        for (Candidate candidate : candidates) {
            Double percent = Double.valueOf(candidate.votes);
            percentageValues.add(percent / totalVotes * 100);
        }

        // Formatting the percentages into a string.
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        ArrayList<String> completeValues = new ArrayList<>();
        for (int i = 0; i < candidates.size(); i++) {
            Candidate candidateValue = candidates.get(i);
            String nameValue = candidateValue.name;
            completeValues.add(nameValue + " - " + numberFormat.format(percentageValues.get(i)) + "%");
        }

        return completeValues;
    }
}
