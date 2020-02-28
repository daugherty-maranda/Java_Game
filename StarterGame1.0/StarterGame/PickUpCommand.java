import java.util.HashMap;

/**
 * Write a description of class PickUpCommand here.
 *
 * @author (Phillip Quinn and Maranda Daugherty)
 * @version (4/11/2019)
 */
public class PickUpCommand extends Command
{   
    /**
     * Constructor for objects of class PickUpCommand
     */
    public PickUpCommand()
    {
        super("pickup");
    }
    
    public boolean execute(Player player)
    {
        if(hasSecondWord()) {
            String itemName = getSecondWord();
            player.pickUp(itemName);
        }
        else {
            // if there is no second word, we don't know what to pickup...
            System.out.println("Pick up what?"); //original code
        }
        return false;
    }
}
