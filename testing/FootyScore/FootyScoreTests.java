package junit.FootyScore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FootyScoreTests {

    FootyScore footyScore;

    @BeforeEach
    public void ConstructFootyScore(){
        footyScore = new FootyScore();
    }

    @Test
    public void TestGetPoints(){
        footyScore.kickGoal();
        footyScore.kickGoal();
        footyScore.kickBehind();
        footyScore.kickBehind();
        footyScore.kickBehind();
        int runPoints = footyScore.getPoints();
        int actualAnswer = 3*1 + 2*6;
        assertEquals(actualAnswer, runPoints);
    }

    @Test
    public void TestKickGoal(){
        footyScore.kickGoal();
        int runPoints = footyScore.getPoints();
        int actualAnswer = 6;
        assertEquals(actualAnswer, runPoints);
    }

    @Test
    public void TestKickBehind(){
        footyScore.kickBehind();
        int runPoints = footyScore.getPoints();
        int actualAnswer = 1;
        assertEquals(actualAnswer, runPoints);
    }

    @Test
    public void TestStringOutput(){
        footyScore.kickGoal();
        footyScore.kickGoal();
        footyScore.kickGoal();
        footyScore.kickBehind();
        footyScore.kickBehind();
        int score = 3*6 + 2*1;
        String actual = "3, 2, " + score;
        String computed = footyScore.toString();
        assertEquals(actual, computed);
    }

    @Test
    public void TestLosing(){
        FootyScore footyScore2 = new FootyScore();
        footyScore2.kickGoal();
        footyScore.kickBehind();
        int score1 = 1*1;
        int score2 = 1*6;

        boolean computed = footyScore.losing(footyScore2.getPoints());
        boolean actual = score1 < score2;
        assertEquals(actual, computed);
    }

    @Test
    public void TestEqual(){
        FootyScore footyScore2 = new FootyScore();
        footyScore2.kickGoal();
        footyScore.kickGoal();
        int score1 = 1*6;
        int score2 = 1*6;

        boolean computed = footyScore.losing(footyScore2.getPoints());
        boolean actual = score1 < score2;
        assertEquals(actual, computed);
    }

    @Test
    public void TestWinning(){
        FootyScore footyScore2 = new FootyScore();
        footyScore2.kickBehind();
        footyScore.kickGoal();
        int score1 = 1*6;
        int score2 = 1*1;

        boolean computed = footyScore.losing(footyScore2.getPoints());
        boolean actual = score1 < score2;
        assertEquals(actual, computed);
    }
}