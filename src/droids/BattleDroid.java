package droids;

/**
 * Created by Nazar on 21.02.2015.
 */
public class BattleDroid  extends Droid{
    @Override
    public String toString() {
        return "BattleDroid " + "(HP: " + getHealth() + " ES: " + getEnergyLevel() + " Dmg: " + getDamageLevel()+")";
    }

    public BattleDroid() {
        setDamageLevel(15);
        setEnergyLevel(50);
        setHealth(200);

    }
}
