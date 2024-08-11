# sales_report.py

# Step 2: Define a list of sales amounts
sales = [200, 600, 150, 800, 300]

# Step 3: Write the function
def generate_report(sales):
    total_sales = 0
    print("Sales Report:")
    for sale in sales:
        total_sales += sale
        if sale > 500:
            print(f"Sale amount: ${sale} - Highlighted (over $500)")
        else:
            print(f"Sale amount: ${sale}")
    return total_sales

# Step 4: Call the function to generate a report
total_sales = generate_report(sales)

# Step 5: Print the total sales for the month
print(f"\nTotal sales for the month: ${total_sales}")
