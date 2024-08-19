class Employee:
    def __init__(self, name, hours_worked, hourly_rate):
        self.name = name
        self.hours_worked = hours_worked
        self.hourly_rate = hourly_rate

    def calculate_pay(self):
        if self.hours_worked > 40:
            overtime_hours = self.hours_worked - 40
            overtime_pay = overtime_hours * (self.hourly_rate * 1.5)
            regular_pay = 40 * self.hourly_rate
            return regular_pay + overtime_pay
        else:
            return self.hours_worked * self.hourly_rate
class Manager(Employee):
    def __init__(self, name, hours_worked, hourly_rate, bonus):
        super().__init__(name, hours_worked, hourly_rate)
        self.bonus = bonus

    def calculate_pay(self):
        base_pay = super().calculate_pay()
        return base_pay + self.bonus
if __name__ == "__main__":
    # Create an Employee instance
    employee = Employee(name="Joemama", hours_worked=45, hourly_rate=20)

    # Create a Manager instance
    manager = Manager(name="Samba", hours_worked=50, hourly_rate=30, bonus=500)

    # Calculate and print the total pay
    print(f"{employee.name}'s total pay: ${employee.calculate_pay():.2f}")
    print(f"{manager.name}'s total pay: ${manager.calculate_pay():.2f}")
