
/**
 * This is a sub class of Weapons and as such it has an attack, weight, volume value, but the weapon has
 * a limited range.
 *
 * @author (Phillip Quinn and Maranda Daugherty)
 * @version (3/25/2019)
 */
public class Melee extends Weapons
{
    private int weaponRange;

    /**
     * Constructor for objects of class Melee
     */
    public Melee(String itemName, int itemWeight, int itemVolume, int sellValue, int buyValue, int itemHealth, boolean broken, int weaponDamage, int itemDefense, int weaponRange)
    {
        super(itemName, itemWeight, itemVolume, sellValue, buyValue, itemHealth, broken, weaponDamage, 0);

        this.weaponRange = weaponRange; //This is how close player has to be to hit an enemy
    }
    
    public int getWeaponRange() {
        return weaponRange;
    }
}
