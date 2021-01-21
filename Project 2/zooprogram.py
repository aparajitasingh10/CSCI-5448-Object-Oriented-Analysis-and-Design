import random
import sys
from abc import abstractmethod
import abc

# The roam activity is separated from each of the subclasses and created into a strategy
class RoamStrategy():
    @abstractmethod
    def roam(self):
        pass

# This is walk strategy
class WalkStrategy(RoamStrategy): 
    def roam(self):
        print("walks")

# This is dance strategy
class DanceStrategy(RoamStrategy):   
    def roam(self):
        print("dances")

# This is swim strategy
class SwimStrategy(RoamStrategy):
    def roam(self):
        print("swims")
    
    
class Animal():

    roamstrat = None
    
    # set roam strategy
    
    def set_roam_strategy(self,roamstrat):
        self.roamstrat = roamstrat

    def __init__(self, name):
        self.name = name

        #default roam strategy
        self.roamstrat = WalkStrategy()
    
    def wakeUp(self):
        print("Wake: Animal " + self.name + " wakes up!")

    def eat(self):
        print("Eat: Animal " + self.name + " eats")

    def speak(self):
        print("MakeNoise: " + self.name + " says " + self.makeNoise())

    def sleep(self):
        print("Sleep: Animal " + self.name + " sleeps")

    def makeNoise(self):
        return " "

    def roam(self): 
        print("Animal " + self.name + ":" )
        self.roamstrat.roam()

        
class Canine(Animal):

    def __init__(self, name):
        super().__init__(name)

    def eat(self):
        print("Eat: Canine " + self.name + " eats meat")



class Feline(Animal):
    def __init__(self, name):
        super().__init__(name)

    def eat(self):
        print("Eat: Feline " + self.name + " eats")

class Pachyderm(Animal):

    def eat(self):
        print("Eat: Pachyderm  " + self.name + "  eats")


class Elephant(Pachyderm):

    def __init__(self, name):
        super().__init__(name)

    def makeNoise(self):
        return "Trumpet Trumpet!!"

class Hippo(Pachyderm):

    def __init__(self, name):
        super().__init__(name)

    def makeNoise(self):
        return "Growl Growl"


class Rhino(Pachyderm):

    def __init__(self, name):
        super().__init__(name)

    def makeNoise(self):
        return "Bellow Bellow!!"

class Lion(Feline):

    def __init__(self, name):
        super().__init__(name)

    def makeNoise(self):
        return "Roar Roar!!"


class Cat(Feline):

    def __init__(self, name):
        super().__init__(name)

    def makeNoise(self):
        return "Meow Meow!!";

class Tiger(Feline):

    def __init__(self, name):
        super().__init__(name)

    def makeNoise(self):
        return "Snarl Snarl!!"



class Wolf(Canine):

    def __init__(self, name):
        super().__init__(name)

    def makeNoise(self):
        return "Hey there, Little Red Riding Hood!";


class Dog(Canine):

    def __init__(self, name):
        super().__init__(name)

    def makeNoise(self):
        return "Woof Woof!!"
    
    
# observer pattern
class Observer:
    def update(self, action):
    raise NotImplementedError


class Subject:
    def add(self, observer):
        raise NotImplementedError

    def remove(self, observer):
        raise NotImplementedError

    def notify(self, msg):
        raise NotImplementedError


class ZooAnnouncer(Observer):
    def update(self, action):
        if action == "wakeUpAnimals":
            print("************Zoo Keeper is waking up the animals***************")
        elif action == "rollCallAnimals":
            print("***********Animals are being roll called by the Zoo Keeper***********")
        elif action == "feedAnimals":
            print("**************Zoo Keeper is feeding the animals****************")
        elif action == "exerciseAnimals":
            print("***************Animals are told to exercise************")
        elif action == "shutDownZoo":
            print("***************Zoo Keeper is shutting down the zoo************")


class ZooKeeper(Subject):
    tasks = ["wakeUpAnimals", "rollCallAnimals", "feedAnimals", "exerciseAnimals", "shutDownZoo"]

    def __init__(self):
        self.observers = []

        sys.stdout = open('dayatthezoo_strategyobserver.txt', 'wt')
        print("-----Zoo full of Animals------")
        print("---------Zoo Opened----------")

        animals = [Hippo("Hunk"), Hippo("Hero"), Elephant("Elliot"), Elephant("Eldo"), Rhino("Riley"),
                   Rhino("Rach"), Tiger("Titan"), Tiger("Tim"), Lion("Lufasa"), Lion("Lindor"), Cat("Chip"),
                   Cat("Choco"), Wolf("Whyte"), Wolf("Warren"), Dog("Dum"), Dog("Dazz")]

        self.performTasks(animals)
        #DogRoam("Hunk")
        print("Zoo Closed")

    def add(self, observer):
        if observer not in self.observers:
            self.observers.append(observer)
        else:
            print('Failed to add: {}'.format(observer))

    def remove(self, observer):
        try:
            self.observers.remove(observer)
        except ValueError:
            print('Failed to remove: {}'.format(observer))

    def notify(self, msg):
        [observer.update(msg) for observer in self.observers]

    def performTasks(self, animals):

        for task in self.tasks:
            self.callTasks(task, animals)

    def callTasks(self, task, animals):
        announcement = []
        for a in animals:
            # If the animal is cat, set the task to a random task
            if isinstance(a, Cat):
                t = random.choice(self.tasks)
            else:
                t = task
                if t not in announcement:
                    self.notify(t)
                    announcement.append(t)
                    #print("$$$$$$$$$$$$$$$$$$", announcement, "$$$$$$$$$$$$$$$$$$$")
            if t == "wakeUpAnimals":
                a.wakeUp()
            elif t == "rollCallAnimals":
                a.speak()
            elif t == "feedAnimals":
                a.eat()
            elif t == "exerciseAnimals":
                a.roam()
            elif t == "shutDownZoo":
                a.sleep()

            else:
                print("Invalid task assigned to the zookeeper.")


# Referred https://hub.packtpub.com/python-design-patterns-depth-observer-pattern/ for observer pattern
# https://stackoverflow.com/questions/963965/how-to-write-strategy-pattern-in-python-differently-than-example-in-wikipedia

if __name__ == '__main__':
    zk = ZooKeeper()
    za = ZooAnnouncer()
    zk.add(za)

