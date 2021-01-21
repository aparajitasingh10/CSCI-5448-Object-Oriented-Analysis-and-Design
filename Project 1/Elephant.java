public class Elephant extends Pachyderm{

	public Elephant(String name) {
		super(name);
	}

	//Overrides the function defined in superclass Pachyderm

	@Override
	public String makeNoise(){
		return "Trumpet Trumpet!!";
	}

	@Override
	public void roam(){
		System.out.println("Roam: Elephant " + name + " does power yoga");
	}

}
