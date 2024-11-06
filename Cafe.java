/**
 * Represents the Cafe class
 */
public class Cafe extends Building{

    // Attributes

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    // Constructors

    /**
     * Constructor for the Cafe class
     * @param name a Cafe's name
     * @param address a Cafe's address
     * @param nFloors the number of stories inside a Cafe
     * @param nCoffeeOunces number of ounces of coffee remaining in a Cafe's inventory
     * @param nSugarPackets number of sugar packets remaining in a Cafe's inventory
     * @param nCreams number of pumps of cream remaining in a Cafe's inventory
     * @param nCups number of cups remaining in a Cafe's inventory
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Constructor for the Cafe class with a default amount of each inventory item
     * @param name a Cafe's name
     * @param address a Cafe's address
     * @param nFloors the number of stories inside a Cafe
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 50;
        this.nCreams = 50;
        this.nCups = 10;
        System.out.println("You have built a basic cafe: ☕");
    }

    // Methods

    /**
     * Restocks the coffee, sugar packets, cream, and cups in a Cafe's inventory 
     * @param nCoffeeOunces ounces of coffee to be in the inventory after restock
     * @param nSugarPackets number of sugar packets to be in the inventory after restock
     * @param nCreams pumps of cream to be in the inventory after restock
     * @param nCups number of cups to be in the inventory after restock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
     * Restocks a Cafe's inventory with default amounts of each item
     */
    private void restock() {
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 50;
        this.nCreams = 50;
        this.nCups = 10;
        System.out.println(name + " has been restocked. Current cafe inventory: " + nCoffeeOunces + " ounces of coffee, " + nCreams + " pumps of cream, " + nSugarPackets + " sugar packets, " + nCups + " cups.");
    }

    /**
     * Decreases a Cafe's inventory by selling a drink 
     * containing a given amount of coffee, sugar packets, and cream.
     * If inventory stock is too low, restocks before selling.
     * @param size the desired amount of coffee in ounces
     * @param nSugarPackets the desired number of sugar packets
     * @param nCreams the desired pumps of cream
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            System.out.println("Inventory low. Restocking...");
            restock((size + 10), (nSugarPackets + 10), (nCreams + 10), 10);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("You have made a " + size + " ounce coffee containing " + nCreams + " pump(s) of cream and " + nSugarPackets + " sugar packet(s).");
    }

    /**
     * Decreases a Cafe's inventory by selling a drink 
     * containing a default amount of coffee, sugar packets, and cream.
     * If inventory stock is too low, restocks before selling.
     */
    public void sellCoffee() {
        if (this.nCoffeeOunces < 12 || this.nSugarPackets < 2 || this.nCreams < 3 || this.nCups < 1) {
            System.out.println("Inventory low. Restocking...");
            restock();
        }
        this.nCoffeeOunces -= 12;
        this.nSugarPackets -= 2;
        this.nCreams -= 3;
        this.nCups -= 1;
        System.out.println("You have made a 12 ounce coffee containing 3 pumps of cream and 2 sugar packets.");
    }

    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        if (floorNum > 1) {
            System.out.println("You aren't permitted access to floor #" + floorNum + " of " + this.name);
        }
        System.out.println("You are currently on floor #" + activeFloor + " of " + this.name);
    }

    /**
   * Prints an organized list of relevant methods for the Cafe class
   */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + restock()\n + sellCoffee()");
    }

    /**
     * Returns a String representing a Cafe with building and inventory details.
     */
    public String toString() {
        return super.toString() + ". " + "\n" + "Current cafe inventory: " + nCoffeeOunces + " ounces of coffee, " + nCreams + " pumps of cream, " + nSugarPackets + " sugar packets, " + nCups + " cups.";
    }
 
    /**
     * A main function for creating an example Cafe
     * @param args an empty Array of Strings for storing command line arguments
     */
    public static void main(String[] args) {
        Cafe funCafe = new Cafe("Sunbucks", "1 Chapin Way", 10, 15, 10, 15, 5);
        //funCafe.restock(10, 100, 100, 100);
        System.out.println(funCafe);
        funCafe.sellCoffee(100, 100, 100);
        //System.out.println(funCafe);
        funCafe.showOptions();
        funCafe.restock();
        funCafe.enter();
        funCafe.goToFloor(2);
    }
    
}
