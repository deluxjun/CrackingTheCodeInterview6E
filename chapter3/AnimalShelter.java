package chapter3;

import java.util.LinkedList;

public class AnimalShelter {

  public class Animal {
    int order = 0;

    public void setOrder(int order) {
      this.order = order;
    }

    public int getOrder() {
      return order;
    }
  }

  public class Dog extends Animal {

  }

  public class Cat extends Animal {

  }

  private LinkedList<Dog> dogs = new LinkedList<>();
  private LinkedList<Cat> cats = new LinkedList<>();
  private int order = 0;

  public void enqueue(Animal ani) {
    ani.setOrder(this.order++);

    if (ani instanceof Dog)
      dogs.add((Dog) ani);
    else if (ani instanceof Cat)
      cats.add((Cat) ani);
    else
      throw new RuntimeException("Not supported type");
  }

  public Animal dequeueAny() {
    Animal dog = dogs.peek();
    Animal cat = cats.peek();

    if (cat == null)
      return dequeueDog();
    if (dog == null)
      return dequeueCat();

    if (cat.getOrder() > dog.getOrder()) {
      return dog;
    } else {
      return cat;
    }

  }

  public Animal dequeueDog() {
    return dogs.poll();

  }

  public Animal dequeueCat() {
    return cats.poll();
  }

  public static void main(String[] args) {
  }
}
