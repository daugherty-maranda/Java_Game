
/**
 * This is a sub class of the Armor class and provides less defence, but is lighter. This is meant
 * for the Ranged weapons and Magic castors. (Does not affect players speed)
 *
 * @author (Phillip Quinn and Maranda Daugherty)
 * @version (3/25/2019)
 */
public class LightArmor extends Armor
{
    public int armorSpeed;
    
    /**
     * Constructor for objects of class LightArmor
     */
    public LightArmor(String itemName, int itemWeight, int itemVolume, int sellValue, int buyValue, int itemHealth, boolean broken, int weaponDamage, int itemDefense, int armorSpeed)
    {
       super(itemName, itemWeight, itemVolume, sellValue, buyValue, itemHealth, broken, 0, itemDefense);
       
       this.armorSpeed = armorSpeed;
    }
    
    public int getArmourSpeed() {
        return armorSpeed;
    }
}
