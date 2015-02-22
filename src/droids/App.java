package droids;

/**
 * Created by Nazar on 22.02.2015.
 */
public class App {

    public static void main(String[] args) {

        System.out.println("Choose your droids!\n");

        Team team1 = new Team();
        System.out.println("Nice job! Here is your team list:");
        team1.showInfo();

        System.out.println("\nChoose enemy droids!\n");
        Team team2 = new Team();

        Battle battle = new Battle(team1, team2);

    }
}
