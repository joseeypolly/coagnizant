from abc import ABC, abstractmethod

class DiscountStrategy(ABC):
    @abstractmethod
    def apply_discount(self, order_amount):
        pass

class RegularDiscount(DiscountStrategy):
    def apply_discount(self, order_amount):
        return order_amount  # No discount for regular customers

class PremiumDiscount(DiscountStrategy):
    def apply_discount(self, order_amount):
        return order_amount * 0.9  # 10% discount for premium customers

class VIPDiscount(DiscountStrategy):
    def apply_discount(self, order_amount):
        return order_amount * 0.8  # 20% discount for VIP customers

class Order:
    def __init__(self, customer_type, order_amount):
        self.customer_type = customer_type
        self.order_amount = order_amount
        self.discount_strategy = self._get_discount_strategy()

    def _get_discount_strategy(self):
        if self.customer_type == "regular":
            return RegularDiscount()
        elif self.customer_type == "premium":
            return PremiumDiscount()
        elif self.customer_type == "vip":
            return VIPDiscount()
        else:
            raise ValueError("Unknown customer type")

    def final_price(self):
        return self.discount_strategy.apply_discount(self.order_amount)

if __name__ == "__main__":
    # Create orders for different customer types
    regular_order = Order(customer_type="regular", order_amount=100)
    premium_order = Order(customer_type="premium", order_amount=100)
    vip_order = Order(customer_type="vip", order_amount=100)

    # Calculate and print the final prices
    print(f"Regular customer final price: ${regular_order.final_price():.2f}")
    print(f"Premium customer final price: ${premium_order.final_price():.2f}")
    print(f"VIP customer final price: ${vip_order.final_price():.2f}")
