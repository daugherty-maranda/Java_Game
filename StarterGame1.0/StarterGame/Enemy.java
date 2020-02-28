import java.util.Set;
import java.util.HashMap;

/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy
{
    private String enemyName; //Name of Enemy
    private int enemyHealth;  //Health the Enemy has
    private int currentEnemyHealth;
    private int enemyAttack;  //Base Attack
    private Room currentRoom; //This is the room the Enemy is 'currently' in
    private Room startingRoom; //This is the room the Enemy starts in
    private HashMap<String, Items> enemiesInventory;
    
    int tempEnemyHP = getEnemyHealth();

    /**
     * Constructor for objects of class Enemy
     */
    public Enemy(String enemyName, int enemyHealth, int enemyAttack, Room startingRoom)
    {
        this.enemyName = enemyName;
        this.enemyHealth = enemyHealth;
        this.currentEnemyHealth = enemyHealth;
        this.enemyAttack = enemyAttack;
        this.currentRoom = startingRoom;

        enemiesInventory = new HashMap<String, Items>();
    }

    //Get methods
    /**
     * Return the current room for this NPC.
     */

    public Room getEnemyCurrentRoom()
    {
        //System.out.println("This is currentroom: " + currentRoom);
        return currentRoom;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public int getCurrentEnemyHealth() {
        return currentEnemyHealth;
    }

    public int getEnemyAttack() {
        return enemyAttack;
    }

    public Room getEnemyStartingRoom() {
        //System.out.println("This is startingroom: " + startingRoom.getShortDescription());
        return startingRoom;
    }

    //Set Methods
    /**
     * Set the current room for this Enemy.
     */
    public void setEnemyCurrentRoom(Room room)
    {
        currentRoom = room;
    }

    public void setEnemyName(String name) {
        this.enemyName = name;
    }

    public void setEnemyHealth (int health) {
        this.enemyHealth = health;
    }

    public void setCurrentEnemyHealth(int currentHealth) {
        this.currentEnemyHealth = currentHealth;
    }

    public void setEnemyAttack(int attack) {
        this.enemyAttack = attack;
    }

    public void setEnemyStartingRoom(Room currentRoom) {
        this.startingRoom = currentRoom;
    }

    public String toString() {
        return getEnemyName() + ", health: " + getEnemyHealth() + ", attack: " + ""; 
    }

    //Enemy's Inventory
    //Add items to Enemy's Inventory
    public void addItem(Items items) {
        if(items != null) {
            enemiesInventory.put(items.getItemName(), items);
        }
    }

    //Remove items from Enemy's Inventory
    public Items removeItem(String itemName) {
        return enemiesInventory.remove(itemName);
    }
    
    /*
    public Items dropItems(Room room) {
        //Items items = enemiesInventory.keySet();
        room = getEnemyCurrentRoom();
        //enemyInventory.removeItems(items.getItemName());
    }*/

    public void attackPlayer(int health) {
        if(getCurrentEnemyHealth() < getEnemyHealth()) {
            health = health - getEnemyAttack();
        }
    }
    
    public int returnAttack(Player player) {
        int newPlayerHP = player.getCurrentHealth();
        if(tempEnemyHP != getCurrentEnemyHealth()) {
            newPlayerHP -= getEnemyAttack();
            tempEnemyHP = getCurrentEnemyHealth();
        }
        return newPlayerHP;
    }

    //Prints Enemy Inventory
    public String printEnemyInventory() {
        return "" + enemiesInventory.keySet() + ""; //inventory.printNPCInventory() + "";
    }
}
