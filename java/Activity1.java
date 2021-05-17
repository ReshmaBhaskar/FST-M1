package activities;

public class Activity1{
	
public static void main(String[] args)
{

	Car Hyundai = new Car(); //create an object of the class
	
	Hyundai.make = 2014;
	Hyundai.color = "Black";
	Hyundai.transmission = "Manual";
	
	Hyundai.displayCharacteristics();
	Hyundai.accelarate();
	Hyundai.brake();
	
	
}
}