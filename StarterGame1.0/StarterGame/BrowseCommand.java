
/**
 * Write a description of class BrowseCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BrowseCommand extends Command
{
    /**
     * Constructor for objects of class BrowseCommand
     */
    public BrowseCommand()
    {
        super("browse");
    }
    
    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message. Returns always 'false'.
     */
    public boolean execute(Player player)
    {
        if(hasSecondWord()) {
            String npcName = getSecondWord(); 
            player.browse(npcName); 
        }
        else {
            // if there is no second word, we don't know where to go...
            System.out.println("Browse who's inventory?"); //original code
        }
        return false;
    }
}
