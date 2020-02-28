
/**
 * Ammo is an item that the player can used in ranged weapon as a means of attack, as such, this item 
 * exists in the player's inventory as mulitple.
 *
 * @author (Phillip Quinn and Maranda Daugherty)
 * @version (3/25/2019)
 */
public class Ammo extends Items
{
    public int numberOfArrows = 0;

    /**
     * Constructor for objects of class Ammo
     */
    public Ammo(String itemName, int itemWeight, int itemVolume, int sellValue, int buyValue, int itemHealth, boolean broken, int weaponDamage, int itemDefense, int numberOfArrows)
    {
        super(itemName, 0, 0, sellValue, buyValue, 1, broken, weaponDamage, 0);
        
        this.numberOfArrows = numberOfArrows;
    }
}
