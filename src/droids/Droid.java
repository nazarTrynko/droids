package droids;

/**
 * Created by Nazar on 21.02.2015.
 */
public abstract class Droid implements Shoot{

    int damageLevel;       // decrease energyLevel of enemy by its value;
                                  // decrease health by its value
    int damageRate;
    int health;
    int energyLevel; // every 10 point decrease damage received by 1


    public int getDamageRate() {
        return damageRate;
    }

    public void setDamageRate(int damageRate) {
        this.damageRate = damageRate;
    }

    public int getDamageLevel() {
        return damageLevel;
    }

    public void setDamageLevel(int damageLevel) {
        this.damageLevel = damageLevel;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    // Shoot
    @Override
    public void shoot(Droid droid){
        int healthBeforeHitted = droid.getHealth();
        droid.setHealth(droid.getHealth() -
                        (getDamageLevel() - droid.getEnergyLevel() / 10));
        System.out.println("Damage done: " + (healthBeforeHitted - droid.getHealth()) + "\n");
        droid.setEnergyLevel(droid.getEnergyLevel() - getDamageLevel());
        if (droid.getEnergyLevel() == 0) return;
        if (droid.getEnergyLevel() < 0) {
            droid.setEnergyLevel(0);
            return;
        }



    }

}
