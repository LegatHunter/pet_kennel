class Pet extends AnimalCommand {
    String name;
    String birthDate;

    public Pet(String name, String birthDate, String[] commands) {
        super(commands);
        this.name = name;
        this.birthDate = birthDate;
    }

    public void displayCommands() {
        System.out.println("Список команд для " + name + ":");
        for (String command : commands) {
            System.out.println(command);
        }
    }

    public void trainCommand(String newCommand) {
        System.out.println(name + " выучил новую команду: " + newCommand);
    }
}
