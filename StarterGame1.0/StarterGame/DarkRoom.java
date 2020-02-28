import java.util.HashMap;
/**
 * Write a description of class DarkRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DarkRoom implements RoomDelegate
{
    private HashMap<String, Door> exits;
    private Room room;
    
    /**
     * Constructor for objects of class DarkRoom
     */
    public DarkRoom()
    {
        
    }
    
    public void setExit(String direction, Door door) {
        exits.put(direction, door);
    }
    
    public String getShortDescription() {
        return "in the dark room";
    }
    
    public String getLongDescription() {
        return "The room is dark";
    }
    
    public String getExitString() {
        return "";
    }
    
    public Door getExit(String direction) {
        return exits.get(direction);
    }
    
    public void setExits(HashMap<String, Door> exists) {
        this.exits = exits;
    }
    
    public void setRoom(Room room) {
        this.room = room;
    }
    
    /**************************************************************************************/
    public String printNPCInRoom() {
        return "'...think something touched my shoulder....'";
    }

    public String printItemsInRoom() {
        return "'Oww! Can't see anything!'";
    }
    
    public String printEnemiesInRoom() {
        return "'Is something growling?!'";
    }
    
    public String pickUp() {
        return "To dark to see anything...";
    }
}
