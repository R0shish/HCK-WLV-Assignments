package Week4_Tutorial.Upcasting;

class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println(name + " Eats!");
    }
}

class Hervibores extends Animal {
    public Hervibores(String name) {
        super(name);
    }

    @Override
    void eat() {
        System.out.println(name + " is a hervibores that eat plants!");
    }
}

class Omnivores extends Animal {
    public Omnivores(String name) {
        super(name);
    }

    @Override
    void eat() {
        System.out.println(name + " is a omnivores that eat plants and meat!");
    }
}

class Carnivores extends Animal {
    public Carnivores(String name) {
        super(name);
    }

    @Override
    void eat() {
        System.out.println(name + " is a carnivores that eat meat!");
    }
}

class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Animal");
        Animal cow = new Hervibores("Cow");
        Animal human = new Omnivores("Human");
        Animal tiger = new Carnivores("Tiger");
        animal.eat();
        cow.eat();
        human.eat();
        tiger.eat();
    }
}