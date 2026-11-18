package main.java.com.skillbox.addressbook;

import java.util.Objects;

public class Contact {

    private String name;
    private String profession;
    private String dateOfBirth;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String profession, String dateOfBirth,
                   String phoneNumber, String emailAddress) {
        this.name = name;
        this.profession = profession;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return getPhoneNumber() == contact.getPhoneNumber()
                && Objects.equals(getName(), contact.getName())
                && Objects.equals(getProfession(), contact.getProfession())
                && Objects.equals(getDateOfBirth(), contact.getDateOfBirth())
                && Objects.equals(getEmailAddress(), contact.getEmailAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getProfession(),
                getDateOfBirth(), getPhoneNumber(), getEmailAddress());
    }

    @Override
    public String toString() {
        return "Ф.И.О. контакта: " + name + "\n" +
                "Должность: " + profession + "\n" +
                "Дата рождения: " + dateOfBirth + "\n" +
                "Номер телефона: " + phoneNumber + "\n" +
                "Адрес электронной почты: " + emailAddress + "\n";
    }
}
