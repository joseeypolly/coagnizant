# payroll_calculator.py

# Step 2: Define variables
hours_worked = 40
hourly_rate = 15

# Step 3: Write the function
def calculate_pay(hours, rate):
    return hours * rate

# Step 4: Use the function to calculate pay
total_pay = calculate_pay(hours_worked, hourly_rate)

# Step 5: Print the total pay
print(f"The total pay for the employee is: ${total_pay}")
