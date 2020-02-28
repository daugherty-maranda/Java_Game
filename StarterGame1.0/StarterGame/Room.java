import java.util.Set;
import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is the main class of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kolling and David J. Barnes modified by Rodrigo A. Obando (2018)
 * @version 1.0 (February 2002)
 */

class Room 
{
    private String description;
    private HashMap<String, Door> exits; // stores exits of this room.
    private RoomDelegate delegate;

    //NPCs and Items
    private HashMap<String, NPC> npcs;
    private HashMap<String, Items> items;
    private HashMap<String, Enemy> enemies;

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "in a kitchen" or "in an open court 
     * yard".
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Door>();

        //NPC and Items
        items = new HashMap<String, Items>();
        npcs = new HashMap<String, NPC>();
        
        enemies = new HashMap<String, Enemy>();
    }

    public void setDelegate(RoomDelegate delegate) {
        this.delegate = delegate;
        if(this.delegate != null) {
            delegate.setExits(exits);
            this.delegate.setRoom(this); //It set the room to this! room
        }
    }

    /**
     * Define an exit from this room.
     */
    public void setExit(String direction, Door door) 
    {
        if(delegate != null) {
            delegate.setExit(direction, door);
            return;
        }
        exits.put(direction, door);
    }

    /**
     * Return the description of the room (the one that was defined in the
     * constructor).
     */
    public String getShortDescription()
    {
        if(delegate != null) {
            return delegate.getShortDescription();
        }
        return description;
    }

    /**
     * Return a long description of this room, in the form:
     *     You are in the kitchen.
     *     Exits: north west
     */
    public String getLongDescription()
    {
        if(delegate != null) {
            return delegate.getLongDescription();
        }
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     */
    private String getExitString()
    {
        if(delegate != null) {
            return delegate.getExitString();
        }

        String returnString = "Exits:";
        for(String exitName : exits.keySet())
        {
            returnString += " " + exitName;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     */
    public Door getExit(String direction) 
    {
        if(delegate != null) {
            return delegate.getExit(direction);
        }
        return exits.get(direction);
    }

    /******************************************************************************************/
    
    //Put method for Items and NPC - this is so that there are items and npcs in rooms
    public void putItemInRoom(String itemName, Items item) {//Items item, Room room) {
        items.put(item.getItemName(), item);
        System.out.println("There is a " + item.getItemName() + " ");
    }

    public void removeItemFromRoom(Items item) {
        if(item.getItemName() != null) {
            items.remove(item.getItemName(), item);
        }
        else {
            System.out.println("Item does not exist!");
        }
    }

    /******************************************************************************************/
    
    public void putNPCInRoom(String npcName, NPC npc){
        Room room = npc.getNPCCurrentRoom();
        npcs.put(npc.getNPCName(), npc);
        System.out.println(npc.getNPCName() + " is " + room.getShortDescription());
    }

    public void removeNPCFromRoom(NPC npc) {//, Room room) {
        if(npc.getNPCName() != null) {
            npcs.remove(npc.getNPCName(), npc);
        }
        else {
            System.out.println("NPC does not exist!");
        }
    }
    
    /*********************************************************************************************/
    
    public void putEnemyInRoom(String enemyName, Enemy enemy){
        Room room = enemy.getEnemyCurrentRoom();
        enemies.put(enemy.getEnemyName(), enemy);
        System.out.println(enemy.getEnemyName() + " is " + room.getShortDescription());
    }

    public void removeEnemyFromRoom(Enemy enemy) {//, Room room) {
        if(enemy.getEnemyName() != null) {
            enemies.remove(enemy.getEnemyName(), enemy);
        }
        else {
            System.out.println("Enemy does not exist!");
        }
    }
    
    public Enemy getEnemy(String enemyName) {
        return enemies.remove(enemyName);
    }
    
    public void letEnemyGo(Enemy enemy) {
        if(enemy != null) {
            enemies.put(enemy.getEnemyName(), enemy);
        }
    }
    /*********************************************************************************************/
    
    public String printNPCInRoom() {
         if(delegate != null) {
            return delegate.printNPCInRoom();
        }
        return "" + npcs.keySet().toString() + "";
    }

    public String printItemsInRoom() {
         if(delegate != null) {
            return delegate.printItemsInRoom();
        }
        return "" + items.keySet().toString() + "";
    }
    
    public String printEnemiesInRoom() {
         if(delegate != null) {
            return delegate.printEnemiesInRoom();
        }
        return "" + enemies.keySet().toString() + "";
    }
    
    /*********************************************************************************************/
    
    public void drop(Items item) {
        if(item != null) {
            items.put(item.getItemName(), item);
        }
    }
    
    public Items pickUp(String itemName) {
        return items.remove(itemName);
    }
    
    /**********************************************************************************************/
    
    public NPC getNPC(String npcName) {
        return npcs.remove(npcName);
    }
    
    public void letNPCGo(NPC npc) {
        if(npc != null) {
            npcs.put(npc.getNPCName(), npc);
        }
    }
    
    public String printNPCInventory(NPC npc) {
        return "" + npc.printNPCInventory() + "";
    }
}

