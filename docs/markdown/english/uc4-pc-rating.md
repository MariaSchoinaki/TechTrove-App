# UC4 PC Synthesis Evaluation

**Primary Actor**: Customer

**Stakeholders:**
- **Employee**: Wants to track which compositions are the most popular.
- **Customer**: Wants to be able to rate PC compositions and see other users' ratings on the synthesis they're interested in.

**Conditions**: The User has successfully executed the "User Authentication" and "Purchase Product" use cases.
(For the specific composition)


## Basic Flow

### A) Composition Evaluation

(Note: The evaluation can be done if the Customer has already purchased the specific evaluation.)

1. The Client navigates to the list of compositions.
2. The Customer chooses the composition that interests him.
3. The System displays the information for the specific composition.
4. The Customer chooses 1-5 stars.
5. The System registers the assessment.

</br>

**Alternative Flows**

*2a-4a. The Customer decides not to evaluate the composition.*
1. The Customer selects "Cancel".
2. UC terminates.
---

*4b. The Customer has already rated the composition.*
1. The System displays the evaluation it has given for the selected composition.
2. The System does not allow the Customer to re-evaluate.
3. UC terminates.
---

*At any point the software crashes.
1. The User restarts the application
2. The process returns to step 2 of UC1.