
/**
 * Magic is a sub class of Weapons, but this requires MP(Magic Potions) inorder to use. Once the player runs out
 * of MP, the player can no longer cast spells until MP is restored.
 *
 * @author (Phillip Quinn and Maranda Daugherty)
 * @version (3/25/2019)
 */
public class Magic extends Weapons
{
    public int mpCost;
    
    /**
     * Constructor for objects of class Magic
     */
    public Magic(String itemName, int itemWeight, int itemVolume, int sellValue, int buyValue, int itemHealth, boolean broken, int weaponDamage, int itemDefense, int mpCost)
    {
        super(itemName, itemWeight, itemVolume, sellValue, buyValue, itemHealth, broken, weaponDamage, itemDefense);
        
        this.mpCost = mpCost;
    }
}
