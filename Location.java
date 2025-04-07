
import java.util.ArrayList;
import java.util.HashMap;

public class Location {

    private String name;
    private String description;
    private ArrayList<Item> items;
    HashMap<String,Location> connections;

    //Constructors
    public Location(String pName, String pDescription) {
        name = pName;
        description = pDescription;
        items = new ArrayList<>();
        //connections = new HashMap<String,Location>();
        connections = new HashMap<>();
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //Setters
    public void setName(String newName) {
        name = newName;
    }

    public void setDescription(String newDescription) {
        description = newDescription;
    }

    //Add Item Method
    public void addItem(Item addedItem) {
        items.add(addedItem);
    }

    //Has Item Method
    public boolean hasItem(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    //Get Item Method (takes String)
    public Item getItem(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(itemName)) {
                return items.get(i);
            }
        }
        return null;
    }

    //Get Item Method (takes int)
    public Item getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    //Number of Items Method
    public int numItems() {
        int totalItems = items.size();
        return totalItems;
    }

    //Remove Item Method
    public Item removeItem(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(itemName)) {
                return items.remove(i);
            }
        }
        return null;
    }

    //connect Method
    public void connect(String direction, Location locationName){
        connections.put(direction, locationName);
    }

    //canMove Method
    public boolean canMove(String direction){
        boolean hasLocation = connections.containsKey(direction);
        return hasLocation;
    }

    //getLocation Method
    public Location getLocation(String direction){
        Location result = connections.get(direction);
        return result;
    }
}
