public class AnimalFactory implements AbstractFactory<Animal> {

  public static void main(String[] args) {

    Animal dog = new Dog();
    System.out.println(dog.getAnimal());
    System.out.println(dog.makeSound());

    Animal duck = new Duck();
    System.out.println(duck.getAnimal());
    System.out.println(duck.makeSound());
  }

  @Override
  public Animal create(String animalType) {
    if ("Dog".equalsIgnoreCase(animalType)) {
      return new Dog();
    } else if ("Duck".equalsIgnoreCase(animalType)) {
      return new Duck();
    }

    return null;
  }

}

interface AbstractFactory<T> {

  T create(String animalType);
}

interface Animal {

  String getAnimal();

  String makeSound();
}

class Duck implements Animal {

  @Override
  public String getAnimal() {
    return "Duck";
  }

  @Override
  public String makeSound() {
    return "Kwak";
  }
}

class Dog implements Animal {

  @Override
  public String getAnimal() {
    return "Dog";
  }

  @Override
  public String makeSound() {
    return "Woof";
  }
}