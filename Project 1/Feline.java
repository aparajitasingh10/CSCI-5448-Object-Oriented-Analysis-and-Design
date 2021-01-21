public abstract class Feline extends Animal
{
	// Calls the superclass constructor
	public Feline(String name) {
		super(name);
	}

	@Override
	public void eat() {
		System.out.println("Eat: Feline " + name + " eats");
	}

	@Override
	public void roam() {
		System.out.println("Roam: Feline " + name + " roams");
	}

}