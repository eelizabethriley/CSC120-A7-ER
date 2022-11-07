import java.util.ArrayList;

/* This is a stub for the House class */
/** A child class of class Building with an array list of strings representing the residents of the house. The attribute "hasDiningRoom" indicates 
 * whether or not this house has a dining room.
*/
public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean elevator;

  /* Default constructor for a house */
  public House() {
    this("<Name Unknown>", "<Addresss Unknown>", 1, false, false);
  }

  /* Overloaded constructor for a House with Name, Address */
  public House(String name, String address) {
    this(name, address, 1, false, false);
  }

  /* Overloaded constructor for a Hosue with Name, Address, nFloors, and hasDiningRoom. */
  public House(String name, String address, int nFloors, boolean hasDiningroom) {
    this(name, address, nFloors, hasDiningroom, false);
  }

  /* Full constructor for a House */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean elevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.elevator = elevator;
    System.out.println("You have built a house: 🏠");
  }

  /* Navigation method goToFloor that allows movement to a different floor */
  public void goToFloor(int floorNum) {
    // If the difference between the floorNum passed in and the floor number that the user is currently on is greater than one floor up or down, 
    // and there is no elevator in this building, then it is not possible to move up or down by more than one floor at a time.
    if (floorNum - activeFloor > 1 || activeFloor - floorNum >1) {
      if (elevator == false) {
        throw new RuntimeException("Cannot go to nonadjacent floor, there is no elevator in " + this.name);
      }
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
     }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }

  /*Accessor for hasDiningRoom value, indicates whether this house has a dining room or not. */
  public boolean getHasDiningRoom() {
    return this.hasDiningRoom;
    }
  
    /*Accessor for nResidents value, returns the number of residents in this house. */
  public int getNResidents() {
    return residents.size();
  }

  /**
   * Adds the specified person's name to the House's array list of residents.
   * @param name the person moving into the house
   */
  public void moveIn(String name) {
    residents.add(name);
  }

  /**
   * Removes the specified person's name from the House's array lsit of residents.
   * @param name the person moving out of the house
   * @return the name of the individual leaving the house
   */
  public String moveOut(String name) {
    residents.remove(name);
    return name;
  }

  /**
   * Indicates whether or not a specified person does or does not live in this house.
   * @param person the name of a specified person 
   * @return true if the resident lives in this house, and false if they do not
   */
  public boolean isResident(String person) {
    return residents.contains(person);
  }

  public void showOptions() {
    super.showOptions();
    System.out.println(" + moveIn()" + "\n + moveOut()" + "\n + isResident()");
  }
  
  public String toString() {
    return this.getName() + " is a " + this.getFloors() + "-story residence in the " + this.getAddress() + " area of campus.";
  }

  /* Main for testing. */
  public static void main(String[] args) {
    House wilson = new House("Wilson", "Quad", 4, false);
    wilson.showOptions();
    wilson.moveIn("Erin Riley");
    wilson.moveIn("Jenny Yang");
    System.out.println(wilson);
    wilson.enter();
    wilson.goUp();
    wilson.goToFloor(3);

    House ziskind = new House("Ziskind", "Mountain Neighborhood", 3, true, true);
    ziskind.enter();
    ziskind.goToFloor(3);

  }

}