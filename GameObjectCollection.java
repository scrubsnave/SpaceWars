package com.mycompany.a2;

import java.util.Vector;

public class GameObjectCollection implements ICollection{

	private Vector<GameObject> theCollection;
	
	public GameObjectCollection(){
		theCollection = new Vector();
	}
	
	public void add(GameObject newObject) {
		theCollection.addElement(newObject);
	}

	public IIterator getIterator() {
		return new GameObjectIterator();
	}



private class GameObjectIterator implements IIterator{	
	private int currElementIndex;

	public GameObjectIterator(){
		currElementIndex = -1;
	}
	
	public boolean hasNext() {
		if(theCollection.size()<=0) 
			return false;
		if (currElementIndex == theCollection.size() - 1) 
			return false;
		
		return true;
	}

	public GameObject getNext() {
		currElementIndex++;
		return (theCollection.elementAt(currElementIndex));
	}

	public void remove() {
		theCollection.removeElementAt(currElementIndex);
		
	}
	
	public void replace(GameObject newObject){
		theCollection.setElementAt(newObject, currElementIndex);
	}

	}
}



