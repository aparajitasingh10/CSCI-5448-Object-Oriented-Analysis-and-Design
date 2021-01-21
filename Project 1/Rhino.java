public  class Rhino extends Pachyderm
{


	public Rhino(String name) {
		super(name);
	}

	//Overrides the function defined in superclass Pachyderm

	@Override
	public String makeNoise(){
		return "Bellow Bellow!!";
	}

	@Override
	public void roam(){
		System.out.println("Roam: Rhino " + name + "  dances in the pool");
	}
}
