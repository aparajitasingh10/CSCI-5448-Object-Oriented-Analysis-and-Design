public abstract class Canine extends Animal
{

	public Canine(String name) {
		super(name);
	}


	@Override
	public void eat() {
		System.out.println("Eat: Canine " + this.name + " eats meat");
	}

	@Override
	public void roam() {
		System.out.println("Roam: Canine " + this.name + " roams");
	}
}