
/**
 * Write a description of class UnlockCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UnlockCommand extends Command
{
    /**
     * Constructor for objects of class UnlockCommand
     */
    public UnlockCommand()
    {
        super("unlock");
    }
    
    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message. Returns always 'false'.
     */
    public boolean execute(Player player)
    {
        if(hasSecondWord()) {
            String direction = getSecondWord(); //original code
            player.unlock(direction); //original code
        }
        else {
            // if there is no second word, we don't know where to go...
            System.out.println("Unlock what?"); //original code
        }
        return false;
    }
}
