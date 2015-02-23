package droids;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by Nazar on 21.02.2015.
 */
public class Battle {
    int myDroidTurn = -1;
    int enemyDroidTurn = -1;
    //int myDroidIndex;
    int turnNumber = 1;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public Battle(Team myTeam, Team enemyTeam) {
        while (!myTeam.getDroidList().isEmpty() && !enemyTeam.getDroidList().isEmpty()) {
            System.out.println("Enemy team: ");
            enemyTeam.showInfo();

            myTurn(myTeam, enemyTeam);

            try {
                enemyTurn(myTeam, enemyTeam);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!myTeam.getDroidList().isEmpty()) {
                System.out.println("My team: ");
                myTeam.showInfo();
            }
            else {
                System.out.println("Enemy team: ");
                enemyTeam.showInfo();
            }

        }
        if (myTeam.getDroidList().size() >= 1) {
            System.out.println("YOU WIN!!!");
        }
        else System.out.println("You lose!");
    }

    private int enemyTurnAI(Team myTeam) {
        int target;

        if (turnNumber <=2){
            target = chooseRandomTarget(myTeam);
        }
        else if (myTeam.getDroidList().size() == 4)
            target = chooseRandomTarget(myTeam);
        else if (myTeam.getDroidList().size() == 3)
            target = chooseRandomTarget(myTeam);
        else if (myTeam.getDroidList().size() == 2)
            target = chooseRandomTarget(myTeam);
        else
            target = 0;
        return target;
    }

    private int chooseRandomTarget(Team myTeam) {
        Random random = new Random();
        return random.nextInt(myTeam.getDroidList().size() - 1) + 1;
    }

    private void enemyTurn(Team myTeam, Team enemyTeam) throws InterruptedException { // not done yet
        if (enemyTeam.getDroidList().isEmpty()) return;
        turnEnemy(enemyDroidTurn, enemyTeam);
        System.out.println("    Turn number " + turnNumber);
        System.out.println("Enemy's " + enemyTeam.getDroidList().get(enemyDroidTurn) + " turnEnemy");
        System.out.println("Enemy is attacking your " + myTeam.getDroidList().get(enemyTurnAI(myTeam)));


        //Thread.sleep(2000);
        shootEnemyDroid(enemyTeam, myTeam, enemyDroidTurn, enemyTurnAI(myTeam));
        //Thread.sleep(2000);
        turnNumber++;
    }

    private void myTurn(Team myTeam, Team enemyTeam) {
        System.out.println("    Turn number " + turnNumber);
        turn(myDroidTurn, myTeam);
        String enemyIndex;
        int enemyDroidIndex;

        System.out.println("Your " + myTeam.getDroidList().get(myDroidTurn) + " turnEnemy");
        System.out.print("Choose your enemy!\n");

        try {
            do {
                enemyIndex = reader.readLine();
                if (!enemyIndex.matches("[1-5]") || Integer.parseInt(enemyIndex) > enemyTeam.getDroidList().size()){
                    System.out.println("Invalid request. Please enter number: 1-" + enemyTeam.getDroidList().size());
                }
            }
            while (!enemyIndex.matches("[1-5]"));
            enemyDroidIndex = Integer.parseInt(enemyIndex) - 1;
            shootEnemyDroid(myTeam, enemyTeam, myDroidTurn, enemyDroidIndex);

        } catch (IOException e) {
            e.printStackTrace();
        }

        turnNumber++;
    }

    private void turn(int turn, Team Team) {

        if (turn < Team.getDroidList().size() - 1) {
            myDroidTurn++;
        }
        else if(turn >= Team.getDroidList().size() - 1) {
            myDroidTurn = 0;
        }
    }
    private void turnEnemy(int turn, Team Team) {

        if (turn < Team.getDroidList().size() - 1) {
            enemyDroidTurn++;
        }
        else if(turn >= Team.getDroidList().size() - 1) {
            enemyDroidTurn = 0;
        }
    }

    private static void shootEnemyDroid(Team myTeam, Team enemyTeam, int myDroidIndex, int enemyDroidIndex) {
        myTeam.getDroidList().get(myDroidIndex).shoot(enemyTeam.getDroidList().get(enemyDroidIndex));

        // remove droid if it has 0 HP
        if (enemyTeam.getDroidList().get(enemyDroidIndex).getHealth() <= 0) {
            enemyTeam.getDroidList().remove(enemyDroidIndex);
        }
    }


}
