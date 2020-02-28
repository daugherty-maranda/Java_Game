
/**
 * Write a description of class RemoveKeyCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RemoveKeyCommand extends Command
{
    /**
     * Constructor for objects of class RemoveKeyCommand
     */
    public RemoveKeyCommand()
    {
        super("remove_key");
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message. Returns always 'false'.
     */
    public boolean execute(Player player)
    {
        if(hasSecondWord()) {
            String direction = getSecondWord(); //original code
            player.remove(direction); //original code
        }
        else {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?"); //original code
        }
        return false;
    }
}
