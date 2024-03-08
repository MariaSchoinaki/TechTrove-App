# UC2. Product search

**Primary Actor**: User (Customer, Employee)

**Stakeholders:**
- **Employee**: Wants to search for products to facilitate catalog updating.
- **Customer**: Wants to search for products to see their information.

**Preconditions**: User has successfully executed the "User Authentication" use case

## Basic Flows

### A) Product search by scrolling through the catalog
   
1. The User navigates through the list of categories.
2. The User selects the desired product category.
3. The System displays the product list of the selected product category.
4. The User navigates to the product catalog of the selected product category.
5. The User selects the desired product.
6. The System displays information about the specific product.
</br>

**Alternative Flows**

*2-5a. The user's desire to browse the catalog ceases to exist.*
1. The User chooses return.
2. The UC returns to the previous step it was before the user pressed "back".
The same alternate flow applies to steps 3, 4, 5, 6.
---

*At any point the software crashes.
1. The User restarts the application.
2. The Process returns to step 2 of UC1.
---

### B) Search for a product in the search field

1. The User selects the search field.
2. User enters product name/code.
3. The System searches for all products associated with the user's typed text.
4. The System displays a list of the matched product(s).
5. The User selects the desired product.
6. The System displays information about the specific product.

</br>

**Alternative Flows**

*4a. No matching product found.*
1. The System displays a relevant message.
2. UC terminates.
---

*At any point the software crashes.
1. The User restarts the application.
2. The Process returns to step 2 of PX1.