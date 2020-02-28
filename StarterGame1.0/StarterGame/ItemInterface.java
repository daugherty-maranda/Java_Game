
/**
 * Write a description of interface ItemInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface ItemInterface
{
    String getName();
    String getLongName();
    float getWeight();
    float getVolume();
    float getSellValue();
    float getBuyValue();
    void addDecorator(ItemInterface decorator);
    boolean isContainer();
    void addItem(ItemInterface item);
    ItemInterface removeItem(String itemName);
    String[] getList();
}
