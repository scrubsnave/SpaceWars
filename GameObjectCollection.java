package com.mycompany.a4;

import java.util.Vector;

public class GameObjectCollection implements ICollection{
	private Vector<GameObject> theCollection;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GameObjectCollection(){theCollection = new Vector();}
	
	public void add(GameObject newObject) {theCollection.addElement(newObject);}

	public IIterator getIterator() {return new GameObjectIterator();}
	
	public int getSize() {return theCollection.size();}

	private class GameObjectIterator implements IIterator{
		private int currElementIndex;

		public GameObjectIterator(){currElementIndex = -1;}
	
		public boolean hasNext() {
			if(theCollection.size()<=0){return false;}
			if (currElementIndex == theCollection.size() - 1){return false;}		
			return true;
		}

		public GameObject getNext() {return (theCollection.elementAt(++currElementIndex));}
	
		public GameObject getCurrent() {return(theCollection.elementAt(currElementIndex));}

		public void remove() {theCollection.removeElementAt(currElementIndex);}
	
		public void replace(GameObject newObject){theCollection.setElementAt(newObject, currElementIndex);}

		public int getSize() {return theCollection.size();}
	}
}



