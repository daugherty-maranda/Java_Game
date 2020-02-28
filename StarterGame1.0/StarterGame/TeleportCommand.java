
/**
 * Write a description of class TeleportCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TeleportCommand extends Command
{
    public TeleportCommand()
    {
        super("teleport");
    }

    /**
     * "Quit" was entered. Check the argument to see whether
     * we really quit the game. Return true, if we should quit, false
     * otherwise.
     */
    public boolean execute(Player player)
    {
        Room room = player.getCurrentRoom();
        if(getSecondWord() == null) {
            player.teleport(room);
            return false;
        }
        else {
            System.out.println("Do what?");
        }
        return false;
    }
}

