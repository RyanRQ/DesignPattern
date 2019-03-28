import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

interface Animal {
    void eat();
}

class Cat implements Animal {

    @Override
    public void eat() {
        System.out.println("我吃鱼");
    }
}

class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("我吃骨头");
    }
}

class AnimalFactory {
    enum Animals {
        CAT, DOG
    }

    static Animal getAnimal(Animals animals) {
        Animal animal = null;
        switch (animals) {
            case CAT:
                animal = new Cat();
                break;
            case DOG:
                animal = new Dog();
                break;
        }
        return animal;
    }
}

/**
 * 简单工厂模式
 */
class SimpleFactoryPattern {
    public static void main(String[] args) {
        AnimalFactory.getAnimal(AnimalFactory.Animals.CAT).eat();
        AnimalFactory.getAnimal(AnimalFactory.Animals.DOG).eat();
    }
}

interface Fruit {
    void type();
}

class Fish implements Fruit {

    @Override
    public void type() {
        System.out.println("生产鱼");
    }
}

class Bone implements Fruit {

    @Override
    public void type() {
        System.out.println("生产骨头");
    }
}

interface AbstractFactory {
    Animal getAnimal();

    Fruit getFruit();
}

class CNFactory implements AbstractFactory {

    @Override
    public Animal getAnimal() {
        return new Dog();
    }

    @Override
    public Fruit getFruit() {
        return new Bone();
    }
}

class USFactory implements AbstractFactory {

    @Override
    public Animal getAnimal() {
        return new Cat();
    }

    @Override
    public Fruit getFruit() {
        return new Fish();
    }
}

class CountryFactory {
    enum Country {
        CN, US
    }

    public static AbstractFactory getFactory(Country country) {
        AbstractFactory factory = null;
        switch (country) {
            case CN:
                factory = new CNFactory();
                break;
            case US:
                factory = new USFactory();
                break;

        }
        return factory;
    }
}

/**
 * 抽象工厂
 */
class AbstractFactoryPattern {
    public static void main(String[] args) {
        CountryFactory.getFactory(CountryFactory.Country.CN).getAnimal().eat();
        CountryFactory.getFactory(CountryFactory.Country.CN).getFruit().type();
        CountryFactory.getFactory(CountryFactory.Country.US).getAnimal().eat();
        CountryFactory.getFactory(CountryFactory.Country.US).getFruit().type();
    }
}
