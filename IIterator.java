package com.mycompany.a3;

public interface IIterator {

	boolean hasNext();
	GameObject getNext();
	void remove();
	void replace(GameObject newObject);
	int getSize();
}
