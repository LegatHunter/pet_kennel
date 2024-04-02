import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AnimalRegistry {
    private List<Animal> animals;

    public AnimalRegistry() {
        animals = new ArrayList<>();
        loadAnimals();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println("Животное добавлено");
    }

    public void listCommands(Animal animal) {
        System.out.println("Команда для " + animal.name + ": " + animal.commands);
    }

    public void teachCommand(Animal animal, String newCommand) {
        animal.commands += ", " + newCommand;
        System.out.println("Новая команда добавлена для " + animal.name);
    }

    public void listAnimalsByBirthDate() {
        System.out.println("Список животных, отсортированных по дате рождения:");
        for (Animal animal : animals) {
            System.out.println(animal.name + " - " + animal.birthDate);
        }
    }
    private void loadAnimals() {
        Animal rex = new Animal("Собака", "Собака", "2020-01-01", "Сидеть, Стоять, Принеси");
        Animal wiskas = new Animal("Кошка", "Кошка", "2019-05-15", "Сидеть, Царапать");
        Animal hurma = new Animal("Хомяк", "Хомяк", "2021-03-10", "Труп, Прятаться");

        addAnimal(rex);
        addAnimal(wiskas);
        addAnimal(hurma);
    }
    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nЖивотное меню :-):");
            System.out.println("1. Добавить животное");
            System.out.println("2. Список команд для животного");
            System.out.println("3. Научите животное новой команде");
            System.out.println("4. Перечислите животных по дате рождения");
            System.out.println("5. Выход");

            System.out.print("\nВведите свой выбор: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Введите имя животного: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите тип животного: ");
                    String type = scanner.nextLine();
                    System.out.print("Введите дату рождения животного (YYYY-MM-DD): ");
                    String birthDate = scanner.nextLine();
                    System.out.print("Введите команды, разделенные запятыми: ");
                    String commands = scanner.nextLine();
                    Animal newAnimal = new Animal(name, type, birthDate, commands);
                    registry.addAnimal(newAnimal);
                    break;
                case 2:
                    System.out.print("Введите имя животного: ");
                    String animalName = scanner.nextLine();
                    for (Animal animal : registry.animals) {
                        if (animal.name.equalsIgnoreCase(animalName)) {
                            registry.listCommands(animal);
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Введите имя животного: ");
                    String animalName2 = scanner.nextLine();
                    for (Animal animal : registry.animals) {
                        if (animal.name.equalsIgnoreCase(animalName2)) {
                            System.out.print("Введите новую команду: ");
                            String newCommand = scanner.nextLine();
                            registry.teachCommand(animal, newCommand);
                            break;
                        }
                    }
                    break;
                case 4:
                    registry.listAnimalsByBirthDate();
                    break;
                case 5:
                    System.out.println("Выход...");
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Пожалуйста, введите число от 1 до 5.");
            }
        }
    }
}
