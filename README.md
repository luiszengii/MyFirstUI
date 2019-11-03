# Vending Machine Application

## Version 1.0.0
- created three classes: VendingMachine Product ShoppingCart
- Gradle implemented
- realized features: 
  1. show main menu when the machine started
  2. have 2 modes: user, staff. To enter the staff mode type in 'staff' at any stage of the process(not completed)
  3. staff version of main menu(shows the remain number of products)
  4. have all the products categorised and created with 0 amount at the beginning
  5. getters and setters in Product and ShoppingCart class
  6. users can delete or change number of products they have in their shopping cart, automatically cleard when transaction finished(not completed) 
- build.gradle configuration (not complete)
### Version 1.1.0
- complete user command: 
  1. add product 
- staff command: 
  1. fill
- Exception not handled yet, huge changes made.
### Version 1.1.1
- fix some bugs in the program
### Version 1.2.0
-  Completed the user requirements of Multiple items of the same kind:
   1. When adding an item, the user can select the format of "add item number" or "add item"
   2. The latter is the default number of items--added by 1
- Completed the user demand for Price calculating.
- Add the price attribute for the item object and update the initial item list (add the price to it)
- Handling the exception and edge case that appeared in the previous version
- Hanlded the case that number of product which customer ordered may exceed the number in stock
### Version 1.3.0
- Added caculate_total_price() in Shooping Cart that returns the total value of products in cart
- A reminder() of what type of coins and notes accepted by Vending Machine
- convert_input_money() and calculate_change() in vending machine that converts input into acceptable money and get change
- command in user_input(): 
  1. **ADD** followed by product name or id and amount *(optional, by default 1)*
  2. **CHECK** proceed to checkout, tell customer the amount due, customer paying, and remove items in vending machine.
### Version 1.3.1
-  fixed some vital bugs
### Version 1.3.2
- add user & staff instructions before input
- add command "status" for user to print the status of Vending Machine's products
- fixed bug when trying to type in "add water" when water out of stock
- split message sent by Vending Machine and Shopping Cart
- command now case insensitive
## Version 2.0.0
- Introduced Traction class which is a record of every transaction details.
- Transaction ID starts with number 100 and increase by one.
- staff is given a new command "print" which will print out all the transactions since the Vending Machine is initialized.
- Bugs remains to be fixed.
### Version 2.0.1
- added first test file
- set up jacoco report generation process in Jenkins
- Bugs remains
### Version 2.0.2
- fixed bugs in ShoppingCart.java:
  1. change_num_of_product() **num>=0**
  2. change clear() to not just new a hashmap but will make all values 0.
  3. fixed UI wouldn't change bug
### Version 2.0.3
- fixed bugs in VendingMachine.java, infinity digits were shown when check out, bug fixed.
### Version 2.0.4
- fixed bugs in VendingMachine.java about program returning wrong number of bills or coins after paying enough money
### Version 2.0.5
- fixed bugs in VendingMachine.java so that program will remind user to pay right denomination bills or coins before payment process
### Version 2.1.0
- add user 'delete' function that allow users to delete products in their shopping cart.
- add user 'cart' function, show the current status of shopping cart.
- rename user 'status' into 'machine', avoid ambigous.
- added isEmpty() of shopping cart returns a boolean of if cart is empty.
- tried to implement timeout function, still working on it, may use Timeunit module.
### Version 2.2.0
- add new class Application, where stores the main function, seperate it with concrete classes
- changed project folder name into 'Application'
- fixed transaction not terminated bug
- fixed no change needed raise exception bug
- fixed transaction can't be canceled anywhere bug
### Version 2.2.1
- fix bugs about not showing items sold when doing Print command as staff
### Version 2.3.0
- improve user 'add' function so that users could add items to shoppingcart by their product id
- improve user 'add' function so that when users enter a name or ID which doesn't exist in the list, they could know that.
- fixed bugs about staff 'print' function would tell us infinite decimal change of each transaction
- handle exception of users input more than 3 arguments rather than 2 or 3 required when adding items to shoppingcart
### Version 2.4.0
- Realized 'TimeOut'
- Id recognized when adding products
### Version 2.4.1
- fixed bugs so that users could only type 'add product_id' to add default 1 specific product to shoppingcart.
- fixed bug of timeout that when check out the counter don't stop
### Version 2.4.2
- Returned money now will be shown when a user cancel transaction in the middle of the paying process
- Name of items in low inventory level will be shown by Vending Machine
### Version 2.4.3
- Fixed some bugs about no items in the shoppingcart but still could 'check' 
### Version 2.5.0
- we managed to delete the nested scanner so that all test could go without any more obstacle..
- print receipt were reconstructed and being a new isolated method.
- isInTransaction is represented as a status of the program process. 
