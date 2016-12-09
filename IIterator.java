package com.mycompany.a4;

public interface IIterator {
	boolean hasNext();
	GameObject getNext();
	void remove();
	void replace(GameObject newObject);
	int getSize();
	GameObject getCurrent();
}
