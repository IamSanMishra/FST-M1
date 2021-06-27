package activities;

public class Bicycle implements BicycleParts, BicycleOperations{
	int gears;
	int currentSpeed;
	
	public Bicycle(int gears, int currentSpeed) {
		this.gears = gears;
		this.currentSpeed = currentSpeed;
	}

	@Override
	public void applyBrake(int decrement) {
		currentSpeed = currentSpeed - decrement;
		System.out.println("Current Speed : "+ currentSpeed);
	}

	@Override
	public void speedUp(int increment) {
		currentSpeed = currentSpeed + increment;
		System.out.println("Current Speed : "+ currentSpeed);
		
	}
	
	public String bicycleDesc() {
	    return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
	}
	
	

}
