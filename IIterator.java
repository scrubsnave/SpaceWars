package com.mycompany.a2;

public interface IIterator {

	boolean hasNext();
	GameObject getNext();
	void remove();
	void replace(GameObject newObject);
}
