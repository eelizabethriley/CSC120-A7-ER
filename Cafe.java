/** A child class of Building with the attributes nCoffeeOunces,
 * nSugarPackets, nCreams, and nCups.
 */
public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructor for the class cafe that inherits name, address, and nFloors from the parent Building.
     * @param name the name of this Cafe
     * @param address the address of this Cafe
     * @param nFloors the number of floors in this Cafe
     * @param nCoffeeOunces the quantity of coffee, in ounces, currently in stock
     * @param nSugarPackets the quantity of sugar packets currently in stock
     * @param nCreams the number of "splashes" of cream in stock at the Cafe
     * @param nCups the number of cups in the Cafe's inventory
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
     * Reduces the stock of the items in the Cafe's inventory when a coffee is sold.
     * @param size the quantity of coffee, in ounces, of the coffee being sold
     * @param nSugarPackets the number of sugar packets in the coffee being sold
     * @param nCreams the number of "splashes" of cream in the coffee being sold
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (size > this.nCoffeeOunces || nSugarPackets > this.nSugarPackets || nCreams > this.nCreams || this.nCups == 0) {
            this.restock(size, nSugarPackets, nCreams);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups --;
        System.out.println(size + " oz coffee with " + nSugarPackets + " sugar(s) and " + nCreams + " cream(s) has been sold. Thank you!");
    }
    
    /**
     * Increases the stock of the items in the Cafe's inventory.
     * @param size the quantity of coffee, in ounces, being added to the Cafe's inventory
     * @param nSugarPackets the number of sugar packets being added to the Cafe's inventory
     * @param nCreams the amount of cream being added to the Cafe's inventory
     */
    private void restock(int size, int nSugarPackets, int nCreams) {
        this.nCoffeeOunces += size;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups ++;
        System.out.println("Successfully restocked the Cafe.");
    }
    
    public static void main(String[] args) {
        Cafe ccCafe = new Cafe("Campus Center Cafe", "100 Elm St, Northampton, MA 01063", 3, 50, 10, 20, 20);
        ccCafe.sellCoffee(12, 1, 2);
    }
    
}
