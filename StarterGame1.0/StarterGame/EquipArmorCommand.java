
/**
 * Write a description of class EquipArmorCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EquipArmorCommand extends Command
{
    /**
     * Constructor for objects of class EquipArmorCommand
     */
    public EquipArmorCommand()
    {
        super("equip_armor");
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message. Returns always 'false'.
     */
    public boolean execute(Player player)
    {
        if(hasSecondWord()) {
            String itemName = getSecondWord(); //original code
            player.equipArmor(itemName); //original code
        }
        else {
            // if there is no second word, we don't know where to go...
            System.out.println("Equip what?"); //original code
        }
        return false;
    }
}
