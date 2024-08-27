import pickle

def read_contacts_text(filename):
    try:
        with open(filename, 'r') as file:
            contacts = file.readlines()
            return [contact.strip() for contact in contacts]
    except FileNotFoundError:
        print(f"File '{filename}' not found. Creating a new one.")
        return []

# Function to write contacts to a text file
def write_contacts_text(filename, contacts):
    with open(filename, 'w') as file:
        for contact in contacts:
            file.write(contact + '\n')

# Function to add a contact to the text file
def add_contact_text(filename, contact):
    contacts = read_contacts_text(filename)
    contacts.append(contact)
    write_contacts_text(filename, contacts)

# Function to remove a contact from the text file
def remove_contact_text(filename, contact):
    contacts = read_contacts_text(filename)
    if contact in contacts:
        contacts.remove(contact)
        write_contacts_text(filename, contacts)
    else:
        print(f"Contact '{contact}' not found in the list.")

# Function to display contacts from the text file
def display_contacts_text(filename):
    contacts = read_contacts_text(filename)
    if contacts:
        print("Contacts:")
        for contact in contacts:
            print(contact)
    else:
        print("No contacts found.")

# Function to save contacts in a binary file
def save_contacts_binary(filename, contacts):
    with open(filename, 'wb') as file:
        pickle.dump(contacts, file)

# Function to load contacts from a binary file
def load_contacts_binary(filename):
    try:
        with open(filename, 'rb') as file:
            return pickle.load(file)
    except (FileNotFoundError, EOFError):
        print(f"File '{filename}' not found or is empty. Creating a new one.")
        return []

# Function to add a contact to the binary file
def add_contact_binary(filename, contact):
    contacts = load_contacts_binary(filename)
    contacts.append(contact)
    save_contacts_binary(filename, contacts)

# Function to remove a contact from the binary file
def remove_contact_binary(filename, contact):
    contacts = load_contacts_binary(filename)
    if contact in contacts:
        contacts.remove(contact)
        save_contacts_binary(filename, contacts)
    else:
        print(f"Contact '{contact}' not found in the list.")

# Function to display contacts from the binary file
def display_contacts_binary(filename):
    contacts = load_contacts_binary(filename)
    if contacts:
        print("Contacts:")
        for contact in contacts:
            print(contact)
    else:
        print("No contacts found.")

def main():
    text_filename = 'contacts.txt'
    binary_filename = 'contacts.bin'

    while True:
        print("\nContact Management System")
        print("1. Add Contact (Text File)")
        print("2. Remove Contact (Text File)")
        print("3. Display Contacts (Text File)")
        print("4. Add Contact (Binary File)")
        print("5. Remove Contact (Binary File)")
        print("6. Display Contacts (Binary File)")
        print("7. Exit")
        choice = input("Enter your choice: ")

        if choice == '1':
            contact = input("Enter contact to add: ")
            add_contact_text(text_filename, contact)
        elif choice == '2':
            contact = input("Enter contact to remove: ")
            remove_contact_text(text_filename, contact)
        elif choice == '3':
            display_contacts_text(text_filename)
        elif choice == '4':
            contact = input("Enter contact to add: ")
            add_contact_binary(binary_filename, contact)
        elif choice == '5':
            contact = input("Enter contact to remove: ")
            remove_contact_binary(binary_filename, contact)
        elif choice == '6':
            display_contacts_binary(binary_filename)
        elif choice == '7':
            print("Exiting...")
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
