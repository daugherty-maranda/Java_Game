/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.
 * 
 * @author  Michael Kolling and David J. Barnes modified by Rodrigo A. Obando (2018)
 * @version 1.1 (December 2002)
 */

class Game 
{
    private Parser parser;
    private Player player;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        player = new Player(GameWorld.getInstance().getEntrance());
        parser = new Parser();  //This is used to get the commands from the player
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        boolean finished = false;
        while(! finished) {
            Command command = parser.getCommand();
            if(command == null) {
                System.out.println("I don't understand...");
            } else {
                finished = command.execute(player);
            }
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the Object Oriented Dungeon!");
        System.out.println(" The Object Oriented Dungeon is a grueling, and frustrating adventure game. Try and make it out with your sanity intact.");
        System.out.println("\nType 'help' if you need help.");
        System.out.println();
        System.out.println(player.getCurrentRoom().getLongDescription());
    }
}
