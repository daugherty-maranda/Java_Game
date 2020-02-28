
/**
 * Write a description of class TakeCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TakeCommand extends Command
{
    /**
     * Constructor for objects of class TakeCommand
     */
    public TakeCommand()
    {
     super("take");
    }
    
    /** 
     * Try to take an item from npc. If there is an exit, enter the new
     * room, otherwise print an error message. Returns always 'false'.
     */
    public boolean execute(Player player)
    {
        if(hasSecondWord()) {
            String item = getSecondWord(); //original code
        }
        else {
            // if there is no second word, we don't know where to go...
            System.out.println("Take what?"); //original code
        }
        return false;
    }
}
