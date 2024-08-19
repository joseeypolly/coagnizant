import threading
import time
import json

class Inventory:
    def __init__(self):
        self.items = {}

    def add_item(self, item_name, quantity):
        if item_name in self.items:
            self.items[item_name] += quantity
        else:
            self.items[item_name] = quantity

    def remove_item(self, item_name, quantity):
        if item_name in self.items and self.items[item_name] >= quantity:
            self.items[item_name] -= quantity
            if self.items[item_name] == 0:
                del self.items[item_name]
        else:
            print(f"Not enough {item_name} in stock to remove {quantity}.")

    def check_stock(self, item_name):
        return self.items.get(item_name, 0)

    def save_to_file(self, filename):
        try:
            with open(filename, 'w') as file:
                json.dump(self.items, file)
        except IOError as e:
            print(f"An error occurred while saving to file: {e}")

    def load_from_file(self, filename):
        try:
            with open(filename, 'r') as file:
                self.items = json.load(file)
        except (IOError, json.JSONDecodeError) as e:
            print(f"An error occurred while loading from file: {e}")

    def restock_alert(self, threshold=5, interval=10):
        def check_stock_levels():
            while True:
                for item, quantity in self.items.items():
                    if quantity < threshold:
                        print(f"Restock alert: {item} is below threshold with {quantity} units left.")
                time.sleep(interval)

        thread = threading.Thread(target=check_stock_levels)
        thread.daemon = True
        thread.start()

if __name__ == "__main__":
    inventory = Inventory()

    # Add items to the inventory
    inventory.add_item("Apple", 10)
    inventory.add_item("Banana", 2)
    inventory.add_item("Orange", 15)

    # Start restocking alert thread
    inventory.restock_alert(threshold=5, interval=5)

    # Perform some operations
    inventory.remove_item("Banana", 1)
    inventory.remove_item("Apple", 6)

    # Save inventory state to file
    inventory.save_to_file("inventory_data.json")

    # Simulate some delay
    time.sleep(10)

    # Load inventory state from file
    inventory.load_from_file("inventory_data.json")
    print("Loaded inventory:", inventory.items)
