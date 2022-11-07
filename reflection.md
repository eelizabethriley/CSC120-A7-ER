Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?

I gave the House class overloaded constructors including an empty one with default values, one with just the name and address, one with all informatiom except whether or not there is an elevator (default set to false), and a full constructor with name, address, nFloors, hasDiningRoom, and elevator. I added these constructors because much like the parent class I wanted there to be flexibility when creating a House in situations where not all information is known, however the House constructor different from the Building ones so I couldn't have House inheret every part of those.

For the Cafe class, I decided to overload the sellCoffee() method, making it so that it could be called with just the size of the coffee passed in so that a simple black coffee could be sold with no creams or sugars.
I also overloaded the restock() method to support this version of the sellCoffee() method so that the restock() method could be called in the overloaded method as well to restock only the ounces of coffee, not the creams or sugars which are not needed for this order.
I also added a default restock() method that simply increases the stock of each inventory item by 1.

- What worked, what didn't, what advice would you give someone taking this course in the future?

For this assignment, a lot of the work involves making decisions about what makes the most sense for the program and trying to determine
the most logical design choices. There were certain Classes I wasn't totally sure how to apply the same things to, like the showOptions() 
method for Cafe, which only has 2 methods that are aimed more at "employees". I ultimately decided to include just the sellCoffee() method in 
addition to the rest of showOptions() inherited from Building so that a user can "buy" a coffee.
Deciding which methods to overload also required some thinking, and for some of the classes like House, I couldn't really see a clear reason
for overloading most of the methods, only the constructor, meanwhile for Cafe it was immediately apparent to me that sellCoffee() and restock()
both should have some overloaded methods to handle coffees with different input.
I was also still a little unsure at what point it was worth it to entirely override a method, even when it was very similar to the parent class and everything except just a small part was the same, as with goToFloor() in the Library class. In the end, I put super.goToFloor() under an if student so that Building's goToFloor() would be used unless the elevator value was set to false, and I'm not sure if this makes sense.

I would advise a student who is working on this assignment to try different ideas and see what feels right to them, and what might feel out of place
with the rest of the program.
