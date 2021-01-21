Title: OOAD Project 2 - Zoo Management with Strategy and Observer Patterns

Names of team members:

Sowjanya Achar ( soac9071@colorado.edu )

Nivetha Kesavan ( nike9852@colorado.edu )

Aparajita Singh ( apsi2875@colorado.edu )

Language: Python

Environment: Jupyter Notebook

Assumptions:

1. Animals belonging to a subclass say (Pachyderm, Canine, Feline) eat the same food. eat() function is implemented at this level of inheritance.

2. Each animal makes a different noise, override the makenoise() method in the lowest level (cat, dog etc)
 
3. The roam activity is separated from each of the subclasses and created into a strategy (Strategy Pattern)

4. All the animals sleep() and wakeup() in the same way . Method is implemented at the superclass Animal.

5. Zooannouncer class will observe the Zookeeper (Observer Pattern)

Instructions to Run:

Run zooprogram.py
