import java.util.ArrayList;

/**
 * Represents the House class
 */
public class House extends Building {

  // Attributes

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  boolean hasElevator;

  // Constructors

  /**
   * Constructor for the House class
   * @param name a House's name
   * @param address a House's address
   * @param nFloors the number of stories inside a House
   * @param residents residents living in a House
   * @param hasDiningRoom whether or not a House has a dining room
   * @param hasElevator whether or not a House has an elevator
   */
  public House(String name, String address, int nFloors, ArrayList<String> residents, boolean hasDiningRoom, boolean hasElevator){
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Constructor for the House class with hasElevator set to false, hasDiningRoom set to true, and an empty ArrayList of residents
   * @param name a House's name
   * @param address a House's address
   * @param nFloors the number of stories inside a House
   * @param residents residents living in a House
   */
  public House(String name, String address, int nFloors){
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = true; // default assumption
    this.hasElevator = false; // default assumption
    System.out.println("You have built an empty house: 🏠");
  }

  // Accessors

  /**
   * Returns a boolean based on whether a house has a dining room
   * @return true if a House has a dining room
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Returns a boolean based on whether a House has an elevator
   * @return true if a House has an elevator
   */
  public boolean hasElevator() {
    return hasElevator;
  }

  /**
   * Returns the number of residents currently living in a House
   * @return a House's number of residents
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Returns a boolean based on whether a given person is a resident of a House
   * @param name a person's name
   * @return true if a person is a resident
   */
  public boolean isResident(String name) {
    return (residents.contains(name));
  }

  // Methods

  /**
   * Moves a new resident into a House, provided they are not already living there
   * @param name the name of the person to move in
   */
  public void moveIn(String name) {
    if (isResident(name)) {
      System.out.println(name + " is already living at this address.");
    } else {
      residents.add(name);
      System.out.println(name + " has moved in.");
    }
  }

  /**
   * Moves multiple new residents into a House, provided they are not already living there
   * @param newResidents the people to move in
   */
  public void moveIn(ArrayList<String> newResidents) {
    for (String resident : newResidents) {
      if (isResident(resident)) {
        System.out.println(resident + " is already living at this address.");
      } else {
      residents.add(resident);
      System.out.println(resident + " has moved in.");
      }
    }
  }

  /**
   * Moves a resident out of a House, provided they are currently living there
   * @param name the name of the person to move out
   */
  public String moveOut(String name) {
    if (!isResident(name)) {
      System.out.println(name + " is not living at this address.");
    } else {
      residents.remove(name);
    }
    return(name);
  }

  /**
   * Moves you to the desired floor, provided you are inside the House and the desired floor is a valid level of the House.
   * If the House has an elevator, allows for travel to non-adjacent floors.
   * @param floorNum the intended floor number
   */
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if (!hasElevator()) {
      if (floorNum != activeFloor + 1 && floorNum != activeFloor - 1) {
        throw new RuntimeException("As this building doesn't have an elevator, you can't travel to non-adjacent floors to reach floor " + floorNum + ". You are currently on floor " + activeFloor + ".");
      }
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }

  /**
   * Prints an organized list of relevant methods for the House class
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + moveIn()\n + moveOut()");
  }

  /**
     * Returns a String representing a House with building and resident details.
     */
  public String toString() {
    String diningRoom = "";
    if(hasDiningRoom) {
      diningRoom = "a dining room";
    } else {
      diningRoom = "no dining room";
    }
    return super.toString() + " " + name + " has " + diningRoom + " and " + nResidents() + " resident(s).";
  }

  /**
     * A main function for creating an example House
     * @param args an empty Array of Strings for storing command line arguments
     */
  public static void main(String[] args) {
    House someHouse = new House("Harry's House", "12 Grimmauld Place", 3);
    System.out.println(someHouse);
    someHouse.showOptions();
    //someHouse.moveIn(newResidents);
    //System.out.println(someHouse);
    //someHouse.moveOut("Harry");
    //someHouse.moveIn("Mavis");
    //System.out.println(someHouse);
  }

}