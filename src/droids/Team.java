package droids;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nazar on 21.02.2015.
 */
public class Team{

    private List<Droid> droidList = new ArrayList<>();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Team() {
        fillTeam();
    }



    public List<Droid> getDroidList() {
        return droidList;
    }

    private void fillTeam() {

        for (int i = 0; i < 5; i++) {
            System.out.println("Choose droid №" + (i + 1));
            try {
                droidList.add(chooseDroid());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Droid chooseDroid() throws IOException {
        System.out.println("1. Droideka\n2. Battle droid");
        Droid droid = null;
        String enter = reader.readLine();

        while (!enter.equals("1") && !enter.equals("2")) {
            System.out.println("Invalid request");
            enter = reader.readLine();
        }
        if (enter.equals("1")) droid = new Droideka();
        if (enter.equals("2")) droid = new BattleDroid();

        return droid;
    }

    public void showInfo() {
        for (int i = 1; i <= getDroidList().size(); i++)
            System.out.println(i + ". " + getDroidList().get(i - 1));

    }
}
