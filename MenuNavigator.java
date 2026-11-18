package main.java.com.skillbox.addressbook;

import java.util.Scanner;

public class MenuNavigator {
    AddressBook addressBook = new AddressBook();
    Scanner scaner = new Scanner(System.in);

    protected void start() {
        int itemNumber = selectMainMenu();
        switch (itemNumber) {
            case 1:
                newContact();
                start();
            case 2:
                removeContact();
                start();
            case 3:
                printContacts();
                start();
            case 4:
                exit();
            default:
                incorrectOption();
        }
    }

    private void printContacts() {
        System.out.println("Контакты, имеющиеся в адресной книге:\n");
        addressBook.printContacts();
    }

    private void removeContact() {
        System.out.println("Удаление существующего контакта \n" +
                "Введите ID контакта:");
        String deleteId = scaner.nextLine();
        int removeId = matchingInput(deleteId);
        addressBook.removeContact(removeId);
    }

    private void newContact() {
        System.out.println("Новый контакт:\n");
        System.out.println("Введите Ф. И. О. контакта: ");
        String name = scaner.nextLine();
        System.out.println("Должность:");
        String profession = scaner.nextLine();
        System.out.println("Дата рождения: ");
        String dateOfBirth = scaner.nextLine();
        System.out.println("Номер телефона:");
        String phoneNumber = scaner.nextLine();
        System.out.println("Адрес электронной почты:");
        String emailAddress = scaner.nextLine();
        addressBook.updatingOrAdding(name, profession, dateOfBirth,
                phoneNumber, emailAddress);
    }

    private void incorrectOption() {
        System.out.println("Выбрана неверная опция! Попробуйте заново\n");
        start();
    }

    private void exit() {
        System.out.println("Работа программы завершена, ждём вас снова!");
        System.exit(0);
    }

    private int selectMainMenu() {
        String inputMessage = "Адресная книга\n" +
                "1 – новый контакт\n" +
                "2 – удаление существующего контакта\n" +
                "3 – вывод всех контактов\n" +
                "4 – завершение работы\n" +
                "Введите нужную опцию и нажмите Enter [1..4]: ";
        System.out.println(inputMessage);
        String input = scaner.nextLine();
        int numberOption = matchingInput(input);
        if (numberOption == 0 && numberOption > 4) {
            incorrectOption();
        }
        return numberOption;
    }

    private int matchingInput(String strscaner) {
        int input = -1;
        if (strscaner.matches("\\d+")) {
            input = Integer.parseInt(strscaner);
        } else {
            incorrectOption();
        }
        return input;
    }
}
