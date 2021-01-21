public  class Wolf extends Canine
{
	public Wolf(String name) {
		super(name);
	}
	//Overrides the function defined in superclass canine

	@Override
	public String makeNoise(){
		return "Hey there, Little Red Riding Hood!";
	}

	@Override
	public void roam(){
		System.out.println("Roam: Wolf " + this.name + " does Cardio");
	}
}

