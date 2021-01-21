
public abstract class Animal{

	protected String name;

	//	 Constructor to set name
	public Animal(String name) {
		this.name = name;
	}
	
	public void wakeUp() {
		System.out.println("Wake: Animal " + this.name + " wakes up!");
	}

	public void eat() {
		System.out.println("Eat: Animal " + this.name + " eats");
	}

	public void speak() {
		System.out.println("MakeNoise: " + this.name +  " says "  + makeNoise());
	}

	public void sleep() {
		System.out.println("Sleep: Animal " + this.name + " sleeps");
	}

	public String makeNoise() {
		return " ";
	}
//	This implemented by subclasses
	public abstract void roam();
}


