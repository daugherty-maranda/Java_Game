
/**
 * Write a description of class TorchCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TorchCommand extends Command
{
    /**
     * Constructor for objects of class QuitCommand
     */
    public TorchCommand()
    {
        super("torch");
    }

    /**
     * "Quit" was entered. Check the argument to see whether
     * we really quit the game. Return true, if we should quit, false
     * otherwise.
     */
    public boolean execute(Player player)
    {
        player.torch();
        return false;
    }
}
