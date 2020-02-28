import java.util.Set;
import java.util.HashMap;

/**
 * This allows an item to be created as long as it is given a name, weight, volume, price, health, attack, and whether or not it is broken.
 *

 * @author (Phillip Quinn, Maranda Daugherty)
 * @version (3/21/2019)

 */
public class Items
{
    public int itemWeight;  //How heavy an item is
    public int itemVolume;  //How much 'physical' space an item takes - how big
    public int sellValue;  //how much the item sells for
    public int buyValue;   //how much you can buy an item for
    public int itemHealth; //This tracks how long until it is 'broken'
    public boolean broken;  //This determined by the weapons health
    public int weaponDamage;  //The attack value - Ex.) + 5 attack
    public String itemName;  //Sword, axe, spear, and etc.
    private int itemDefense; //The defense value - Ex.) + 5 defense
    public HashMap<String, Room> item;
    

    /**
     * Constructor for objects of class Items

     */
    public Items(String itemName, int itemWeight, int itemVolume, int sellValue, int buyValue, int itemHealth, boolean broken, int weaponDamage, int itemDefense) {
        //This allow an item to be created
        this.itemName = itemName;
        this.itemWeight = itemWeight;
        this.itemVolume = itemVolume;
        this.sellValue = sellValue;
        this.buyValue = buyValue;
        this.itemHealth = itemHealth;
        this.weaponDamage = weaponDamage;
        this.itemDefense = itemDefense;
        //this.itemQuantity = itemQuantity;
        item = new HashMap<String, Room>();
        
        //This determines if an item is broken by checking its health
        if (itemHealth <= 0) {
            //If the item's health is 0 or below, then the item is a 'broken item'
            broken = true;
        }
        else {
            //else it is still an item
            broken = false;
        }
    }

    public String getItemName() { //Tells whether it is an 'axe', 'spear', 'sword', or 'spellbook'
        return itemName;
    }
    
    public void setItemName(String name) {
        this.itemName = name;
    }

    public int getItemWeight() {  //Gets how heavy an item is
        return itemWeight;
    }
    
    public void setItemWeight(int weight) {
        this.itemWeight = weight;
    }

    public int getItemVolume() { //Gets the items 'size' - space it takes up
        return itemVolume;
    }
    
    public void setItemVolume(int volume) {
        this.itemVolume = volume;
    }

    public int getSellValue() { //Gets its price
        return sellValue;
    }
    
    public void setSellValue(int sell) {
        this.sellValue = sell;
    }
    
    public int getBuyValue() {
        return buyValue;
    }
    
    public void setBuyValue(int buy) {
        this.buyValue = buy;
    }
    
    public int getItemHealth() { //This gets its health
        return itemHealth;
    }
    
    public void setItemHealth(int health) {
        this.itemHealth = health;
    }
    
    public int getWeaponDamage() { //This get the attack value of the item
        return weaponDamage;
    }
    
    public void setWeaponDamage(int damage) {
        this.weaponDamage = damage;
    }
    
    public int getItemDefense() {
        return itemDefense;
    }
    
    public void setItemDefense(int defense) {
        this.itemDefense = defense;
    }

    public boolean getBroken() { //This gets whether or not he item is broken
        if (itemHealth <= 0)
        {
            return true;
        }

        else
        {
            return false;
        }
    }
    
    public String toString() {
        return getItemName() + ", weight: " + getItemWeight() + ", volume: " + getItemVolume() + ", health: " + getItemHealth();
    }
}