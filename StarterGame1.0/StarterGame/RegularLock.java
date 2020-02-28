
/**
 * Write a description of class RegularLock here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RegularLock implements LockDelegate
{
    private boolean locked;
    private Items key; //ItemInterface key;
    private Items insertedKey; //ItemInterface insertedKey;

    /**
     * Constructor for objects of class RegularLock
     */
    public RegularLock()
    {
        locked = false;
        key = new Items("key", 0, 0, 0, 10, 1, false, 0, 0); //1, 1, 1, 1, 1, false);
        insertKey(key);
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean isUnlocked() {
        return !locked;
    } 

    public ActionResult lock() {
        if(isUnlocked()) {
            if(insertedKey == key) {
                locked = true;
                return ActionResult.CHANGED_DONE;
            }
            else {
                return ActionResult.UNCHANGED_NOT_DONE;
            }
        }
        else {
            return ActionResult.UNCHANGED_DONE;
        }
    }

    public ActionResult unlock() {
        if(isLocked()) {
            if(insertedKey == key) {
                locked = false;
                return ActionResult.CHANGED_DONE;  //Change in the status
            }
            else {
                return ActionResult.UNCHANGED_NOT_DONE;
            }
        }
        else {
            return ActionResult.UNCHANGED_DONE;
        }
    }

    public boolean mayOpen() {
        if(isLocked()) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean mayClose() {
        if(isLocked()) {
            return true;
        }
        else {
            return true;
        }
    }

    public Items insertKey(Items key) {   //public ItemInterface insertKey(Items key) {
        Items oldKey = this.insertedKey;
        this.insertedKey = key;
        return oldKey;
    }

    public Items removeKey() {  //public ItemInterface removeKey() {
        return insertKey(null);
    }
}
