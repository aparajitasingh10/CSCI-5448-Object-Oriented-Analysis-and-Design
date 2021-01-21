public class Dog extends Canine
{
	public Dog(String name) {
		super(name);
	}
	//Overrides the function defined in superclass Canine

	@Override
	public String makeNoise(){
		return "Woof Woof!!";
	}

	@Override
	public void roam(){
		System.out.println("Roam: Dog " + this.name + " sploots cutely");
	}

}

