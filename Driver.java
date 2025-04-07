
import java.util.Scanner;

public class Driver {

    static Location currLocation;
    //static ContainerItem myInventory;
    static ContainerItem myInventory = new ContainerItem("Backpack", "Storage", "A brand new backpack");

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        createWorld();

        System.out.println("Welcome to your adventure! For a refresh on the commands, or to learn them for the first time, type 'help'!");

        while (true) {
            System.out.print("Enter command: ");
            String command = myScanner.nextLine();
            String[] words = command.split(" ");

            switch (words[0].toLowerCase()) {
                case "quit":
                    System.out.println("Program closing, exiting the game");
                    myScanner.close();
                    return;

                case "look":
                    System.out.println(currLocation.getName() + " - " + currLocation.getDescription());
                    System.out.println("Currently has the following items:");
                    for (int i = 0; i < currLocation.numItems(); i++) {
                        System.out.println("+ " + currLocation.getItem(i).getName());
                    }

                    break;

                case "examine":
                    if (words.length > 1) {
                        String itemName = words[1];
                        System.out.println("Searching for item: " + itemName);
                        Item item = currLocation.getItem(itemName);

                        if (item != null) {
                            System.out.println(item.toString());
                        } else {
                            System.out.println("Cannot find that item.");
                        }
                    } else {
                        System.out.println("You need to specify an item to examine.");
                    }

                    break;

                //////////////////////////////////////////////////////////////////////////////////////////////
                case "go":
                    if (words.length > 1) {
                        String direction = words[1].toLowerCase();
                        if (direction.equals("north") || direction.equals("south") || direction.equals("east") || direction.equals("west")) {

                            if (currLocation.canMove(direction)) {
                                currLocation = currLocation.getLocation(direction);
                                System.out.println("You moved " + direction + " into the " + currLocation.getName() + ".");
                            } else {
                                System.out.println("You can not go " + direction + " because there is nothing in that direction.");
                            }
                        } else {
                            System.out.println("Please enter a valid direction that is either north, east, south, or west.");
                        }
                    } else {
                        System.out.println("You need to specify a direction to move.");
                    }
                    break;

                case "inventory":
                    if (myInventory.items.size() == 0) {
                        System.out.println("Your inventory is empty");
                    } else {

                        for (int i = 0; i < myInventory.items.size(); i++) {
                            System.out.println("+ " + myInventory.items.get(i).getName());
                        }
                    }

                    break;

                case "take":

                    if (words.length > 1) {
                        String itemName = words[1].toLowerCase();
                        Item item = currLocation.getItem(itemName);
                        if (item != null) {
                            currLocation.removeItem(itemName);
                            myInventory.addItem(item);
                            System.out.println("You have taken " + itemName + " and it is now in your inventory.");

                        } else {
                            System.out.println("This item does not exist in the current location, please try a different item.");

                        }
                    } else {
                        System.out.println("Please specify an item to take");
                    }

                    break;

                case "drop":

                    if (words.length > 1) {

                        String itemName = words[1].toLowerCase();
                        Item item = myInventory.removeItem(itemName);

                        if (item != null) {
                            currLocation.addItem(item);
                            System.out.println("You have dropped " + item.getName() + ".");

                        } else {
                            System.out.println("Could not find that item in your inventory, please try a different item.");
                        }
                    } else {
                        System.out.println("Please specify an item in your inventory to drop.");
                    }

                    break;

                case "help":
                    System.out.println("Quit - Ends the game and closes the application.");
                    System.out.println("Look - Gives a description of the current location the character is in.");
                    System.out.println("Examine - Gives a description of the item specfied.");
                    System.out.println("Go - Moves the character in the direction specified.");
                    System.out.println("Inventory - Shows the items currently in the character's inventory.");
                    System.out.println("Take - Takes the specified item from the location and into the characters inventory.");
                    System.out.println("Drop - Removes the item from the characters inventory and leaves it at the current location.");
                    System.out.println("Help - Displays information on all the commands for the game.");
                    break;
                ////////////////////////////////////////////////////////////////////////////////


                default:
                    System.out.println("I don't know that command.");
            }
        }
    }

    //createWorld
    public static void createWorld() {
        //Locations
        Location kitchen = new Location("Kitchen", "A regular itchen.");
        Location hallway = new Location("Hallway", "A link between rooms.");
        Location bedroom = new Location("Bedroom", "A room to sleep in.");
        Location bathroom = new Location("Bathroom", "You can take a bath here.");
        currLocation = kitchen;

        //Connections
        kitchen.connect("east", hallway);
        hallway.connect("west", kitchen);

        hallway.connect("east", bathroom);
        bathroom.connect("west", hallway);

        hallway.connect("south", bedroom);
        bedroom.connect("north", hallway);

        //Items
        Item Knife = new Item("Knife", "Utensil", "A sharp knife");
        Item Turkey = new Item("Turkey", "Food", "A hot, cooked turkey");
        Item Plate = new Item("Plate", "Silverware", "A flat plate");
        Item Pillow = new Item("Pillow", "Linen", "A fluffy pillow");

        //Item Locations
        kitchen.addItem(Knife);
        bedroom.addItem(Turkey);
        hallway.addItem(Plate);
        bedroom.addItem(Pillow);
    }
}
