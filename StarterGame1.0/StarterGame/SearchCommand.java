
/**
 * Write a description of class SearchCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SearchCommand extends Command
{
    /**
     * Constructor for objects of class SearchCommand
     */
    public SearchCommand()
    {
        super("search");
    }
    
    //This allows for the user to search the rooms for items in the room
    public boolean execute(Player player) {
        if(getSecondWord() == null) {
            Room room = player.getCurrentRoom();
            player.search(room);
        }
        else {
            System.out.println("Don't understand command...");
        }
        return false;
    }
}
