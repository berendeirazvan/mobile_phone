import java.util.ArrayList;
import java.util.Objects;

public class MobilePhone {
    private ArrayList<Contact> myContacts = new ArrayList<Contact>();
    private String myNumber;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
    }

    public boolean addNewContact(Contact contact) {
        if(findContact(contact.getName()) < 0) {
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int index = findContact(oldContact);
        if(index >= 0) {
            if(Objects.equals(oldContact.getName(), newContact.getName())) {
                System.out.println("New contact has the same name as the old contact. Updating failed.");
                return false;
            }
            myContacts.set(index, newContact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact) {
        int index = findContact(contact);
        if(index >= 0){
            myContacts.remove(index);
            return true;
        }
        return false;
    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        for(int i = 0; i < myContacts.size(); i++){
            if(Objects.equals(myContacts.get(i).getName(), name)) {
                return myContacts.indexOf(myContacts.get(i));
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int index = findContact(name);
        if(index >= 0) {
            return myContacts.get(index);
        }
        return null;
    }

    public void printContacts() {
        for(int i = 0; i < myContacts.size(); i++) {
            System.out.println((i+1) + ". " +
                    myContacts.get(i).getName() +
                    " -> " +
                    myContacts.get(i).getPhoneNumber());
        }
    }
}
