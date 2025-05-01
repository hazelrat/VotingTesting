/*
This is the Logic class. It contains a number of pre-defined functions providing statistical analysis of the election.
Do not add or retract any functions from this class, or change their arguments or qualities.
These are automatically tested by the testing file in this project! Please use the automated tests to check your work.
*/

package org.assignment;

import java.util.ArrayList;

public class Logic {

    /*
    Should return total number of votes cast between candidates.
    */
    static Integer totalVoteCount(ArrayList<Candidate> candidates) {
        return null;
    }

    /*
    Should return range of votes cast, as a String.
    The format of the return value should be as follows: [minimum value of range] + " - " + [maximum value of range]
    */
    static String totalVoteRange(ArrayList<Candidate> candidates) {
        return null;
    }

    /*
    Should return the candidate with the most votes, as a Candidate object.
    */
    static Candidate voteMode(ArrayList<Candidate> candidates) {
        return null;
    }

    /*
    Should return the percentage of all the candidates as a list of strings, each containing the name and percentage.
    Each percentage value should be rounded correctly to within two decimal digits.
    The format of the returned entries should be as follows: [name] + " - " + [percentage number] + "%"
    Refer to the automated test for this function if you believe you have a formatting error.
    */
    static ArrayList<String> getPercentages(ArrayList<Candidate> candidates) {
        return null;
    }
}
