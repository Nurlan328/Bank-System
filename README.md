Project's idea:

- To manage the online payment of electricity bills. It helps customer to view our electricity bill and pay online from anywhere.
- This project also help in administrative work such as keep information of customers, connection and bills.
- The project has a wide scope, as it is not intended to a particular organization. This project is going to develop generic software, which can be applied by any business organisation.

Proposed system:

`	`The proposed system ensures the complete freedom for users, where user at his own system can login to this website and access all the features.

Here customer can send their queries and suggestions through a feedback form.



Functionality:

`	`For Admin:

- Manage Customer
- Manage Connection
- Manage Bills
- Manage Queries

For Customer:

- View Bill
- Pay Bill
- View Connection
- Ask Queries

 

1) Get all customers
     GET http://localhost:8080/customers or
```
   curl -X GET --header 'Accept: application/json' 'http://localhost:8080/customers')
```

----
2) Add new customer
   POST http://localhost:8080/customers/new













