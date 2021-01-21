
public abstract class Pachyderm extends Animal
{
	// call super class constructor
	public Pachyderm(String name) {
		super(name);
	}
	@Override
	public void eat() {
		System.out.println("Eat: Pachyderm  " + name + "  eats");
	}

	@Override
	public void roam() {
		System.out.println("Roam: Pachyderm " + name + " roams");
	}
}


