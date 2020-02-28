
/**
 * Write a description of class Door here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Door
{
    private Room roomA;
    private Room roomB;
    private boolean closed;
    private LockDelegate lockDelegate;

    /**
     * Constructor for objects of class Door
     */
    public Door()
    {
        this(null, null);
    }

    public Door(Room roomA, Room roomB) {
        this.roomA = roomA;
        this.roomB = roomB;
        closed = false;
        lockDelegate = null;
    }

    public Room getRoomFromTheOtherSideOf(Room room) {
        if(room == roomA) {
            return roomB;
        }
        else {
            return roomA;
        }
    }

    public boolean isClosed() {
        return closed;
    }

    public boolean isOpen() {
        return !closed;
    }

    public ActionResult open() {
        if(isOpen()) {
            return ActionResult.UNCHANGED_DONE;
        }
        if(lockDelegate != null) {
            if(lockDelegate.mayOpen()) {
                closed = false;
                return ActionResult.CHANGED_DONE;
            }
            else {
                return ActionResult.UNCHANGED_NOT_DONE;
            }
        }
        else {
            closed = false;
            return  ActionResult.CHANGED_DONE;
        }
    }

    public ActionResult close() {
        if(isClosed()) {
            return ActionResult.UNCHANGED_DONE;
        }
        if(lockDelegate != null) {
            if(lockDelegate.mayClose()) {
                closed = true;
                return ActionResult.CHANGED_DONE;
            }
            else {
                return ActionResult.UNCHANGED_NOT_DONE;
            }
        }
        else {
            closed = true;
            return ActionResult.CHANGED_DONE;
        }
    }

    public LockDelegate setLockDelegate(LockDelegate lockDelegate) {
        LockDelegate oldLock = this.lockDelegate;
        this.lockDelegate = lockDelegate;
        return oldLock;
    }

    public LockDelegate getDelegate() {
        return lockDelegate;
    }

    public static Door makeDoor(Room room1, Room room2, String toRoom1, String toRoom2) {
        Door door = new Door(room1, room2);
        room1.setExit(toRoom1, door);
        room2.setExit(toRoom2, door);

        return door;
    }
}
