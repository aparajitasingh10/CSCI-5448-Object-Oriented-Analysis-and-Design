public  class Hippo extends Pachyderm
{

	public Hippo(String name){
		super(name);
	}
	//Overrides the function defined in superclass Pachyderm

	@Override
	public String makeNoise(){
		return "Growl Growl";
	}
	@Override

	public void roam(){
		System.out.println("Roam: Hippo " + name + " likes to move it move it");
	}

}