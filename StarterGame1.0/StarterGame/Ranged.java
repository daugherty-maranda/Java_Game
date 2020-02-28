
/**
 * This is a sub class of the Weapon class and as such, has attack values, but it requires Ammo in order
 * to fire. Once there is no more Ammo, the player can't attack with this weapon.
 *
 * @author (Phillip Quinn and Maranda Daugherty)
 * @version (a version number or a date)
 */
public class Ranged extends Weapons
{
    public Ammo arrowAmount;
    
    /**
     * Constructor for objects of class Ranged
     */
    public Ranged(String itemName, int itemWeight, int itemVolume, int sellValue, int buyValue, int itemHealth, boolean broken, int weaponDamage, int itemDefense, Ammo arrowAmount)
    {
       super(itemName, itemWeight, itemVolume, sellValue, buyValue, itemHealth, broken, weaponDamage, 0);
       
       this.arrowAmount = arrowAmount;  //This is how many arrows are left
    }
}
