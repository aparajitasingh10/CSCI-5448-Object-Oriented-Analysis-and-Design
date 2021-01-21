public  class Tiger extends Feline
{
	public Tiger(String name) {
		super(name);
	}
	//Overrides the function defined in superclass feline

	@Override
	public String makeNoise(){
		return "Snarl Snarl!!";
	}

	@Override
	public void roam(){
		System.out.println("Roam: Tigeress " + name + " trains from Master Shifu");
	}
}

