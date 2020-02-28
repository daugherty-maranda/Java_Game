import java.util.HashMap;

/**
 * This class is the main class of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class holds a collection of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes modified by Rodrigo A. Obando (2018)
 * @version 2.0 (December 2002)
 */

public class CommandWords
{
    private HashMap<String, Command> commands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        commands = new HashMap<String, Command>();
        Command command = new GoCommand();
        commands.put(command.getName(), command);
        command = new HelpCommand(this);
        commands.put(command.getName(), command);
        command = new QuitCommand();
        commands.put(command.getName(), command);
        //Back Command
        command = new BackCommand();
        commands.put(command.getName(), command);
        //Give
        
        //Take
        command = new TakeCommand();
        commands.put(command.getName(), command);
        //Pick Up
        command = new PickUpCommand();
        commands.put(command.getName(), command);
        //Drop
        command = new DropCommand();
        commands.put(command.getName(), command);
        //Torch
        command = new TorchCommand();
        commands.put(command.getName(), command);
        //Search
        command = new SearchCommand();
        commands.put(command.getName(), command);
        //Trade
        
        //Use
        
        //Attack
        command = new AttackCommand();
        commands.put(command.getName(), command);
        //Open
        command = new OpenCommand();
        commands.put(command.getName(), command);
        //Unlock
        command = new UnlockCommand();
        commands.put(command.getName(), command);
        //Insert key
        command = new InsertCommand();
        commands.put(command.getName(), command);
        //Remove key
        command = new RemoveKeyCommand();
        commands.put(command.getName(), command);
        //CheckInventory
        command = new CheckCommand();
        commands.put(command.getName(), command);
        //Browse <--- This allows you to 'browse' the npc's inventory
        command = new BrowseCommand();
        commands.put(command.getName(), command);
        //Stop Browsing <--- This allows you to 'stop_browsing' the npc's inventory
        command = new StopBrowsingCommand();
        commands.put(command.getName(), command);
        //Equip Weapon
        command = new EquipWeaponCommand();
        commands.put(command.getName(), command);
        //Equip Armor
        command = new EquipArmorCommand();
        commands.put(command.getName(), command);
        //Unequip
        command = new UnequipCommand();
        commands.put(command.getName(), command);
        //CheckEquipment
        command = new CheckEquipmentCommand();
        commands.put(command.getName(), command);
        //CheckStats
        command = new CheckStatsCommand();
        commands.put(command.getName(), command);
        //Inspect Inventory Items
        command = new InspectInventoryItemCommand();
        commands.put(command.getName(), command);
        //Inspect Items in Room
        
        //Inspect Items in NPC's Inventory
        
        //teleport
        command = new TeleportCommand();
        commands.put(command.getName(), command);
        //escape
        command = new EscapeCommand();
        commands.put(command.getName(), command);
    }

    /**
     * Given a command word, find and return the matching command object.
     * Return null if there is no command with this name.
     */
    public Command get(String word)
    {
        return commands.get(word);
    }

    /*
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        for(String commandName : commands.keySet())
        {
            System.out.print(commandName + "  ");
        }
        System.out.println();
    }
}
