package activities;

import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("Gir");
		myList.add("Kankrej");
		myList.add("Holstien");
		myList.add("Sahiwal");
		myList.add("Sindhi"); 
		
		for(String x : myList) {
			System.out.println(x);
		}
		
		System.out.println("The third name in the list is : "+ myList.get(2));
		System.out.println("Is Friesian in the list : " + myList.contains("Friesian"));
		System.out.println("The number of types of cow breed in the list is "+myList.size());
		
		String removed = myList.remove(2);
		System.out.println(removed + " was removed and now the number is " + myList.size());
		

	}

}
