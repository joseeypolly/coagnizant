# order_processing.py

# Step 2: Define a variable for the order amount
order_amount = 150

# Step 3: Write the function
def apply_discount(order_amount):
    if order_amount > 100:
        discount = order_amount * 0.10
        order_amount -= discount
    return order_amount

# Step 4: Calculate the final price
final_price = apply_discount(order_amount)

# Step 5: Print the final price
print(f"The final price after applying the discount is: ${final_price}")
