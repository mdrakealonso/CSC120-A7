- Methods I decided to `overload`, and why:
For the Library class: 
- Created an additional constructor with an empty collection by default to give the option of initially not creating a collection for a new Library
- Created an additional addTitle method with new parameter isAvailable to give the option to set a title as not available upon adding it to the collection
For the House class: 
- Created an additional constructor with hasElevator set to false, hasDiningRoom set to true, and an empty ArrayList of residents, giving the option to create a basic house
- Created an additional moveIn method that allows multiple residents to move in at once in the case that there is a list of residents to move in (so as to avoid using the same method many times)
For the Cafe class:
- Created an additional constructor with a default amount of each item in the inventory to give the option of not setting each amount upon creating a Cafe
- Created an additional restock method to restock a Cafe's inventory with default amounts of each item to avoid having to decide how much to restock each time
- Created an additional sellCoffee method with default amounts of each ingredient to avoid having to give amounts of each item each time

- What worked, what didn't, what advice would you give someone taking this course in the future?
Now that I've finished, this assignment makes more sense to me, but in the beginning I found it a bit challenging to override the methods, mostly in terms of deciding what changes were required for each subclass. I would suggest that others consider how the actions of the parent class differ from those of the subclass, and how each of the subclasses differ from the one another. I also had a bit of trouble deciding what methods to overload. In this case, I would recommend that others think about what parameters they wish any given method had, and ways in which they might make using a method or a constructor simpler or more effective. I also wanted to do the optional part of this assignment but it was a bit trickier than I intially expected! I may keep working on it, however.
