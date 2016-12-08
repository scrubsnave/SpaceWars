package com.mycompany.a2;

import java.util.Iterator;

public interface ICollection {
	void add(GameObject newObject);
	IIterator getIterator();
}
