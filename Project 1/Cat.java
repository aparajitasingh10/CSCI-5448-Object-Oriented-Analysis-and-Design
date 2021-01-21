public  class Cat extends Feline
{
	public Cat(String name) {
		super(name);
	}
	
	//Overrides the function defined in superclass feline

	@Override
	public String makeNoise(){
		return "Meow Meow!!";

	}
	//Overrides the function defined in superclass feline

	@Override
	public void roam(){
		System.out.println("Roam: Cat " + name + " jumps in the air" );

	}

}
