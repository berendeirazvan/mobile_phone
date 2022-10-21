import java.util.Scanner;

public class Main {

    private static MobilePhone mobilePhone = new MobilePhone("1234569");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int userChoice;
        Scanner scanner = new Scanner(System.in);
        do {
            showMenu();
            userChoice = scanner.nextInt();
            switch (userChoice) {
                case 0:
                    System.out.println("Bye!");
                    break;
                case 1:
                    addContact();
                    System.out.println();
                    break;
                case 2:
                    removeContact();
                    System.out.println();
                    break;
                case 3:
                    updateContact();
                    System.out.println();
                    break;
                case 4:
                    showContacts();
                    System.out.println();
                    break;
                default:
                    System.out.println("No valid option chosen.");
                    break;
            }
        } while (userChoice != 0);
    }

    private static void showMenu() {
        System.out.println("Choose your option: ");
        System.out.println("0 - quit");
        System.out.println("1 - Add contact");
        System.out.println("2 - Remove contact");
        System.out.println("3 - Update contact");
        System.out.println("4 - Show contacts");
    }


    private static void addContact() {
        System.out.println("Contact name: ");
        String name = scanner.nextLine();
        System.out.println("Phone number: ");
        String phoneNumber = scanner.nextLine();
        Contact contact = Contact.createContact(name, phoneNumber);
        mobilePhone.addNewContact(contact);
    }

    private static void removeContact() {
        System.out.println("Choose contact to remove (name): ");
        String name = scanner.nextLine();
        Contact contactToRemove = mobilePhone.queryContact(name);
        if(mobilePhone.removeContact(contactToRemove)) {
            System.out.println("Contact was removed.");
        } else {
            System.out.println("Contact was not found.");
        }
    }

    private static void showContacts() {
        System.out.println("Showing contact names: ");
        mobilePhone.printContacts();
    }

    private static void updateContact() {
        System.out.println("Choose a contact to update (name): ");
        String nameToUpdate = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(nameToUpdate);
        if(existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        mobilePhone.updateContact(existingContactRecord, newContact);
        System.out.println("Successfully updated contact.1");
    }
}