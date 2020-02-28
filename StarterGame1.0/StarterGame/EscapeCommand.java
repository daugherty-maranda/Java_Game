
/**
 * Write a description of class EscapeCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EscapeCommand extends Command
{
    public EscapeCommand()
    {
        super("escape");
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
            if(player.escape(room))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else {
            System.out.println("Do what?");
        }
        return false;
    }
}
