package com.github.iot1009.lab2_scorekeeper;

import java.util.Random;

public class Scorekeeper_Data {
    private static int FirstTeamPoint;
    private static int SecondTeamPoint;
    private static int ScoreSystem; // basketball by default
    private static int[] BasketBallScoreSystem;
    private static int[] AmeFootBallScoreSystem;

    private static Random rand;

    // initialize data
    public static void InitStats() {
        FirstTeamPoint = 0;
        SecondTeamPoint = 0;
        ScoreSystem = 0;
        BasketBallScoreSystem = new int[]{1,2,4};
        AmeFootBallScoreSystem = new int[]{1,2,3,6};
        rand = new Random();
    }

    // return current scoring system
    public static int getScoreSystem() {
        return ScoreSystem;
    }
    /**
     * set current scoring system.
     * @param category: 0 stands for basketball scoring system. 1 stands for american football scoring system
     */
    public static void setScoreSystem(int category) {
        ScoreSystem = category;
    }

    // return first team current point
    public static int getFirstTeamPoint() {
        return FirstTeamPoint;
    }
    /**
     * Randomly choose a score from a system then add or remove that amount from firs team's current point
     * @param multiplier: either 1 or -1. It's an increase in point if a 1, and a decrease in point if -1
     */
    public static void setFirstTeamPoint(int multiplier) {
        if (ScoreSystem == 0)
        {
            FirstTeamPoint += (BasketBallScoreSystem[rand.nextInt(BasketBallScoreSystem.length)] * multiplier);
        }
        else
        {
            FirstTeamPoint += (AmeFootBallScoreSystem[rand.nextInt(AmeFootBallScoreSystem.length)] * multiplier);
        }
    }

    // return second team current point
    public static int getSecondTeamPoint() {
        return SecondTeamPoint;
    }
    /**
     * Randomly choose a score from a system then add or remove that amount from second team's current point
     * @param multiplier: either 1 or -1. It's an increase in point if a 1, and a decrease in point if -1
     */
    public static void setSecondTeamPoint(int multiplier) {
        if (ScoreSystem == 0)
        {
            SecondTeamPoint += (BasketBallScoreSystem[rand.nextInt(BasketBallScoreSystem.length)] * multiplier);
        }
        else
        {
            SecondTeamPoint += (AmeFootBallScoreSystem[rand.nextInt(AmeFootBallScoreSystem.length)] * multiplier);
        }
    }

    // set all points to 0
    public static void resetPoints() {
        FirstTeamPoint = 0;
        SecondTeamPoint = 0;
    }





}
