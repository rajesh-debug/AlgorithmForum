package com.algorithmforum.cci.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

abstract class Animal {

	private String name;
	private int order;

	public Animal(String name) {
		this.name = name;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	/**
	 * Inserting the element with Order and incrementing the order by one for every new element.
	 * Latest element will maintain the largest value of the Order.
	 *
	 * @param animal
	 * @return boolean value
	 */
	public boolean isOlderThan(Animal animal) {
		return this.order < animal.getOrder();
	}
}

class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Dog Name: " + this.getName();
	}
}

class Cat extends Animal {
	public Cat(String name) {
		super(name);
	}
	@Override
	public String toString() {
		return "Cat Name: " + this.getName();
	}
}

/**
 * A clean and efficient approach to maintain separate queues for dogs and cats,
 * and to place them within a wrapper class called An AnimalShelterStack.
 *
 * We then store some sort of time stamp(insertion order) to mark when each
 * animal was enqueued.
 * When we call dequeueAny, will return the oldest of the tops of both the dog
 * and cat queue.
 * @author rajesh.kumar
 * @since Aug 13, 2018 11:22:56 AM
 */

public class AnimalShelterQueue {

	private Queue<Dog> dogs;
	private Queue<Cat> cats;
	private int order;

	public AnimalShelterQueue() {
		this.order = 0;
		this.dogs = new LinkedList<>();
		this.cats = new LinkedList<>();
	}

	/**
	 * dequeueAny cases:
	 * #1: if both stack are empty, throw exception as no Animal will found.
	 * #2: if dogs stack are empty, return top from the cats stack.
	 * #3: if cats stack are empty, return top from the dogs stack.
	 * #4: if cats & dogs contains element, return older of top of both stack.
	 * @return
	 */

	public Animal dequeueAny() {

		System.out.println("------------------dequeueAny------------------");

		if (dogs.isEmpty() && cats.isEmpty()) {
			throw new EmptyStackException();
		} else if (dogs.isEmpty()) {
			return dequeueCat();
		} else if (cats.isEmpty()) {
			return dequeueDog();
		}

		/**
		 * Look at top of dog and cat queues, and pop the queue with the oldest value.
		 */
		Animal dog = dogs.peek();
		Animal cat = cats.peek();
		boolean isDog = dog.isOlderThan(cat);

		if (isDog) {
			return dequeueDog();
		} else {
			return dequeueCat();
		}
	}

	/**
	 * Check the type of Animal instance and insert in respective 'stack'.
	 * @param animal
	 * @return boolean
	 */
	public boolean enqueue(Animal animal) {

		/**
		 * order is used as a sort of time stamp.
		 * It can be used to compare the insertion order of a dog to a cat.
		 **/
		animal.setOrder(order++);

		if (animal instanceof Cat) {
			return cats.add((Cat) animal);
		} else {
			return dogs.add((Dog) animal);
		}
	}

	/**
	 * Return the top of dogs Queue.
	 * @return animal
	 */
	public Animal dequeueDog() {
		System.out.println("------------------dequeueDog------------------");
		return dogs.poll();
	}

	/**
	 * Return the top of cats Queue.
	 * @return animal
	 */
	public Animal dequeueCat() {
		System.out.println("------------------dequeueCat------------------");
		return cats.poll();
	}

	/**
	 * Test the queue.
	 * @param args
	 */
	public static void main(String[] args) {

		AnimalShelterQueue queue = new AnimalShelterQueue();
		queue.enqueue(new Dog("dog1"));
		queue.enqueue(new Cat("cat1"));
		queue.enqueue(new Cat("cat2"));
		queue.enqueue(new Dog("dog2"));
		queue.enqueue(new Cat("cat2"));
		queue.enqueue(new Dog("dog3"));

		// Should print 'cat1' as it was first cat entered in Shelter.
		System.out.println(queue.dequeueCat());

		// Should print dog1 as it was first animal entered in Shelter.
		System.out.println(queue.dequeueAny());

		// Should print cat1 as it is only cat in the Shelter.
		System.out.println(queue.dequeueDog());
	}
}