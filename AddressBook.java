package main.java.com.skillbox.addressbook;

public class AddressBook {
    private Contact[] contacts = new Contact[100];

    public AddressBook() {
    }

    @Override
    public String toString() {
        printContacts();
        return "";
    }

    protected void updatingOrAdding(String name, String profession, String dateOfBirth,
                                    String phoneNumber, String emailAddress) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                String nameUp = name.toLowerCase().strip();
                String getName = contacts[i].getName().toLowerCase().strip();
                if (getName.equals(nameUp)) {
                    System.out.println("Пользователь " + name + " уже присутствует в списке" +
                            " контактов, он будет обновлён в соответствии с новыми данными\n");
                    updateContact(i, name, profession, dateOfBirth,
                            phoneNumber, emailAddress);
                    break;
                }
            } else {
                addContact(i, name, profession, dateOfBirth,
                        phoneNumber, emailAddress);
                break;
            }
        }
    }

    private void addContact(int id, String name, String profession, String dateOfBirth,
                            String phoneNumber, String emailAddress) {
        contacts[id] = new Contact(name, profession, dateOfBirth,
                phoneNumber, emailAddress);
        System.out.println("Новый контакт добавлен\n");
    }

    private void updateContact(int id, String name, String profession, String dateOfBirth,
                               String phoneNumber, String emailAddress) {
        contacts[id].setName(name);
        contacts[id].setProfession(profession);
        contacts[id].setDateOfBirth(dateOfBirth);
        contacts[id].setPhoneNumber(phoneNumber);
        contacts[id].setEmailAddress(emailAddress);
        System.out.println("Контакт был обновлён\n");
    }

    protected void removeContact(int id) {
        if (contacts[id] != null) {
            contacts[id] = null;
            System.out.println("Контакт с ID: " + id + " удалён\n");
        } else {
            System.out.println("Пользователь с ID: " + id + " не найден\n");
        }
    }

    protected void printContacts() {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                String contact = contacts[i].toString();
                System.out.println("ID " + i + "\n" + contact);
            }
        }
    }
}
