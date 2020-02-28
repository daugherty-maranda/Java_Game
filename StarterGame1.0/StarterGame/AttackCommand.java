
/**
 * Write a description of class AttackCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AttackCommand extends Command
{
    /**
     * Constructor for objects of class AttackCommand
     */
    public AttackCommand()
    {
        super("attack");
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message. Returns always 'false'.
     */
    public boolean execute(Player player)
    {
        if(hasSecondWord()) {
            String enemyName = getSecondWord(); //original code
            player.attack(enemyName); //original code
        }
        else {
            // if there is no second word, we don't know where to go...
            System.out.println("Attack what?"); //original code
        }
        return false;
    }
}
