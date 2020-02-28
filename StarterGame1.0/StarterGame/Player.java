import java.util.Stack;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Random;
/**
 * This class represents players in the game. Each player has 
 * a current location.
 * 
 * @author Michael Kolling modified by Rodrigo A. Obando (2018)
 * @version 1.0 (December 2002)
 */
public class Player
{
    private Room currentRoom;
    Stack<Room> previousRooms = new Stack<Room>();
    private HashMap<String, Items> inventory;
    public ArrayList visitedRoomList = new ArrayList();

    //Equip and Unequip
    private HashMap<String, Items> equip;

    //Browse NPC Inventory
    private HashMap<String, NPC> npc;

    //Attack Enemy
    private HashMap<String, Enemy> enemy;

    //Player stats
    private int maxCarryWeight;
    private int maxCarryVolume;
    private int currentWeight;
    private int currentVolume;
    private int maxMP;
    private int currentMP;
    private int maxHealth;
    private int currentHealth;
    private int defense;
    private int attack;
    private int speed;

    /**
     * Constructor for objects of class Player
     */
    public Player(Room startingRoom)
    {
        currentRoom = startingRoom;
        inventory = new HashMap<String, Items>();
        //This works with the equip and unequip methods
        equip = new HashMap<String, Items>();

        //Browse
        npc = new HashMap<String, NPC>();

        //Attack
        enemy = new HashMap<String, Enemy>();

        //Player Stats
        this.maxCarryWeight = 10; //maxCarryWeight;
        this.currentWeight = 0; //currentWeight;
        this.maxCarryVolume = 10; //maxCarryVolume;
        this.currentVolume = 0; //currentVolume;
        this.maxHealth = 10; //maxHealth;
        this.currentHealth = maxHealth;
        this.maxMP = 10; //maxMP;
        this.currentMP = maxMP;
        this.attack = 0;
        this.defense = 0;
        this.speed = 10;
    }

    /**
     * Return the current room for this player.
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    /**
     * Set the current room for this player.
     */
    public void setCurrentRoom(Room room)
    {
        currentRoom = room;
    }

    /******************************************************************************************************/
    //Setters and Getters for Player Stats

    //Max Carry Weight
    public int getMaxCarryWeight() {
        return maxCarryWeight;
    }

    public void setMaxCarryWeight(int maxWeight) {
        this.maxCarryWeight = maxWeight;
    }

