product_names = ["Laptop", "Smartphone", "Tablet", "Headphones", "Charger"]

def add_product(product_list, product_name):
    product_list.append(product_name)

def remove_product(product_list, product_name):
    if product_name in product_list:
        product_list.remove(product_name)

def update_product(product_list, old_name, new_name):
    if old_name in product_list:
        index = product_list.index(old_name)
        product_list[index] = new_name
# The product_details dictionary is defined here 
product_details = {
    "Laptop": {"quantity": 10, "price": 1000},
    "Smartphone": {"quantity": 20, "price": 500},
    "Tablet": {"quantity": 15, "price": 300},
}
# The add_product_details function is defined here
def add_product_details(details_dict, product_name, quantity, price):
    details_dict[product_name] = {"quantity": quantity, "price": price}

def update_product_details(details_dict, product_name, quantity=None, price=None):
    if product_name in details_dict:
        if quantity is not None:
            details_dict[product_name]["quantity"] = quantity
        if price is not None:
            details_dict[product_name]["price"] = price

def delete_product_details(details_dict, product_name):
    if product_name in details_dict:
        del details_dict[product_name]

#the product_catalog Tuples are defined here
product_catalog = [
    ("Laptop", "Electronics"),
    ("Smartphone", "Electronics"),
    ("Tablet", "Electronics"),
    ("Headphones", "Accessories"),
    ("Charger", "Accessories")
]
# The show_product_catalog function is defined here
def show_product_catalog(catalog):
    for product, category in catalog:
        print(f"Product: {product}, Category: {category}")

# The get_product_categories set is defined here
product_categories = {"Electronics", "Accessories"}
# The add_category function is defined here
def add_category(categories_set, category):
    categories_set.add(category)

def remove_category(categories_set, category):
    categories_set.discard(category)

#Combining Collections
def generate_sorted_price_report(details_dict):
    sorted_products = sorted(details_dict.items(), key=lambda item: item[1]["price"])
    for product, details in sorted_products:
        print(f"Product: {product}, Price: ${details['price']}, Quantity: {details['quantity']}")


def find_products_in_price_range(details_dict, min_price, max_price):
    return {product for product, details in details_dict.items() if min_price <= details["price"] <= max_price}

# Test the functions
if __name__ == "__main__":
    # Test list functions
    print("Initial product list:", product_names)
    add_product(product_names, "Mouse")
    print("After adding Mouse:", product_names)
    remove_product(product_names, "Tablet")
    print("After removing Tablet:", product_names)
    update_product(product_names, "Mouse", "Wireless Mouse")
    print("After updating Mouse to Wireless Mouse:", product_names)

    # Test dictionary functions
    print("\nInitial product details:", product_details)
    add_product_details(product_details, "Wireless Mouse", 50, 25)
    print("After adding Wireless Mouse:", product_details)
    update_product_details(product_details, "Wireless Mouse", price=30)
    print("After updating Wireless Mouse price:", product_details)
    delete_product_details(product_details, "Wireless Mouse")
    print("After deleting Wireless Mouse:", product_details)

    # Test tuple functions
    print("\nProduct Catalog:")
    show_product_catalog(product_catalog)

    # Test set functions
    print("\nInitial product categories:", product_categories)
    add_category(product_categories, "Gadgets")
    print("After adding Gadgets:", product_categories)
    remove_category(product_categories, "Accessories")
    print("After removing Accessories:", product_categories)

    # Test combining collections
    print("\nProducts sorted by price:")
    generate_sorted_price_report(product_details)

    print("\nProducts in price range $200 - $600:")
    products_in_range = find_products_in_price_range(product_details, 200, 600)
    print(products_in_range)
