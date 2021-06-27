package activities;

import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(3);
		hs.add(2);
		hs.add(4);
		hs.add(9);
		hs.add(7);
		hs.add(2);
		System.out.println("The current size of the hashset is " + hs.size());
		hs.remove(4);
		if(hs.remove(1))
			System.out.println("1 is removed from the hashset");
		else
			System.out.println("1 is not present in the hashset");
		System.out.println("The number 2 is present in the hashset : " + hs.contains(2));
		System.out.println("Updated hashset :\n" + hs);
		

	}

}
