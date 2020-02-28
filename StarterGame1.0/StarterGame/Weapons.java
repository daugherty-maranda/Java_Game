
/**
 * This deals with items that inflict damage upon a target
 *
 * @author (Phillip Quinn and Maranda Daugherty)
 * @version (3/25/2019)
 */
public class Weapons extends Items
{
    /**
     * Constructor for objects of class Weapons
     */
    public Weapons(String itemName, int itemWeight, int itemVolume, int sellValue, int buyValue, int itemHealth, boolean broken, int weaponDamage, int itemDefense)
    {
        super(itemName, itemWeight, itemVolume, sellValue, buyValue, itemHealth, broken, weaponDamage, 0);
    }
}
