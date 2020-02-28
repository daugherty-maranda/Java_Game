
/**
 * Coins are a stackable item in the player's inventory, but they do not take up any space and weigh nothing.
 *
 * @author (Phillip Quinn and Maranda Daugherty)
 * @version (3/25/2019)
 */
public class Coins extends Items
{
    public int numberOfCoins = 0;

    /**
     * Constructor for objects of class Coins
     */
    public Coins(String itemName, int itemWeight, int itemVolume, int sellValue, int buyValue, int itemHealth, boolean broken, int weaponDamage, int itemDefense, int numberOfCoins)
    {
        super("coin", 0, 0, 1, 0, 1, false, 0, 0);
        
        this.numberOfCoins = numberOfCoins;
    }
}
