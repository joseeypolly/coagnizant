def process_transaction(amount):
    try:
        # Simulate processing
        if not isinstance(amount, (int, float)):
            raise ValueError("Invalid amount. Please enter a number.")
        if amount <= 0:
            raise ValueError("Amount must be greater than zero.")
        
        # Simulate saving the transaction to a file
        with open('transactions.txt', 'a') as file:
            file.write(f"Processed transaction: {amount}\n")
        
        print(f"Transaction processed successfully: {amount}")

    except ValueError as ve:
        print(f"Error: {ve}")
        log_error(str(ve))
    except FileNotFoundError as fnf_error:
        print(f"Error: {fnf_error}")
        log_error(str(fnf_error))
    except Exception as e:
        print(f"An unexpected error occurred: {e}")
        log_error(str(e))

def get_transaction_amount():
    while True:
        try:
            amount = float(input("Enter transaction amount: "))
            if amount <= 0:
                raise ValueError("Amount must be positive.")
            return amount
        except ValueError as ve:
            print(f"Invalid input: {ve}. Please try again.")


import datetime

def log_error(error_message):
    with open('error_log.txt', 'a') as log_file:
        timestamp = datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')
        log_file.write(f"{timestamp} - {error_message}\n")


def log_error(error_message):
    with open('error_log.txt', 'a') as log_file:
        timestamp = datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')
        log_file.write(f"{timestamp} - {error_message}\n")

def get_transaction_amount():
    while True:
        try:
            amount = float(input("Enter transaction amount: "))
            if amount <= 0:
                raise ValueError("Amount must be positive.")
            return amount
        except ValueError as ve:
            print(f"Invalid input: {ve}. Please try again.")

def process_transaction(amount):
    try:
        if not isinstance(amount, (int, float)):
            raise ValueError("Invalid amount. Please enter a number.")
        if amount <= 0:
            raise ValueError("Amount must be greater than zero.")
        
        with open('transactions.txt', 'a') as file:
            file.write(f"Processed transaction: {amount}\n")
        
        print(f"Transaction processed successfully: {amount}")

    except ValueError as ve:
        print(f"Error: {ve}")
        log_error(str(ve))
    except FileNotFoundError as fnf_error:
        print(f"Error: {fnf_error}")
        log_error(str(fnf_error))
    except Exception as e:
        print(f"An unexpected error occurred: {e}")
        log_error(str(e))

def main():
    while True:
        amount = get_transaction_amount()
        process_transaction(amount)
        cont = input("Do you want to process another transaction? (y/n): ")
        if cont.lower() != 'y':
            break

if __name__ == "__main__":
    main()
