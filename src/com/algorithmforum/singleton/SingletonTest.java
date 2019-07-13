package com.algorithmforum.singleton;

//Java code to explain effect of Serilization on singleton classes 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonTest {

	private static class Singleton implements Serializable {

		private static final long serialVersionUID = 1L;

		// public instance initialized when loading the class
		private static Singleton instance = new Singleton();

		private Singleton() {
			// private constructor
		}

		public static Singleton getInstance() {
			return instance;
		}

		// implement readResolve method
		protected Object readResolve() {
			return instance;
		}

	}

	public static void main(String[] args) {
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
				ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));) {

			Singleton instance1 = Singleton.getInstance();
			out.writeObject(instance1);

			// deserailize from file to object
			Singleton instance2 = (Singleton) in.readObject();

			System.out.println("instance1 hashCode:- " + instance1.hashCode());
			System.out.println("instance2 hashCode:- " + instance2.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
