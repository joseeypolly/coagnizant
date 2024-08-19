from text_processing_tool import count_words, find_unique_words, convert_to_uppercase

def main():
    user_text = input("Enter a text string: ")

    print("\nChoose an option:")
    print("1. Count words")
    print("2. Find unique words")
    print("3. Convert text to uppercase")
    choice = input("Enter the number of your choice: ")

    if choice == '1':
        print(f"Word count: {count_words(user_text)}")
    elif choice == '2':
        unique_words = find_unique_words(user_text)
        print(f"Unique words ({len(unique_words)}): {unique_words}")
    elif choice == '3':
        print(f"Uppercase text: {convert_to_uppercase(user_text)}")
    else:
        print("Invalid choice!")

if __name__ == "__main__":
    main()
