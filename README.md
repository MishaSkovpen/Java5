Initial Commit:

Created the basic structure for the Bank, BankAccount, and exception classes.
Implemented deposit, withdraw, getBalance, and getAccountSummary methods in BankAccount.
Implemented createAccount, findAccount, and transferMoney methods in the Bank class.
Negative Amount Exception:

Added a NegativeAmountException class to handle exceptions when a negative amount is provided for deposit or withdrawal.
Modified the deposit and withdraw methods in BankAccount to throw NegativeAmountException when the amount is negative.
Insufficient Funds Exception:

Added an InsufficientFundsException class to handle exceptions when attempting to withdraw more than the account balance.
Modified the withdraw method in BankAccount to throw InsufficientFundsException when the withdrawal amount exceeds the balance.
Account Not Found Exception:

Added an AccountNotFoundException class to handle exceptions when trying to find an account that does not exist.
Modified the findAccount method in the Bank class to throw AccountNotFoundException when the account is not found.
BankAccount Summary Enhancement:

Enhanced the getAccountSummary method in BankAccount to provide more detailed account information.
Bank Class Initialization:

Modified the Bank constructor to initialize the accounts list when a Bank object is created.
Main Class and Test Cases:

Created the Main class with the main method for testing the Bank and BankAccount functionalities.
Created two BankAccount instances and tested deposit, withdraw, and transferMoney operations.
README Update:

Added a README file with instructions and explanations about the program.
