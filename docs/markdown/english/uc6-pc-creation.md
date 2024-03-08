# UC6 Create PC Synthesis

**Primary Actor**: Customer

**Stakeholders:**
- **Customer**: Wants to be able to create functional compositions and later be able to buy them.

**Preconditions**: Customer has successfully executed the "User Authentication" use case.

## Basic Flow
### A) Creating a Composition
1. The Customer navigates to the application and selects "Create Synthesis".
2. System displays component categories.(category bar)
3. The Customer navigates through the categories and selects 1.
4. The System checks the compatibility of the components it will display, with those the user has already selected.
5. The System displays the products of the category, which are also compatible with the already selected components of the user. (filter)
6. The Customer navigates through the products and selects the one he wants.
7. The System temporarily stores the customer's selection.
8. Steps 3-7 are repeated as long as the Customer adds products to his composition.
9. The Customer selects "Add to Cart".
10. The System checks if the composition is complete (if it has the basic components for the composition to be functional)
11. The System adds the composition to the cart.
12. The System displays a successful addition message.

</br>

**Alternative Flows**


*3a. / 6a. / 9a. The Customer decides not to proceed with the creation of his composition.*
1. The Customer selects "Cancel".
2. UC terminates.
---

*3b. The Customer selects a category that has already selected a product*
1. The System checks the compatibility of the components it will display with those the user has already selected.
2. The System displays the products of the category, which are compatible with the already selected components of the user, as well as the selected product, marked. (filter)
3. The process returns to step 6 of the basic flow.
---

*6b. The Customer decides to proceed to the next step, without selecting a component.*
1. The process returns to step 3 of the basic flow.
---

*9b. The Customer wants to save his composition, for later purchase.*
1. The Customer selects "Save".
2. The System saves the composition to the user's saved.
3. UC terminates.
---

*11a. The synthesis is not complete.*
1. The System displays a message with the mandatory components missing from the composition.
2. The Customer selects "OK".
3. The process returns to step 3 of the basic flow.
---

*1a. Customer wants to preview a saved composition.*
1. The Customer navigates to his "Saved" list.
2. The Customer chooses a composition.
3. The System displays the component categories.
4. The Customer:
     * 4a. wishes to modify its composition.
         1. The Process returns to step 3 of the basic flow.
     * 4b. wishes to add his already existing composition to the basket.
         1. The Process returns to step 9 of the basic flow.
---

*At any point the software crashes.
1. The User restarts the application.
2. The process returns to step 2 of UC1.

## Activity Diagram
![Activity Diagram](../uml/requirements/activity-pc-creation.png)