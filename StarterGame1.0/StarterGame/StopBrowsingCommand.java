
/**
 * Write a description of class StopBrowsingCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StopBrowsingCommand extends Command
{
    /**
     * Constructor for objects of class StopBrowsingCommand
     */
    public StopBrowsingCommand()
    {
        super("stop_browsing");
    }
    
    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message. Returns always 'false'.
     */
    public boolean execute(Player player)
    {
        if(hasSecondWord()) {
            String npcName = getSecondWord(); //original code
            player.stopBrowsing(npcName); //original code
        }
        else {
            // if there is no second word, we don't know where to go...
            System.out.println("Who?"); //original code
        }
        return false;
    }
}
