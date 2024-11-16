# CASH DESK MODULE
## Description:

Develop a cash operations module to support deposits, withdrawals, and balance checks for multiple
cashiers in BGN and EUR currencies. Each cashier has a starting balance in both currencies. The
module should allow checking balances for specific date ranges, as well as filtering by cashier name.


## Business Rules & Requirements:

1) Initialize 3 cashiers (MARTINA, PETER, LINDA), each with their own starting balance in BGN
   and EUR
2) Store each cashier’s balances and transactions history in in-memory data structures or files

**Sample data:**
```
Starting amount 1000 BGN, denominations:  50x 10 BGN, 10x 50 BGN
Starting amount 2000 EUR, denominations: 100x 10 EUR, 20x 50 EUR
```
**Sample data:**
```
Withdrawal: 100 BGN, denominations:  5x 10 BGN,  1x 50 BGN
Withdrawal: 500 EUR, denominations: 10x 50 EUR
Deposit:    600 BGN, denominations: 10x 10 BGN, 10x 50 BGN
Deposit:    200 EUR, denominations:  5x 20 EUR,  2x 50 EUR
```


## Technical Requirements:
- Use GitHub repository with a README.md
- Use Java 17
- Use Maven
- Use Spring Boot
- Use validation for the API requests
- Use JSON format for the requests and responses
- Create controllers for cash operations as well as balance check:
  /api/v1/cash-operation: Deposits and withdrawals must be part of one and the same API
  method
  /api/v1/cash-balance: Balance and denominations are returned from one and the same API
  method. It should contain dateFrom, dateTo and cashier parameters which are optional.
- Use a custom request header named FIB-X-AUTH with API key = f9Uie8nNf112hx8s for all API
  calls. Store it in suitable place and suitable format withing the project.
- Use Slf4J to log each action
- Create a Postman collection and environment. Add them within the git project.
- Use separate TXT file for transaction history. Find the most simple, fast and reliable way to format
  and structure the file.
- Use separate TXT file for cash balances and denominations. Find the most simple, fast and reliable
  way to format and structure the file.



