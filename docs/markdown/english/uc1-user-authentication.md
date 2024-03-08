# UC1. User Identification

**Primary Actor**: User (Customer, Employee)
 
**Stakeholders:**
- **Employee**: Wants to access personalized properties (eg product update).
- **Customer**: He wants to be the only one who has access to his personal data (eg saved compositions).

**Preconditions**: The User has successfully registered in the system.

## Basic Flow

### Α) User Identification

1. The User launches the application.
2. The System shows the user the data filling form.
3. The User fills in his details in the login form.
4. The System searches for the user in the DB based on (username, password).
5. The System confirms the user.
6. The User successfully enters the system.

</br>

**Alternative Flows**

*3a. One of the mandatory details (username, password) has not been entered.*
1. System displays appropriate error message.
2. The UC returns to step 3 of the basic flow.
---

*5a. Account not found.*
1. The System displays an appropriate error message (and the use case terminates).
2. The PC returns to step 3 of the basic flow.
---

*At any point the software crashes.
1. The User restarts the application.
2. The Process returns to step 2 of UC.
