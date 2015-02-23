package droids;

/**
 * Created by Nazar on 21.02.2015.
 */
public class Droideka extends Droid implements Shoot{

    public Droideka() {

        setDamageLevel(40);
        setEnergyLevel(100);
        setHealth(100);
        setDamageRate(getEnergyLevel() / 10);
    }
    @Override
    public void shoot(Droid droid) {

        int healthBeforeHitted = droid.getHealth();
        droid.setHealth(droid.getHealth() -
                (getDamageLevel() + getDamageRate() - droid.getEnergyLevel() / 10));
        System.out.println("Damage done: " + (healthBeforeHitted - droid.getHealth()) + "\n");

        droid.setEnergyLevel(droid.getEnergyLevel() - getDamageLevel() - getDamageRate());
        droid.setDamageRate(droid.getEnergyLevel() / 10);
        if (droid.getEnergyLevel() == 0) return;
        if (droid.getEnergyLevel() < 0) {
            droid.setEnergyLevel(0);
            droid.setDamageRate(0);
            return;
        }
    }
    @Override
    public String toString() {
        return "Droideka " + "(HP: " + getHealth() + " ES: " + getEnergyLevel() + " Dmg: " + getDamageLevel() + " Dmg rate: " + getDamageRate() +")";
    }
}
