package com.algorithmforum.collection;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

	private static class Developer {
		private String name;
		private int priority;

		Developer(String name, int priority) {
			this.name = name;
			this.priority = priority;
		}

		public String getName() {
			return name;
		}

		public int getPriority() {
			return priority;
		}

	}

	public static void main(String[] args) {
		Developer dev1 = new Developer("John", 4);
		Developer dev2 = new Developer("Kabeer", 3);
		Developer dev3 = new Developer("Michel", 2);

		Comparator<Developer> priorityCmtr = (Developer o1, Developer o2) -> o1.getPriority() - o2.getPriority();

		PriorityQueue<Developer> priorityQueue = new PriorityQueue<Developer>(4, priorityCmtr);

		priorityQueue.add(dev1);
		priorityQueue.add(dev2);
		priorityQueue.add(dev3);

		// First element was pushes John.
		// But, we are displaying the Michel as she has highest priority.
		System.out.println(priorityQueue.poll().getName());

	}
}