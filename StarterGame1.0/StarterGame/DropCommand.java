
/**
 * Write a description of class DropCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DropCommand extends Command
{
    /**
     * Constructor for objects of class DropCommand
     */
    public DropCommand()
    {
        super("drop");
    }
    
    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message. Returns always 'false'.
     */
    public boolean execute(Player player)
    {
        if(hasSecondWord()) {
            String itemName = getSecondWord();
            player.drop(itemName); 
        }
        else {
            // if there is no second word, we don't know where to go...
            System.out.println("Drop what?"); //original code
        }
        return false;
    }
}
