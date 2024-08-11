# customer_data.py

# Step 2: Define a dictionary to store customer names and their purchase amounts
customer_data = {'Alice': 120, 'Bob': 75, 'Charlie': 90}

# Step 3: Write the function
def update_purchase(customer_data, name, amount):
    if name in customer_data:
        customer_data[name] = amount
    else:
        print(f"Customer {name} not found.")

# Step 4: Use the function to update Bob's purchase amount
update_purchase(customer_data, 'Bob', 100)

# Step 5: Print the updated customer data
print("Updated customer data:")
for name, amount in customer_data.items():
    print(f"{name}: ${amount}")
