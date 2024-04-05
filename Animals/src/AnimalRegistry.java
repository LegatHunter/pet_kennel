import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AnimalRegistry {
    private static List<Pet> pets = new ArrayList<>();
    private static int animalCounter = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Список команд животного");
            System.out.println("3. Обучение новой команды");
            System.out.println("4. Вывести список животных по дате рождения");
            System.out.println("5. Вывести количество созданных животных");
            System.out.println("6. Выйти");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addAnimal(scanner);
                    break;
                case 2:
                    displayCommands(scanner);
                    break;
                case 3:
                    trainCommand(scanner);
                    break;
                case 4:
                    displayAnimalsByBirthDate();
                    break;
                case 5:
                    displayAnimalCounter();
                    break;
                case 6:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        } while (choice != 6);
    }

    private static void addAnimal(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения животного: ");
        String birthDate = scanner.nextLine();
        System.out.print("Введите тип животного (собака, кошка, хомяк и т.д.): ");
        String type = scanner.nextLine();
        System.out.print("Введите количество команд, которые может выполнить животное: ");
        int numCommands = scanner.nextInt();
        scanner.nextLine(); // Считывание символа новой строки после ввода числа
        String[] commands = new String[numCommands];
        System.out.println("Введите команды, по одной на строку:");
        for (int i = 0; i < numCommands; i++) {
            commands[i] = scanner.nextLine();
        }
        Pet pet = new Pet(name, birthDate, commands);
        pets.add(pet);
        animalCounter++;
        System.out.println("Животное успешно добавлено в реестр.");
    }

    private static void displayCommands(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Pet pet : pets) {
            if (pet.name.equalsIgnoreCase(name)) {
                pet.displayCommands();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Животное с таким именем не найдено.");
        }
    }

    private static void trainCommand(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Pet pet : pets) {
            if (pet.name.equalsIgnoreCase(name)) {
                System.out.print("Введите новую команду для обучения: ");
                String newCommand = scanner.nextLine();
                pet.trainCommand(newCommand);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Животное с таким именем не найдено.");
        }
    }

    private static void displayAnimalsByBirthDate() {
        System.out.println("Список животных по дате рождения:");
        Map<String, List<Pet>> animalsByBirthDate = new HashMap<>();
        for (Pet pet : pets) {
            if (!animalsByBirthDate.containsKey(pet.birthDate)) {
                animalsByBirthDate.put(pet.birthDate, new ArrayList<>());
            }
            animalsByBirthDate.get(pet.birthDate).add(pet);
        }
        for (String birthDate : animalsByBirthDate.keySet()) {
            System.out.println("Дата рождения: " + birthDate);
            for (Pet pet : animalsByBirthDate.get(birthDate)) {
                System.out.println("Животное: " + pet.name);
            }
        }
    }

    private static void displayAnimalCounter() {
        System.out.println("Общее количество созданных животных: " + animalCounter);
    }
}
