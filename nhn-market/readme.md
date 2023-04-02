Developing an NHN Mart program using Servlets:
===
# Food Stand
- Onions (1,000 won) 2 ea
- Eggs (2,000 won) 5 pkgs
- Green onions (500 won) 10 ea
- Apples (2,000 won) 20 ea

# Servlet
- GET /init: Prepare the food stand (Init)
  - Read the food information set in context-param, create a food object, and set it as ServletContext attribute → can be referenced by all Servlets
  - Provide a link to move to the product list on the response screen
- GET /foods: Product list (FoodStand)
  - Output product list to response
  - Configure a form that allows you to select the desired product and add it to the shopping cart
  - Since it can be more complicated than expected, it is recommended to proceed in the order of outputting the product list first, and then configuring the form to add to the shopping cart.
- POST /cart: Add to shopping cart
  - Verify that you did not order more than the amount of the product
  - Remove the quantity added to the shopping cart from the food stand
  - Provide a link to move to the shopping cart screen on the response screen
- GET /cart: Shopping cart screen
  - Display the list of products in the shopping cart and the total amount in the response
- Login/Logout
  - /loginForm.html
  - GET /login 
  - POST /login
  - GET /logout
- web.xml
  - Add index.html to the welcome-file-list item.
  - index.html should have links to /login and /cart.

