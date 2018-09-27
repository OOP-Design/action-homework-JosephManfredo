## Exercise \#1
What is the difference between a ```KeyListener``` and a ```KeyAdapter```?
KeyAdpater is an abstract class made for convience in creating listener objects for keyboard events. The KeyListener is the actual listener interface for keyboard events.

## Exercise \#2
What is the difference between a ```MouseListener``` and a ```MouseMotionListener```.
The MouseListener only acts when a button on the mouse is pressed, but the MouseMotionListener acts when the mouse cursor is moved.

## Exercise \#3
Given a ```MouseEvent```, Java has the ```getButton``` and ```getModifiersEx``` methods for determining which mouse buttons are pressed. Are both methods really needed, that is, do they differ in any way?
Both methods are needed because getModifiersEx gathers what modal buttons are pressed along with the ones on the mouse, while getButton just gets what button was pressed on the mouse.

## Exercise \#4
What is meant by an event source, event listener, and event object?
An event source  is an object that produces an event, an event listener is an object that is notified when an event occurs, and an event object is the event itself.

## Exercise \#5
What is the purpose of an anonymous inner class? What would one use an anonymous inner class for?
Anonymouse inner classes are used to write the implementation behind in listener interfaces. Since inner class can only make one instance of an object, they can be used to make an object that needs extra implementation. Inner classes can be used in order to prevent the need of a subclass for just one special object.
