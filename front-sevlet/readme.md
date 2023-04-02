Upgrading NHN Mart by adding new features:
===
- Language selection
- Applying MVC Pattern + FrontController Pattern, minimizing the use of Scriptlet in JSP pages
- Adding payment function:
  - When logged in, user is granted 20,000 KRW
  - Cart management:
    - Add to cart using session
    - Select items in cart and pay using POST/pay
    - Display payment amount and remaining balance, throw AmountException or NotEnoughMoneyException if necessary
- Home screen:
  - Display links to product list and cart
  - Display current language (ko or en) and remaining balance based on user's granted money
- All messages support both Korean and English.


## I coded it with the following steps in mind:

1. First, create the initial html page.
2. Create a filter that filters with UTF-8.
3. When creating a user object, the user must log in to create a session object. Set the user object to have a balance. The balance is not loaded all at once, but stored within the user object. In the index page, show the balance using a money object. Create a money object to be passed to the jsp. When passing to jsp, pass the user object as is, and create a money object using getMoney.
4. Create a resource bundle.
5. Create a user object.
6. Store the selected items in the session and pass them.
7. Setting the locale is a simple task. Use the language get controller to store it in the session. Storing it in the request would cause it to disappear when moving to the next page. Therefore, storing it in the session is better.
8. Create a form in the main and pass the selected language. Pass the selected value through a hidden parameter. Use the language controller to retrieve the selected value through getParameter and store it in the session. Use the filter to process it."
