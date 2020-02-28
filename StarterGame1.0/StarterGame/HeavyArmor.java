
/**
 * This is a sub class of the Armor class because this armor has high defence, but also a higher weight value.
 * It is also only necessary for melee attackers.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HeavyArmor extends Armor
{
    public int armorSpeed;

    /**
     * Constructor for objects of class HeavyArmor
     */
    public HeavyArmor(String itemName, int itemWeight, int itemVolume, int sellValue, int buyValue, int itemHealth, boolean broken, int weaponDamage, int itemDefense, int armorSpeed)
    {
        super(itemName, itemWeight, itemVolume, sellValue, buyValue, itemHealth, broken, 0, itemDefense);

        this.armorSpeed = armorSpeed;
    }
    
    public int getArmourSpeed() {
        return armorSpeed;
    }
}
