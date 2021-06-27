package activities;

public class Activity2 {

	public static void main(String[] args) {
		int sum = 0;
		int[] array = {10, 77, 10, 54, -11, 10};
		for (int x : array) {
			if(x == 10) {
				sum = sum + 10;
			}				
		}
		
		if (sum==30) {
			System.out.println("The sum of all the 10's in array is equal to 30");
		} else {
			System.out.println("The sum of all the 10's in array is not equal to 30");
		}

	}

}
