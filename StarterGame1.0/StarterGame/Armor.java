
/**
 * Armour is an item that increases the player's defence, but it does not possess and attack value.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Armor extends Items
{
    private int itemDefense;
    
    /**
     * Constructor for objects of class Armor
     */
    public Armor(String itemName, int itemWeight, int itemVolume, int sellValue, int buyValue, int itemHealth, boolean broken, int weaponDamage, int itemDefense)
    {
        super(itemName, itemWeight, itemVolume, sellValue, buyValue, itemHealth, broken, 0, itemDefense);
        
        this.itemDefense = itemDefense;
    }
    
    public int getArmorDefense() {
        return itemDefense;
    }
}
