
/**
 * Write a description of class InsertCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InsertCommand extends Command
{
    /**
     * Constructor for objects of class InsertCommand
     */
    public InsertCommand()
    {
        super("insert");
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message. Returns always 'false'.
     */
    public boolean execute(Player player)
    {
        if(hasSecondWord()) {
            //String direction = getSecondWord();
            String itemName = getSecondWord();
            if(hasThirdWord()) {
                String direction = getThirdWord();
                player.insert(itemName, direction); //"key", direction); 
            }
            else{
                // if there is no third word, we don't know where to go...
                System.out.println("Insert where?");
            }
        }
        else {
            // if there is no second word, we don't know what to insert...
            System.out.println("Insert what?"); //original code
        }
        return false;
    }
}
