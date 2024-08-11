# inventory_management.py

# Step 2: Define a list of items with their quantities
inventory = [('item1', 10), ('item2', 0), ('item3', 5)]

# Step 3: Write the function
def check_inventory(inventory):
    for item, quantity in inventory:
        if quantity == 0:
            print(f"{item} is out of stock!")

# Step 4: Iterate over the list and use the function
check_inventory(inventory)

# Step 5: Print the results
# (Results are printed by the check_inventory function)
