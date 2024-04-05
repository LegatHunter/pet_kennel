class AnimalCommand {
    String[] commands;

    public AnimalCommand(String[] commands) {
        this.commands = commands;
    }
}

class Pet extends AnimalCommand {
    String name;
    String birthDate;

    public Pet(String name, String birthDate, String[] commands) {
        super(commands);
        this.name = name;
        this.birthDate = birthDate;
    }
}

class Dog extends Pet {
    public Dog(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
}

class Cat extends Pet {
    public Cat(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
}

class Hamster extends Pet {
    public Hamster(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
}

class PackAnimal extends AnimalCommand {
    String name;
    String birthDate;


    public PackAnimal(String name, String birthDate, String[] commands) {
        super(commands);
        this.name = name;
        this.birthDate = birthDate;
    }
}

class Horse extends PackAnimal {
    public Horse(String name, String birthDate, String load, String[] commands) {
        super(name, birthDate, commands);
    }
}

class Camel extends PackAnimal {
    public Camel(String name, String birthDate, String load, String[] commands) {
        super(name, birthDate, commands);
    }
}

class Donkey extends PackAnimal {
    public Donkey(String name, String birthDate, String load, String[] commands) {
        super(name, birthDate, commands);
    }
}
