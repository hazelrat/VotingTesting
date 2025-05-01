/*
This is the main class. You should be able to run the application from here once complete!
You are expected to implement a voting system within this file, utilising the Candidate class and functions therein.
Votes should be stored persistently, and the user should be able to lodge votes and edit the list of candidates.
For higher marks, you may implement statistical functions already defined in the Logic class.
You can utilise the LogicTests class to automatically test your work in the Logic class.
Please refer to the brief for more comprehensive criteria!
*/

package org.assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.assignment.Candidate.*;
import static org.assignment.Logic.*;

public class Main {
    public static void main(String[] args) throws IOException {
        mainMenu();
    }

    static void mainMenu() throws IOException {
        System.out.println("""
                
                Welcome to the Voting Application! Please select an option from below:
                
                1: I would like to lodge a vote.
                2: I would like to edit the list of candidates.
                3: I would like to access data relating to the election.
                4: I would like to determine the winner of this election.
                5: I would like to exit the application.
                """);

        Scanner menu = new Scanner(System.in);
        String menuInput = menu.nextLine();

        switch(menuInput) {
            case "1":
                vote();
                break;
            case "2":
                candidates();
                break;
            case "3":
                statistics();
                break;
            case "4":
                determineWinner();
                break;
            case "5":
                shutdown();
            default:
                System.out.println("You have entered an invalid input.");
        }
    }

    static void vote() throws IOException {
        System.out.println("Please enter the name of the candidate you would like to vote for.");
        Scanner voteInput = new Scanner(System.in);
        String voteString = voteInput.nextLine();

        addVote(voteString);
        System.out.println("Your vote has now been lodged!");
        mainMenu();
    }

    static void candidates() throws IOException {
        System.out.println("""
                How would you like to edit the candidates list?
                
                1: I would like to add a new candidate.
                2: I would like to remove a candidate.
                3: I would like to view a list of all candidates.
                4: I would like to clear all candidates.
                5: I would like to clear all votes.
                6: I would like to return to the main menu.
                """);

        Scanner candidateInput = new Scanner(System.in);
        String candidateString = candidateInput.nextLine();

        switch (candidateString) {
            case "1":
                System.out.println("Please enter the name of the new candidate.");
                Scanner newCandidateInput = new Scanner(System.in);
                String newCandidateString = newCandidateInput.nextLine();

                System.out.println("Attempting to add new candidate...");
                addSingleCandidate(newCandidateString);
                break;
            case "2":
                System.out.println("Please enter the name of the candidate to be removed.");
                Scanner removeCandidateInput = new Scanner(System.in);
                String removeCandidateString = removeCandidateInput.nextLine();

                System.out.println("Attempting to remove candidate...");
                removeCandidate(removeCandidateString);
                break;
            case "3":
                ArrayList<Candidate> currentCandidates = retrieveCandidates();
                for (Candidate candidate : currentCandidates) {
                    System.out.println("Candidate: " + candidate.name);
                    System.out.println("Votes: " + candidate.votes);
                }
                break;
            case "4":
                System.out.println("Clearing all candidates...");
                clearCandidates();
                break;
            case "5":
                System.out.println("Clearing all votes...");
                clearVotes();
                break;
            case "6":
                mainMenu();
            default:
                System.out.println("You have entered an invalid input.");
        }
        mainMenu();
    }

    static void statistics() throws IOException {
        System.out.println("""
                Which statistical function would you like to access?
                
                1: How many votes in total have been lodged?
                2: What is the range in the number of votes between candidates?
                3: Which candidate has the most votes?
                4: What are the percentages of votes?
                5: I would like to return to the main menu.
                """);

        Scanner statisticInput = new Scanner(System.in);
        String statisticString = statisticInput.nextLine();
        ArrayList<Candidate> currentCandidates = retrieveCandidates();

        switch (statisticString) {
            case "1":
                System.out.println("The current total number of votes across all candidates is: " + totalVoteCount(currentCandidates));
                break;
            case "2":
                System.out.println("The current range in votes is: " + totalVoteRange(currentCandidates));
                break;
            case "3":
                Candidate modeCandidate = voteMode(currentCandidates);
                System.out.println("The current candidate with the most votes is: " + modeCandidate.name + ", with " + modeCandidate.votes + " votes.");
                break;
            case "4":
                ArrayList<String> percentages = getPercentages(currentCandidates);
                for (String percentage : percentages) {
                    System.out.println(percentage);
                }
                break;
            case "5":
                mainMenu();
            default:
                System.out.println("You have entered an invalid input.");
        }

        mainMenu();
    }

    static void determineWinner() throws IOException {
        String winnerMessage = calculateWinner();
        System.out.println(winnerMessage);
    }

    static void shutdown() {
        System.out.println("Shutting down application!");
        System.exit(0);
    }
}