import java.util.ArrayList;
//import java.util.Scanner;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Lawrence House", "99 Green St Northampton, MA 01063", 4)); // Overloaded House constructor
        myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm St Northampton, MA 01063", 1)); // Overloaded Cafe constructor
        myMap.addBuilding(new Building("Hillyer Hall", "20 Elm St Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Haven House", "10 Elm St Northampton, MA 01063", 3));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 3, true)); // Overloaded Library Constructor
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Elm St Northampton, MA 01063", 2));
        myMap.addBuilding(new Building("Hatfield Hall", "3 Neilson Drive Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Smith Art Museum", "20 Elm St Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Burton Hall", "46 College Ln Northampton, MA 01063", 4));
        myMap.addBuilding(new Library("Hillyer Art Library", "20 Elm St Northampton, MA 01063", 1, false));
        System.out.println(myMap);
        ((Library) myMap.buildings.get(6)).addTitle("Tender is the Flesh", false); // Overloaded addTitle method
        ArrayList<String> newResidents = new ArrayList<String>();
        newResidents.add("Ron");
        newResidents.add("Harry");
        newResidents.add("Hermione");
        ((House) myMap.buildings.get(2)).moveIn(newResidents); // Overloaded moveIn method
        ((Cafe) myMap.buildings.get(3)).sellCoffee(); // Overloaded sellCoffee method

        // Interactive game
        // Scanner interactiveGame = new Scanner(System.in);

        // System.out.println("Welcome to campus! Let's check out the directory.");
        // System.out.println(myMap);

        // boolean playing = true;

        // while(playing) {
        //     System.out.println("Where would you like to go? Enter a number 1 - " + myMap.buildings.size() + ".");
        //     int destination = -1;
        //     try {
        //         destination = interactiveGame.nextInt();
        //         myMap.buildings.get(destination-1);
        //     } catch (java.util.InputMismatchException e) {
        //         interactiveGame.nextLine();
        //         continue;
        //     } catch (Exception e) {
        //         interactiveGame.nextLine();
        //         continue;
        //     }
        //     System.out.println("You have decided to check out " + myMap.buildings.get(destination-1).getName() + ". Let's go inside.");
        //     myMap.buildings.get(destination-1).enter();
        //     myMap.buildings.get(destination-1).showOptions();
        //     System.out.println("What would you like to do? Enter something like 'goUp' or 'exit'.");
        //     String action = "";
        //     try {
        //         action = interactiveGame.nextLine();
        //         if (action.equals("")) {

        //         }
        //     } catch (java.util.InputMismatchException e) {
        //         interactiveGame.nextLine();
        //         continue;
        //     }
        //     System.out.println("Keep playing? Enter y/n");
        //     interactiveGame.nextLine();
        //     String keepPlaying = interactiveGame.nextLine();
        //     if (!keepPlaying.equalsIgnoreCase("y") && !keepPlaying.equalsIgnoreCase("yes")) {
        //         playing = false;
        //     }
        // }
        // System.out.println("Come again soon!");
        // interactiveGame.close();
    }
    
}
