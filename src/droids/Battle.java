package droids;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by Nazar on 21.02.2015.
 */
public class Battle {
    int myDroidTurn;
    int enemyDroidTurn;
    int myDroidIndex;
    int turnNumber = 1;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public Battle(Team myTeam, Team enemyTeam) {
        while (!myTeam.getDroidList().isEmpty() && !enemyTeam.getDroidList().isEmpty()) {
            System.out.println("Turn number " + turnNumber++);
            myTurn(myTeam, enemyTeam);

            enemyTeam.showInfo();

            //enemyTurn(myTeam, enemyTeam);
            //showInfo(enemyTeam);
        }
    }


    private void enemyTurn(Team myTeam, Team enemyTeam) { // not done yet

        Random random = new Random();
        if (myDroidIndex == 0) myDroidIndex = random.nextInt(5);  // choose random index of droid to fight
        else

            shootEnemyDroid(enemyTeam, myTeam, enemyDroidTurn, myDroidIndex);
        turn(enemyDroidTurn, enemyTeam);
        System.out.println(turnNumber++);
    }

    private void myTurn(Team myTeam, Team enemyTeam) {

        String enemyIndex;
        int enemyDroidIndex;

        if (turnNumber <= 2) {
            enemyTeam.showInfo();
        }
        /*try {
            System.out.println(myTeam.getDroidList().get(myDroidTurn) + " turn");
            System.out.print("Choose your enemy!\n");
            enemyTeam.showInfo();
            enemyIndex = reader.readLine();

            while (enemyIndex.isEmpty() ||Integer.parseInt(enemyIndex) > enemyTeam.getDroidList().size() ||Integer.parseInt(enemyIndex) <= 0) {
                if (enemyIndex.isEmpty()) {
                    System.out.println("You haven't enter anything!");

                }

                else if (Integer.parseInt(enemyIndex) <= 0) {
                    System.out.println("Please, choose existing enemy: 1-" + enemyTeam.getDroidList().size());
                }
                else {
                    System.out.println("Enemy team is smaller than " + enemyIndex + " units!");
                    System.out.println("Please, choose existing enemy: 1-" + enemyTeam.getDroidList().size());
                }
                enemyIndex = reader.readLine();
            }

            enemyDroidIndex = Integer.parseInt(enemyIndex) - 1;
            shootEnemyDroid(myTeam, enemyTeam, myDroidTurn, enemyDroidIndex);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Please, choose existing enemy: 1-" + enemyTeam.getDroidList().size());
            return;
        }
        System.out.println(turnNumber++);
        turn(myDroidTurn, myTeam);*/
        System.out.println(myTeam.getDroidList().get(myDroidTurn) + " turn");
        System.out.print("Choose your enemy!\n");

        try {

            enemyIndex = reader.readLine();


            enemyDroidIndex = Integer.parseInt(enemyIndex) - 1;
            shootEnemyDroid(myTeam, enemyTeam, myDroidTurn, enemyDroidIndex);
        } catch (IndexOutOfBoundsException e) {

            System.out.println("Please, choose existing enemy: 1-" + enemyTeam.getDroidList().size());

        } catch (IOException e) {
            e.printStackTrace();
        }


        turn(myDroidTurn, myTeam);

    }

    private void turn(int turn, Team Team) {

        if (turn < Team.getDroidList().size() - 1) {
            myDroidTurn++;
        }
        else if(turn >= Team.getDroidList().size() - 1) {
            myDroidTurn = 0;
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
