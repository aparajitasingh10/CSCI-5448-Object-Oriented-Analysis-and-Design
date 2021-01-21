import java.util.List;
import java.util.Random;

public class Zookeeper {

	String[] tasks = {"wakeUpAnimals", "rollCallAnimals", "feedAnimals", "exerciseAnimals","shutDownZoo"};


	public void performTasks(List<Animal> animals) {
		// Perform each of the tasks for all the animals sequentially
		for (String task : tasks) {

			callTasks(task,animals);
		}


	}


	public void callTasks(String task,List<Animal> animals) {
		String t;
		for (Animal a : animals) {
			// If the animal is cat, set the task to a random task
			if(a instanceof Cat)
			{	
				t = (tasks[new Random().nextInt(tasks.length)]);
				
			}
			else {
				t = task;
			}
			
			
			// Perform tasks for each animal
			switch (t) {
			case "wakeUpAnimals":
				a.wakeUp();
				break;
			case "rollCallAnimals":
				a.speak();
				break;
			case "feedAnimals":
				a.eat();
				break;
			case "exerciseAnimals":
				a.roam();
				break;
			case "shutDownZoo":
				a.sleep();
				break;
			default:
				System.out.println("Invalid task assigned to the zookeeper.");
				break;
			}
		}
	}
}




