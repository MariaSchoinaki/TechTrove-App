# UC5. Publishing Synthesis

**Primary Actor**: Customer

**Stakeholders:**
- **Customer**: Wants to publicize the completed compositions he purchased.

**Preconditions**: Customer has successfully executed the "User Authentication" and "Purchase Products" use case


## Basic Flow

### A) Publishing Synthesis

1. The Customer selects "Order History".
2. The System displays the Customer's registered orders.
3. The Customer navigates to his registered orders.
4. The Customer selects the order he is interested in.
5. The System displays the Products of the order in detail.
6. The Client chooses the composition he is interested in posting.
7. The Customer selects "Publish".
8. The System registers the composition as published.
9. The System adds the composition to the list of published compositions.

</br>

**Alternate Streams**

*3a /4a /6a /7a. The customers's desire to publish his composition ceases to exist.*
1. The Customer selects "Cancel".
2. UC terminates.
---

*8a. The composition is already published by the same Customer*
1. System shows error message.
2. The User selects "OK".
3. UC terminates.
---

*At any point the software crashes.
1. Customer restarts the application.
2. The Process returns to step 2 of UC1.
