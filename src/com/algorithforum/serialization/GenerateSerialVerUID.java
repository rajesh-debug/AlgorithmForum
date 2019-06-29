package com.algorithforum.serialization;

import java.io.ObjectStreamClass;
import java.io.Serializable;

class GenerateSerialVerUID implements Serializable {
	
	//private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		ObjectStreamClass osc = ObjectStreamClass.lookup(GenerateSerialVerUID.class);
		long serialID = osc.getSerialVersionUID();

		System.out.println(serialID);
	}
}
