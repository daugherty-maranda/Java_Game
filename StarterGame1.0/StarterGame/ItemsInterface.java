
/**
 * Write a description of interface ItemsInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface ItemsInterface
{
    String getItemName();
    String getLongName();
    int getItemWeight();
    int getItemVolume();
    int getSellValue();
    int getBuyValue();
    boolean isBroken();
    void addDecorator(ItemsInterface decorator);
    boolean isContainer();
    void addItem(ItemsInterface item);
    ItemsInterface removeItem(String itemName);
    String[] getList();
}
