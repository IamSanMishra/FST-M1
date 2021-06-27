package activities;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		HashMap<Integer,String> colours = new HashMap<Integer,String>();
		colours.put(0, "Red");
		colours.put(1, "Green");
		colours.put(2, "Yellow");
		colours.put(3, "Blue");
		colours.put(4, "Black");
		System.out.println("The present Map : \n" + colours);
		String removed = colours.remove(3);
		System.out.println(removed + " was removed from the map");
		System.out.println("Is Green colour present in the map :" + colours.containsValue("Green"));
		System.out.println("The current size of the map is "+ colours.size());

	}

}
