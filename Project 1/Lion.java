public class Lion extends Feline
{
	public Lion(String name) {
		super(name);
	}
	//Overrides the function defined in superclass feline

	@Override
	public String makeNoise(){
		return "Roar Roar!!";
	}

	@Override
	public void roam(){
		System.out.println("Roam: Lion " + name + " explores everything the light touches");
	}

}


