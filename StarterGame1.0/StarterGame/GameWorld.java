import java.util.HashMap;
/**
 * Write a description of class GameWorld here.
 *
 * @author (Phillip Quinn and Maranda Daugherty)
 * @version (4/2/2019)
 */
public class GameWorld
{
    public static GameWorld instance;
    private Room entrance;
    private HashMap<Room, WorldMod> worldMods;

    /**
     * Constructor for objects of class GameWorld
     */
    public GameWorld()
    {
        worldMods = new HashMap<Room, WorldMod>();
        createWorld();

        NotificationCenter.getInstance().addObserver("PlayerEnteredRoom", this, "playerEnteredRoom");
    }

    public Room getEntrance() {
        return entrance;
    }

    public static GameWorld getInstance() {
        if(instance == null) {
            instance = new GameWorld();
        }
        return instance;
    }

    public void playerEnteredRoom(Notification notification) {
        Player player = (Player)notification.getObject();
        
        Room room = player.getCurrentRoom();
        System.out.println("<>");

        WorldMod theMod = worldMods.get(room);

        if(theMod != null) {
            theMod.process();
            
            System.out.println("\b\n<<<< You opened a whole new world >>>>\n");
        }
    }

    public void createWorld()
    {
        Room outside = new Room("outside the main entrance of the dungeon");
        Room forest = new Room("in the shadowy forest beyond");
        Room dirtPath = new Room("on the decrepit dirt path");  //bo
        Room meadow = new Room("in the foggy meadow"); //
        Room tomb = new Room("in the eerie tomb");   //parking deck 
        Room mainDungeon = new Room("in the Main Dungeon");  //other name throneRoom? (Special quest)
        Room garden = new Room("in the infested Garden");  //The lawn
        Room tortureHall = new Room("in Torture Hall");   //rest in peace math majors - the force shall miss you
        Room ballRoom = new Room("in the haunted Ball Room");  //group mets up - can find Set NPC(Ani) here

        Room crypt = new Room("in the haunted Crypt");
        Room clockTower = new Room("in the crumbling Clock Tower");

        Room guestRoom = new Room("in the vacant guest room");
        Room hall = new Room("in the endless hallway");
        
        /***************************************************************************/
        Door door = Door.makeDoor(dirtPath, outside, "east", "west");
        
        door = Door.makeDoor(forest, dirtPath, "north", "south");
        
        door = Door.makeDoor(garden, dirtPath, "east", "west");
        
        door = Door.makeDoor(meadow, dirtPath, "south", "north"); // north south
        
        door = Door.makeDoor(mainDungeon, forest, "east", "west"); //west east
        
        door = Door.makeDoor(ballRoom, mainDungeon, "south", "north"); //north south
        door.close();
        RegularLock cLock = new RegularLock();
        door.setLockDelegate(cLock);
        cLock.lock();
        Items cKey = cLock.removeKey();
        garden.drop(cKey);
        
        door = Door.makeDoor(garden, ballRoom, "west", "east"); //east west
        door.close();
        RegularLock aLock = new RegularLock();
        door.setLockDelegate(aLock);
        aLock.lock();
        Items key = aLock.removeKey();
        tortureHall.drop(key);
        
        door = Door.makeDoor(tortureHall, ballRoom, "south", "north"); //north south
        door.close();
        RegularLock bLock = new RegularLock();
        door.setLockDelegate(bLock);
        bLock.lock();
        Items bKey = bLock.removeKey();
        forest.drop(bKey);
        
        door = Door.makeDoor(meadow, tortureHall, "west", "east");
        
        door = Door.makeDoor(tomb, meadow, "south", "north");
        
        door = Door.makeDoor(clockTower, crypt, "east", "west");//"west", "east");
        
        door = Door.makeDoor(guestRoom, hall, "north", "south"); //"south", "north");
        
        /******************************************************************/
        //Items test!!
        Items sword = new Melee("sword", 5, 1, 1, 2, 10, false, 3, 0, 0);
        mainDungeon.putItemInRoom(sword.getItemName(), sword);

        Items fire = new Magic("firespell", 1, 1, 1, 2, 10, false, 2, 0, 1);
        dirtPath.putItemInRoom(fire.getItemName(), fire);
        
        Items odd = new Melee("oddpole", 5, 1, 1, 2, 10, false, 3, 0, 0);
        dirtPath.putItemInRoom(odd.getItemName(), odd);
        
        Items summon = new Magic("special", 1, 1, 1, 20, 10, false, 2, 0, 1);
        
        Items lightArmor = new LightArmor("lightarmor", 1, 1, 2, 3, 10, false, 0, 2, 0);
        outside.putItemInRoom(lightArmor.getItemName(), lightArmor);
        
        Items heavyArmor = new LightArmor("heavyarmor", 1, 1, 2, 3, 10, false, 0, 2, -1);
        outside.putItemInRoom(heavyArmor.getItemName(), heavyArmor);
        
        System.out.println("");
        
        /*************************************************************************************************************/
        
        //NPC Test!!
        NPC npc1 = new NPC("Andi", 100, tomb);
        tomb.putNPCInRoom(npc1.getNPCName(), npc1);
        npc1.addItem(sword);
        npc1.addItem(fire);
        npc1.addItem(summon);
        System.out.println("");
        
        NPC npc2 = new NPC("Jon", 100, crypt);
        crypt.putNPCInRoom(npc2.getNPCName(), npc2);
        npc2.addItem(sword);
        npc2.addItem(heavyArmor);
        System.out.println("");
        
        /*************************************************************************************************************/
        
        Enemy goblin = new Enemy("Goblin", 4, 1, forest);
        forest.putEnemyInRoom(goblin.getEnemyName(), goblin);
        
        /*************************************************************************************************************/
        
        //NPC Inventory
        NPCInventory npc1Inventory = new NPCInventory(npc1);
        npc1Inventory.add(sword);
        npc1Inventory.add(fire);
        npc1Inventory.add(summon);
        System.out.println(npc1.getNPCName() + "'s Inventory: " + npc1Inventory.toString());
        
        NPCInventory npc2Inventory = new NPCInventory(npc2);
        System.out.println(npc2.getNPCName() + "'s Inventory: " + npc2Inventory.toString());
        System.out.println(npc1Inventory.printNPCInventory());

        //Player Inventory
        PlayerInventory inventory = new PlayerInventory();

        System.out.println("Max Weight: " + inventory.getMaxCarryWeight() + ". " + "Max Volume: " + inventory.getMaxVolume() + ".");
        /********************************************************/

        DarkRoom darkRoom = new DarkRoom();
        tortureHall.setDelegate(darkRoom);

        entrance = outside;

        WorldMod aMod = new WorldMod(tomb, ballRoom, crypt, "west", "east");//"east", "west");
        worldMods.put(aMod.getTrigger(), aMod);
        aMod = new WorldMod(clockTower, mainDungeon, hall, "south", "north"); //"north", "south");
        worldMods.put(aMod.getTrigger(), aMod);
    }

    private class WorldMod {
        Room trigger;
        Room worldsEnd;
        Room otherWorld;
        String worldsEndDirection;
        String otherWorldDirection;

        WorldMod(Room trigger, Room worldsEnd, Room otherWorld, String worldsEndDirection, String otherWorldDirection) {
            this.trigger = trigger;
            this.worldsEnd = worldsEnd;
            this.otherWorld = otherWorld;
            this.worldsEndDirection = worldsEndDirection;
            this.otherWorldDirection = otherWorldDirection;
        }

        void process() {
            Door door = Door.makeDoor(otherWorld, worldsEnd, otherWorldDirection, worldsEndDirection);
        }

        Room getTrigger() {
            return trigger;
        }
    }
}
