# BankTransfer

This app uses Flutterwave and Paystack API to demostrate some functionalities. The has the following features:
* Show list of banks
* Verify/Validate account number
* Generate a transfer request
* Verify a transaction

Endpoints available include:

To get list of all banks. Provider would be either "flutter" or "paystack":
* /api/v1/core-banking/banks/{provider}

To Validate Account Number:
* /api/v1/core-banking/validateBankAccount

To make bank transfer:
* /api/v1/core-banking/bankTransfer

To get transaction status:
* /api/v1/core-banking/transaction

