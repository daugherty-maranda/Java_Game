import java.util.List;
import java.util.ArrayList;
//
import java.util.Set;
import java.util.HashMap;

/**
 * Contains the items that the player picks up.
 * 
 * @author (Phillip Quinn and Maranda Daugherty) 
 * @version (3/21/2019)
 */
public class PlayerInventory
{
    //Weight
    public int maxCarryWeight = 10;   //Increases as player levels
    public int currentWeight;
    //Volume
    public int maxVolume = 10;  //5 for starter bag
    public int currentVolume;  //
    
    public HashMap<String, Items> inventory;

    /**
     * Constructor for objects of class PlayerInventory
     */
    public PlayerInventory()
    {
        inventory = new HashMap<String, Items>();//new ArrayList(); //Add a weight and volume max later
        this.currentWeight = 0;
        this.currentVolume = 0;
    }
    
    //Getters for class
    public int getMaxCarryWeight() {
        return maxCarryWeight;
    }
    
    public int getMaxVolume() {
        return maxVolume;
    }
    
    //Setters for class
    public void setMaxCarryWeight(int weight) {
        this.maxCarryWeight = weight;
    }
    
    public void setMaxCarryVolume(int volume) {
        this.maxVolume = volume;
    }

    //This adds items that the player picks up to his/her inventory
    public void addItem(Items item) {
        if(maxCarryWeight >= (item.getItemWeight() + currentWeight)) {
            if(maxVolume >= (item.getItemVolume() + currentVolume)) {
                inventory.put(item.getItemName(), item);
                
                currentWeight = currentWeight + item.getItemWeight();
                currentVolume = currentVolume + item.getItemVolume();
            }
            else {
                System.out.println("Item is too big! ...Does it come in a smaller size?");
            }
        }
        else {
            System.out.println("Item is too heavy! ...Inventory might rip...");
        }
    }

    //This drops (removes) an item from the players inventory and puts it back into the room - needs more work
    public void removeItem(Items item) {
        if(item.getItemName() != null) {
            inventory.remove(item.getItemName());
            
            //Put the removed item in room
            //room.putItemInRoom(item, room);
        }
        else {
            System.out.println("Sorry, but this item does not exist...");
            System.out.println("....");
            System.out.println("Maybe Ghosts got it?");
        }
    }
    
    public String toString() {
        return "" + inventory.keySet() + "";
    }
}
