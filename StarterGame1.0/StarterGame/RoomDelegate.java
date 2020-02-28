import java.util.HashMap;

/**
 * Write a description of interface RoomDelegate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface RoomDelegate
{
    void setExit(String direction, Door door);
    String getShortDescription();
    String getLongDescription();
    String getExitString();
    Door getExit(String direction);
    void setExits(HashMap<String, Door> exists);
    void setRoom(Room room);
    /******************************/
    String printNPCInRoom();
    String printItemsInRoom();
    String printEnemiesInRoom();
    String pickUp();
}
