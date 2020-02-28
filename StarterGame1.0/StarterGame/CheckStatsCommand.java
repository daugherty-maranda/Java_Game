
/**
 * Write a description of class CheckStatsCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CheckStatsCommand extends Command
{
    /**
     * Constructor for objects of class CheckStatsCommand
     */
    public CheckStatsCommand()
    {
        super("checkstats");
    }

    //This allows for the user to search the rooms for items in the room
    public boolean execute(Player player) {
        if(getSecondWord() == null) {
            player.checkStats();
        }
        else {
            System.out.println("Don't understand command...");
        }
        return false;
    }
}
