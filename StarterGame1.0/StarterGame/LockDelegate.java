
/**
 * Write a description of interface LockDelegate here.
 *
 * @author (Obando)
 * @version (4/30/2019)
 */
public interface LockDelegate
{
    boolean isLocked();
    boolean isUnlocked();
    ActionResult lock();
    ActionResult unlock();
    boolean mayOpen();
    boolean mayClose();
    //ItemInterface insertKey(Items key);
    Items insertKey(Items key);
    Items removeKey();
    //ItemInterface removeKey();
}
