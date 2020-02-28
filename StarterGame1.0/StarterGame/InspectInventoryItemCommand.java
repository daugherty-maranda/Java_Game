
/**
 * Write a description of class InspectInventoryItemCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InspectInventoryItemCommand extends Command
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class InspectInventoryItemCommand
     */
    public InspectInventoryItemCommand()
    {
       super("inspect");
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message. Returns always 'false'.
     */
    public boolean execute(Player player)
    {
        if(hasSecondWord()) {
            String itemName = getSecondWord(); //original code
            player.inspectInventoryItems(itemName); //original code
        }
        else {
            // if there is no second word, we don't know where to go...
            System.out.println("Inspect what item from inventory?"); //original code
        }
        return false;
    }
}
