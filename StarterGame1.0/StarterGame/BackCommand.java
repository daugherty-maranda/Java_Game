
/**
 * This command allows the player to back track on the rooms that they previously visited.
 * 
 * @author (Phillip Quinn and Maranda Daugherty) 
 * @version (3/21/2019)
 */
public class BackCommand extends Command
{
    /**
     * Constructor for objects of class BackCommand
     */
    public BackCommand()
    {
        super("back");
    }
    
    //This allows for the user to go 'back' to rooms that were previously visited
    public boolean execute(Player player) {
        if(getSecondWord() == null) 
        {
            /*
            if(player.previousRooms.peek() == null)
            {
                System.out.println("You can't go back anymore.");
            }
            else
            {
                player.setCurrentRoom(player.getPreviousRoom());
                System.out.println(player.getCurrentRoom().getLongDescription());
                
            }*/
            try {
                player.setCurrentRoom(player.getPreviousRoom());
                System.out.println(player.getCurrentRoom().getLongDescription());
            }
            catch (Exception e) {
                System.out.println("You can not go back any further!");
            }
        }
        else 
        {
            
        }
        return false;
    }
}
