import java.util.List;
import java.util.ArrayList;
//
import java.util.Set;
import java.util.HashMap;

/**
 * Write a description of class NPCInventory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NPCInventory
{
    //public List npcInventory;
    private HashMap<String, Items> npcInventory;
    //
    private String npcName;
    
    /**
     * Constructor for objects of class NPCInventory
     */
    public NPCInventory(NPC npc)
    {
        npcInventory = new HashMap<String, Items>(10);
        
        //getting the npc's name
        this.npcName = npc.getNPCName();
    }
    
    public void add(Items items) {
        npcInventory.put(items.getItemName(), items);
    }
    
    public void remove(Items items, Room room) {
        if(items.getItemName() != null) {
            npcInventory.remove(items.getItemName(), items);
            room.putItemInRoom(items.getItemName(), items);
        }
        else {
            System.out.println("Item does not exist!");
        }
    }
    
    public void trade(Items items, PlayerInventory inventory) {
        if(items.getItemName() != null) {
            npcInventory.remove(items);
            inventory.addItem(items);
        }
        else {
            System.out.println("That item does not exist....");
        }
    }
    
    public String toString() {
        return "" + npcInventory.keySet() + "";
    }
    
    /*****************************************************************/
    //Trying to allow player to look at a specific npc's inventory
    
    public HashMap<String, Items> getNPCInventory() {
        return npcInventory;
    }
    
    
    //Printing the npc and the items in his/her inventory
    public String printNPCInventory() {
        return npcName + "'s Inventory: " + toString();
    }
}
