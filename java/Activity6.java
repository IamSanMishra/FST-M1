package activities;

public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		Plane plane = new Plane(10);
		plane.onboard("Sandhya");
		plane.onboard("Santosh");
		plane.onboard("Bandana");
		plane.onboard("Pinki");
		plane.onboard("Ankita");
		plane.onboard("Papaji");
		System.out.println("The take-off time of plane is : "+ plane.takeOff());
		System.out.println("The passengers on board are : \n"+ plane.getPassengers());
		Thread.sleep(5000);
		plane.land();
		System.out.println("The plane landing time is : " + plane.getLastTimeLanded());
		

	}

}
