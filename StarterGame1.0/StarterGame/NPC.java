import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class creates and dictates the NPCs' movements withing the game.
 *
 * @author (Phillip Quinn and Maranda Daugherty)
 * @version (4/9/2019)
 */
public class NPC
{
    //public HashMap<String, Room> npc; //This is with the putNPCInRoom()
    private String NPCname; //Name of NPC
    private int npcHealth;  //Health the NPC has
    private Room currentRoom; //This is the room the NPC is 'currently' in
    private Room startingRoom; //This is the room the NPC starts in
    private HashMap<String, Items> NPCsInventory;

    /**
     * Constructor for objects of class NPC
     */
    public NPC(String NPCname, int npcHealth, Room startingRoom ) //name, int health, Room startingRoom)
    {
        this.NPCname = NPCname; //name;
        this.npcHealth = npcHealth; //health;
        
        currentRoom = startingRoom;
        //Part of the browse command
        NPCsInventory = new HashMap<String, Items>();
    }
    
    //Get methods
    
    /**
     * Return the current room for this NPC.
     */
    
    public Room getNPCCurrentRoom()
    {
        //System.out.println("This is currentroom: " + currentRoom);
        return currentRoom;
    }
    
    public String getNPCName() {
        return NPCname;
    }
    
    public int getNPCHealth() {
        return npcHealth;
    }
    
    
    public Room getNPCStartingRoom() {
        //System.out.println("This is startingroom: " + startingRoom.getShortDescription());
        return startingRoom;
    }
    
    //Set Methods
    /**
     * Set the current room for this NPC.
     */
    public void setNPCCurrentRoom(Room room)
    {
        currentRoom = room;
    }
    
    public void setNPCName(String name) {
        this.NPCname = name;
    }
    
    public void setNPCHealth (int health) {
        this.npcHealth = health;
    }
    
    
    public void setNPCStartingRoom(Room currentRoom) {
        this.startingRoom = currentRoom;
    }
    
    public String toString() {
        return getNPCName() + ", health: " + getNPCHealth() + ", current room: " + getNPCCurrentRoom().getShortDescription(); 
    }
    
    
    //NPC's Inventory
    
    //Add items to NPC Inventory
    public void addItem(Items items) {
        if(items != null) {
            NPCsInventory.put(items.getItemName(), items);
        }
    }
    
    //Remove items from NPC's Inventory
    public Items removeItem(String itemName) {
        return NPCsInventory.remove(itemName);
    }
    
    public String printNPCInventory() {
        return "" + NPCsInventory.keySet() + ""; //inventory.printNPCInventory() + "";
    }
}
