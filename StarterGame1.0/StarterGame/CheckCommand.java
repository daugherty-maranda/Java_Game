
/**
 * Write a description of class CheckCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CheckCommand extends Command
{
    /**
     * Constructor for objects of class CheckCommand
     */
    public CheckCommand()
    {
        super("check_inventory");
    }
    
    public boolean execute(Player player) {
        if(getSecondWord() == null) {
            player.check();
        }
        else {
            System.out.println("Don't understand command...");
        }
        return false;
    }
}
