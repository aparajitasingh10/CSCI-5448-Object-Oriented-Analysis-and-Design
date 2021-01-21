import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class AnimalDemo {
	//	Variable to hold the list of all animals

	static List<Animal> animals = new ArrayList<>();

	// Create zoo animals and add to the animal list
	public static void createAnimals() {
		animals.add(new Hippo("Hunk"));
		animals.add(new Hippo("Hero"));

		animals.add(new Elephant("Elliot"));
		animals.add(new Elephant("Eldo"));

		animals.add(new Rhino("Riley"));
		animals.add(new Rhino("Rach"));

		animals.add(new Tiger("Titan"));
		animals.add(new Tiger("Tim"));

		animals.add(new Lion("Lufasa"));
		animals.add(new Lion("Lindor"));

		animals.add(new Cat("Chip"));
		animals.add(new Cat("Choco"));

		animals.add(new Wolf("Whyte"));
		animals.add(new Wolf("Warren"));

		animals.add(new Dog("Dum"));
		animals.add(new Dog("Dazz"));


	}


	public static void main(String[] args) throws FileNotFoundException{
		Zookeeper zookeeper = new Zookeeper();
		//       https://www.geeksforgeeks.org/redirecting-system-out-println-output-to-a-file-in-java/
		//       Reference to print to a file
		System.setOut(new PrintStream(new File("./dayatthezoo3.out")));


		createAnimals();

		System.out.println("-----Zoo full of Animals------\n\n"); 

		System.out.println("---------Zoo Opened----------");

		zookeeper.performTasks(animals);

		System.out.println("Zoo Closed\n");
	}
}


