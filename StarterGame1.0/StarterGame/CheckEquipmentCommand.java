
/**
 * Write a description of class CheckEquipmentCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CheckEquipmentCommand extends Command
{
    /**
     * Constructor for objects of class CheckEquipmentCommand
     */
    public CheckEquipmentCommand()
    {
        super("check_equipment");
    }

    public boolean execute(Player player) {
        if(getSecondWord() == null) {
            player.checkEquipment();
        }
        else {
            System.out.println("Don't understand command...");
        }
        return false;
    }
}