    //Current Weight
    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int weight) {
        this.currentWeight = weight;
    }

    //Max Volume
    public int getMaxCarryVolume() {
        return maxCarryVolume;
    }

    public void setMaxCarryVolume(int maxVolume) {
        this.maxCarryVolume = maxVolume;
    }

    //Current Volume
    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int volume) {
        this.currentVolume = volume;
    }

    //Max Health
    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int health) {
        this.maxHealth = health;
    }

    //Current Health
    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int playerHealth) {
        this.currentHealth = playerHealth;
    }

    //Max MP
    public int getMaxMP() {
        return maxMP;
    }

    public void setMaxMP(int magicPoints) {
        this.maxMP = magicPoints;
    }

    //Current MP
    public int getCurrentMP() {
        return currentMP;
    }

    public void setCurrentMP(int mp) {
        this.currentMP = mp;
    }

    //Player Attack Stat
    public int getAttack() {
        return attack;
    }

    public void setAttack(int att) {
        this.attack = att;
    }

    //Player's Defense Stat
    public int getDefense() {
        return defense;
    }

    public void setDefense(int def) {
        this.defense = def;
    }

    //Speed Stat
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int sd) {
        this.speed = sd;
    }
    /******************************************************************************************************/

    /**
     * Try to walk in a given direction. If there is a door
     * this will change the player's location.
     */
    public void walk(String direction)
    {
        setPreviousRoom();
        addToVisitedRoomList();
        // Try to leave current room.
        Door door = currentRoom.getExit(direction);

        if (door == null)
            System.out.println("There is no door on " + direction);
        else {
            if(npc.isEmpty() == false){
                System.out.println("You cannot leave yet. If you were browsing an NPC's Inventory then finish browsing.");
            }
            else {
                if(door.isOpen()) {

                    Room nextRoom = door.getRoomFromTheOtherSideOf(getCurrentRoom());
                    setCurrentRoom(nextRoom);

                    NotificationCenter.getInstance().postNotification(new Notification("PlayerEnteredRoom", this));

                    System.out.println(nextRoom.getLongDescription());
                }
                else{ 
                    System.out.println("The door on " + direction + " is closed.");
                }
            }
        }
    }

    public void setPreviousRoom()
    {
        previousRooms.push(getCurrentRoom());
    }

    public Room getPreviousRoom()
    {
        return previousRooms.pop();
    }

    //This allows the player to open closed doors
    public void open(String direction) {
        Door door = currentRoom.getExit(direction);

        if (door == null)
            System.out.println("There is no door on " + direction);
        else {
            ActionResult result = door.open();

            switch(result) {
                case UNCHANGED_DONE:
                System.out.println("The door on " + direction + " was already open.");
                break;
                case CHANGED_DONE:
                System.out.println("The door on " + direction + " is now open.");
                break;
                case UNCHANGED_NOT_DONE:
                System.out.println("The door on " + direction + " is still closed.");
                break;
            }
        }
    }

    public void unlock(String direction) {
        Door door = currentRoom.getExit(direction);

        if (door == null)
            System.out.println("There is no door on " + direction);
        else {
            LockDelegate theLock = door.getDelegate();

            if(theLock != null) {
                ActionResult result = theLock.unlock();
                switch(result) {
                    case UNCHANGED_DONE:
                    System.out.println("The door on " + direction + " does not have a lock.");
                    break;
                    case CHANGED_DONE:
                    System.out.println("The door on " + direction + " is now unlocked.");
                    break;
                    case UNCHANGED_NOT_DONE:
                    System.out.println("The door on " + direction + " is still locked.");
                    break;
                }
            }
        }
    }

    public void torch() {
        getCurrentRoom().setDelegate(null);
        System.out.println(getCurrentRoom().getLongDescription());
    }

    //This method allows the player to see what is in the room
    public void search(Room room) {
        room = getCurrentRoom();
        System.out.println("The item(s) " + room.getShortDescription() + " are: " + room.printItemsInRoom());
        System.out.println("The people " + room.getShortDescription() + " are: " + room.printNPCInRoom());
        System.out.println("The monster(s) " + room.getShortDescription() + " are: " + room.printEnemiesInRoom());
    }

    //This adds items to player's inventory
    public void aquire(Items item) {
        if(item != null) {
            inventory.put(item.getItemName(), item);
        }
    }

    //This removes items from the player's inventory
    public Items release(String itemName) {
        return inventory.remove(itemName);
    }

    //This allows the player to 'pick up' items in a room and add them to his/her inventory
    public void pickUp(String itemName) {
        Items item = getCurrentRoom().pickUp(itemName);
        if(item == null) {
            System.out.println(itemName + " does not exist.");
            return;
        }
        if(inventory.containsKey(item.getItemName())) {
            getCurrentRoom().drop(item);
            System.out.println("Come back after you have used that " + itemName + " that is currently in the inventory.");
        }
        else {
            if(maxCarryWeight >= (item.getItemWeight() + getCurrentWeight())) {
                if(maxCarryVolume >= (item.getItemVolume() + getCurrentVolume())) {
                    aquire(item);
                    System.out.println("You picked up " + itemName);
                    //Calculating Weights and Volumes
                    currentWeight = currentWeight + item.getItemWeight();
                    currentVolume = currentVolume + item.getItemVolume();
                }
                else {
                    System.out.println(itemName + " is too bulky. Not enough room in inventory.");

                    getCurrentRoom().drop(item);
                }
            }
            else {
                System.out.println(itemName + " is too heavy. Inventory can not hold it.");

                getCurrentRoom().drop(item);
            }
        }
    }

    //This allows the player to drop items from his/her inventory
    public void drop(String itemName) {
        Items item = release(itemName); 
        if(item == null) {
            System.out.println(itemName + " does not exist in inventory.");
            return;
        }
        getCurrentRoom().drop(item);
        System.out.println("You dropped a " + itemName);
        currentWeight = currentWeight - item.getItemWeight();
        currentVolume = currentVolume - item.getItemVolume();
    }

    public void inspectInventoryItems(String itemName) {
        Items item = release(itemName);
        if(item == null) {
            System.out.println(itemName + " does not exist in inventory.");
            return;
        }
        else {
            System.out.println(item.toString());
            aquire(item);
        }
    }

    /**********************************************************************************************************************/

    //Allows player to insert item 'key' into a door
    public void insert(String itemName, String direction) {
        Items item = release(itemName); 
        if(item == null) {
            System.out.println(itemName + " will not unlock door on " + direction + " ....nice try.");
            return;
        }
        Door door = currentRoom.getExit(direction);

        if(door == null) {
            System.out.println("There is no door on " + direction);
            aquire(item);
            return;
        }

        LockDelegate lock = door.getDelegate();
        if(lock == null) {
            System.out.println("There is no lock on " + direction);
            aquire(item);
            return;
        }

        lock.insertKey(item);
    } 

    //If player puts wrong key in the wrong lock, then the player can get the key back
    public void remove(String direction) {
        Door door = currentRoom.getExit(direction);

        if(door == null) {
            System.out.println("There is no door on " + direction);
            return;
        }

        LockDelegate lock = door.getDelegate();
        if(lock == null) {
            System.out.println("There is no lock on " + direction);
            return;
        }

        Items item = lock.removeKey();

        aquire(item);
    } 

    /*************************************************************************************************/
    //This allows the player to check and see what items are in his/her inventory
    public void check() {
        System.out.println("Inventory's Weight Capacity: " + getCurrentWeight() + "/" + getMaxCarryWeight());
        System.out.println("Inventory's Volume: " + getCurrentVolume() + "/" + getMaxCarryVolume());
        System.out.println("Your inventory contains: " + inventory.keySet() + ".");
    }

    //This adds npcs to the player's
    public void aquireNPC(NPC thisNPC) {
        if(thisNPC != null) {
            npc.put(thisNPC.getNPCName(), thisNPC);
        }
    }

    public NPC releaseNPC(String npcName) {
        return npc.remove(npcName);
    }

    public void browse(String npcName) {
        NPC npcs = getCurrentRoom().getNPC(npcName);

        if(npcs != null) {  //checks to see if the npc is in the room with the player
            //If the player is then the player may browse through the npc's invnetory
            aquireNPC(npcs);

            System.out.println(npcName + "'s Inventory: " + npcs.printNPCInventory());

        }

        else {
            System.out.println("Who? " + npcName + " is not here.");
        }
    }

    public void stopBrowsing(String npcName) {
        NPC npcs = releaseNPC(npcName); 
        if(npcs == null) {
            System.out.println(npcName + " who?");
            return;
        }
        getCurrentRoom().letNPCGo(npcs);
        System.out.println(npcName + ": 'Bye!");
    }

    public void aquireEnemy(Enemy thisEnemy) {
        if(thisEnemy != null) {
            enemy.put(thisEnemy.getEnemyName(), thisEnemy);
        }
    }

    public Enemy releaseEnemy(String enemyName) {
        return enemy.remove(enemyName);
    }

    public void attack(String enemyName) {
        Enemy enemies = getCurrentRoom().getEnemy(enemyName);
        
        if(enemies != null) {
            aquireEnemy(enemies);
            System.out.println(enemies.getCurrentEnemyHealth());
            if(enemies.getCurrentEnemyHealth() >= 0) {
                int health = enemies.getCurrentEnemyHealth();
                health = enemies.getCurrentEnemyHealth() - getAttack();
                enemies.setCurrentEnemyHealth(health);
                setCurrentHealth(enemies.returnAttack(this));
                System.out.println(health);
                if(enemies.getCurrentEnemyHealth() >= 0){
                    enemies.setCurrentEnemyHealth(health);
                    releaseEnemy(enemyName);
                    getCurrentRoom().letEnemyGo(enemies);
                }
                else {
                    System.out.println(enemyName + " has died");
                    releaseEnemy(enemyName);
                }
            }
            else {
                //Room room = getCurrentRoom();
                //enemies.dropItems(room);
                releaseEnemy(enemyName);

                System.out.println("The " + enemyName + " is already dead!");
            }
        }
        else {
            System.out.println(enemyName + " is gone.");
        }

    }

    /*******************************************************************************************************/

    //Allows player to equip a weapon in his/her inventory
    public void equipWeapon(String itemName) {
        if(inventory.containsKey(itemName)) {
            Items item = release(itemName);
            if(item.getWeaponDamage() != 0) {
                if(getAttack() == 0) {
                    equip.put(item.getItemName(), item);
                    System.out.println("You equipped " + itemName);

                    //Calculating Attack and defense
                    attack = attack + item.getWeaponDamage();
                    defense = defense + item.getItemDefense();

                }
                else{
                    System.out.println("Nice try!");
                    aquire(item);
                }
            }
            else {
                System.out.println(itemName + " is not a weapon.");
                aquire(item);
            }
        }
        else {
            System.out.println(itemName + " does not exist.");
        }
    }

    //Allows player to equip armor in his/her inventory
    public void equipArmor(String itemName) {
        if(inventory.containsKey(itemName)) {
            Items item = release(itemName);
            if(item.getItemDefense() != 0) {
                if(getDefense() == 0) {
                    equip.put(item.getItemName(), item);
                    System.out.println("You equipped " + itemName);

                    //Calculating Attack and defense
                    attack = attack + item.getWeaponDamage();
                    defense = defense + item.getItemDefense();

                }
                else{
                    System.out.println("Nice try!");
                    aquire(item);
                }
            }
            else {
                System.out.println(itemName + " is not armor.");
                aquire(item);
            }
        }
        else {
            System.out.println(itemName + " does not exist.");
        }

    }

    //This removes items from the player's inventory
    public Items takeOff(String itemName) {
        return equip.remove(itemName);
    }

    //Allows player to unequip items and put them in the inventory
    public void unequip(String itemName) {
        if(equip.containsKey(itemName)) {
            Items item = takeOff(itemName);
            if(maxCarryWeight >= (item.getItemWeight() + getCurrentWeight())) {
                if(maxCarryVolume >= (item.getItemVolume() + getCurrentVolume())) {
                    aquire(item);
                    System.out.println("You equipped " + itemName);

                    //Calculating Attack and defense
                    attack = attack - item.getWeaponDamage();
                    defense = defense - item.getItemDefense();
                }
                else {
                    System.out.println(itemName + " is too bulky. Not enough room in inventory.");

                    getCurrentRoom().drop(item);
                }
            }
            else {
                System.out.println(itemName + " is too heavy. Inventory can not hold it.");

                getCurrentRoom().drop(item);
            }
        }
        else {
            System.out.println(itemName + " does not exist.");
        }
    }

    /*****************************************************************************************************************/

    public void checkStats() {
        System.out.println("Health: " + getCurrentHealth() + "/" + getMaxHealth());
        System.out.println("Magic Points: " + getCurrentMP() + "/" + getMaxMP());
        System.out.println("Attack: " + getAttack());
        System.out.println("Defense: " + getDefense());
    }

    public void checkEquipment() {
        System.out.println("You have " + equip.keySet() + " equipped.");
    }

    /******************************************************************************************************/
    public boolean escape(Room room)
    {
        room = getCurrentRoom();
        String roomString = room.getShortDescription();
        String guestString = "in the vacant guest room";
        if(roomString == guestString)
        {
            System.out.println("You have escaped the dungeon and won the game!");
            return true;
        }
        else
        {
            System.out.println("You can not escape from here");
            return false;
        }
    }

    public void addToVisitedRoomList()
    {
        visitedRoomList.add(getCurrentRoom());
    }

    public Room getRandomVisitedRoom()
    {
        Random rand = new Random();
        return (Room)visitedRoomList.get(rand.nextInt(visitedRoomList.size()));
    }

    public void teleport(Room room)
    {
        room = getCurrentRoom();
        String roomString = room.getShortDescription();
        String guestString = "in the eerie tomb";
        if(roomString == guestString)
        {
            System.out.println("You were teleported somewhere!");
            setCurrentRoom(getRandomVisitedRoom());
        }
        else
        {
            System.out.println("You can not teleport in here");
        }
    }
}
