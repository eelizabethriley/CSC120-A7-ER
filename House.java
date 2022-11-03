import java.util.ArrayList;

/* This is a stub for the House class */
/** A child class of class Building with an array list of strings representing the residents of the house. The attribute "hasDiningRoom" indicates 
 * whether or not this house has a dining room.
*/
public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  /* Constructor for a House */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
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

  public String toString() {
    return this.getName() + " is a " + this.getFloors() + "-story residence in the " + this.getAddress() + " area of campus.";
  }

  /* Main for testing. */
  public static void main(String[] args) {
    House wilson = new House("Wilson", "Quad", 4,false);
    wilson.moveIn("Erin Riley");
    wilson.moveIn("Jenny Yang");
    System.out.println(wilson);

  }

}