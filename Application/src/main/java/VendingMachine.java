import java.util.*;
import java.lang.Math;
import java.time.*;

public class VendingMachine {
    static final String MAINMENU = "            MAIN     MENU           \n"+
            "--------------------------------------------------\n"+
            "|          Drinks         |       Chocolates      |\n"+
            "--------------------------------------------------\n"+
            "|       water(1)-2.00$    |      MandM(4)-8.00$   |\n"+
            "|     soft_drink(2)-3.00$ |      Mars(5)-5.00$    |\n"+
            "|      juice(3)-2.50$     |    Sneakers(6)-2.50$  |\n"+
            "|                         |     Bounty(7)-1,00$   |\n"+
            "--------------------------------------------------\n"+
            "|          Chips          |        Lollies        |\n"+
            "--------------------------------------------------\n"+
            "|    original(8)-2.50$    |  sour_worms(12)-5.00$ |\n"+
            "|     chicken(9)-3.00$    | jellybeans(13)-2.00$  |\n"+
            "|       BBQ(10)-2.70$     | little_bears(14)-6.50$|\n"+
            "| sweet_chillies(11)-3.00$|   part_mix(15)-4.50$  |\n"+
            "--------------------------------------------------\n";

    static final String User_Instruction =
            "\nPlease type in \'add\' followed by the product name or id and the number of goods u want to buy below(by default 1)\n" +
            "Or type in \'delete\' followed by the product name or id and the number of goods u want to delete in shopping cart(by default 1)\n" +
            "Or type in \'cart\' to see the status of products in your shopping cart\n" +
            "Or type in \'machine\' to see the status of products in this Vending Machine\n" +
            "Or type in \'check\' if u wish to proceed to check out\n" +
            "Or type in \'cancel\' if u want to cancel the transaction\n";

    static final String Staff_Instruction =
            "\n\'fill\' to fill the VM\n\'print\' to print the transactions\n";

    static ArrayList<String> list_of_Product_name = new ArrayList<String>(){{
        for (Product p : Product.values()) {
            add(p.getName());
        }
    }};

    static ArrayList<Integer> List_of_Product_id = new ArrayList<Integer>(){{
        for (Product p : Product.values()) {
            add(p.getProduct_id());
        }
    }};

    static int count = 100;
    static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    static boolean isInTransaction = false;
    static double input_amount;
    String mode;
    ShoppingCart shoppingCart;
    HashMap<String, Product> Products;

    VendingMachine(){
        this.mode = "user";
        this.shoppingCart = new ShoppingCart();
        this.Products = new HashMap<String, Product>();
        for (Product p : Product.values()){ this.Products.put(p.getName(), p); }
    }

    void clear(){
        for (Product p : this.Products.values()) {
            p.setNum_of_items(0);
        }
    }

    HashMap<Product, Integer> getProduct_status(){
        HashMap<Product, Integer> map = new HashMap<>();
        for (Product p : this.Products.values()){ map.put(p, p.getNum_of_items()); }
        return map;
    }

    String Product_statusUI(){
        return
                "------------------------------------\n" +
                "|     Drinks      |   Chocolates   |\n" +
                "------------------------------------\n" +
 String.format("|     water %d     |     MandM %d    |\n", this.Products.get("water").getNum_of_items(), this.Products.get("MandM").getNum_of_items()) +
 String.format("|   soft_drink %d  |      Mars %d    |\n", this.Products.get("soft_drink").getNum_of_items(), this.Products.get("Mars").getNum_of_items()) +
 String.format("|     juice %d     |    Sneakers %d  |\n", this.Products.get("juice").getNum_of_items(), this.Products.get("Sneakers").getNum_of_items()) +
 String.format("|                 |     Bounty %d   |\n", this.Products.get("Bounty").getNum_of_items()) +
                "------------------------------------\n" +
               "|     Chips       |     Lollies    |\n" +
                "------------------------------------\n" +
 String.format("|    original %d   |  sour_worms %d  |\n", this.Products.get("original").getNum_of_items(), this.Products.get("sour_worms").getNum_of_items()) +
 String.format("|     chicken %d   |  jellybeans %d  |\n", this.Products.get("chicken").getNum_of_items(), this.Products.get("jellybeans").getNum_of_items()) +
 String.format("|       BBQ %d     | little_bears %d |\n", this.Products.get("BBQ").getNum_of_items(), this.Products.get("little_bears").getNum_of_items()) +
 String.format("|sweet_chillies %d |   part_mix %d   |\n", this.Products.get("sweet_chillies").getNum_of_items(), this.Products.get("part_mix").getNum_of_items()) +
                "------------------------------------\n";
    }

    //remind user the denominations they can pay
    static String money_reminder(){
        System.out.println("You can only pay by these denominations of coins or notes: 10c, 20c, 50c, $1, $2, $5, $10, $20");
        return "You can only pay by these denominations of coins or notes: 10c, 20c, 50c, $1, $2, $5, $10, $20\n";
    }

    //convert string of input_money to double which can be used in real
    static double convert_input_money(String input_money){
        String[] temp_list = input_money.split("");
        List<String> accept_money = new ArrayList<>(Arrays.asList("10c","20c","50c","$1","$2","$5","$10","$20"));
        if (input_money.equals("10c")){
            return 0.1;
        }else if (input_money.equals("20c")){
            return 0.2;
        }else if (input_money.equals("50c")){
            return 0.5;
        }else if (temp_list[0].equals("$")){
            if (accept_money.contains(input_money)){
                String double_string = input_money.substring(1);
                double result = Double.parseDouble(double_string);
                return result;
            } else {
                return -1.0;
            }
        }else{
            return -1.0;
        }
    }

    //return a ArrayList containing changes which need to be returned已知要给多少钱看怎么给sta
    static ArrayList<String> Calculate_change(double change){
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Double> accept_money = new ArrayList<Double>(Arrays.asList(20.00, 10.00, 5.00, 2.00, 1.00, 0.50, 0.20, 0.10));
        while (change != 0.00){
            for (double current_tested : accept_money) {
                if (change > current_tested || change == current_tested) {
                    int number_of_change = (int) Math.floor(change / current_tested);
                    String result_line = Integer.toString(number_of_change) + " $" + String.format("%.2f", current_tested);
                    result.add(result_line);
                    change = (change % current_tested) * 100;
                    change = (double) Math.round(change) / 100;
                    break;
                }
            }
        }
        return result;
    }

    String user_add(List<String> ls){
        if (this.Products.containsKey(ls.get(1))) {
            if (ls.size() == 2) {
                if (this.Products.get(ls.get(1)).getNum_of_items() < 1) {
                    System.out.println("Sorry, we are out of " + ls.get(1));
                    return "Sorry, we are out of " + ls.get(1);
                } else {
                    this.Products.get(ls.get(1)).sell(1);//remove them/it from vending machine
                    this.shoppingCart.add_Product(Products.get(ls.get(1)), 1); //putting product in cart, the default number is 1
                    return "SC: 1 of " + ls.get(1) + " has been added to your shopping cart.";
                }
            }
            else if (ls.size() == 3){
                try{
                    int numOfP = Integer.parseInt(ls.get(2));
                    if(numOfP > this.Products.get(ls.get(1)).getNum_of_items()){
                        System.out.println("The number you input is out of stock");
                        return "The number you input is out of stock";
                    } else {
                        this.shoppingCart.add_Product(this.Products.get(ls.get(1)), numOfP);
                        this.Products.get(ls.get(1)).sell(numOfP);//remove them/it from vending machine
                        return "SC: " + ls.get(2) + " of " + ls.get(1) + " has been added to your shopping cart.";
                    }
                } catch(NumberFormatException e) {
                    System.out.println("The number of products to be selected must be Integer");
                    return "The number of products to be selected must be Integer";
                }
            }//if user input amount of products to be selected, the program will accept this requirements
            else{
                System.out.println("Please type in right format");
                return "Please type in right format";
            }

        } else if (!this.Products.containsKey(ls.get(1))) {//用户输入数字情况
            try{
                int product_id = Integer.parseInt(ls.get(1));
                if (List_of_Product_id.contains(product_id)){
                    String product_name = "";
                    for (String n : Products.keySet()){
                        Product p = Products.get(n);
                        if (p.getProduct_id() == product_id){
                            product_name = n;
                        }
                    }
                    if (ls.size() == 2){
                        if (this.Products.get(product_name).getNum_of_items() < 1){
                            System.out.println("Sorry, we are out of " + product_name);
                            return "Sorry, we are out of " + product_name;
                        }else{
                            this.Products.get(product_name).sell(1);//remove them/it from vending machine
                            this.shoppingCart.add_Product(Products.get(product_name), 1); //putting product in cart, the default number is 1
                            return "SC: 1 of " + product_name + " has been added to your shopping cart.";
                        }
                    }
                    else if (ls.size() == 3){
                        try{
                            int number_product =  Integer.parseInt(ls.get(2));
                            if (number_product > this.Products.get(product_name).getNum_of_items()){
                                System.out.println("The number you input is out of stock");
                                return "The number you input is out of stock";
                            }else{
                                this.shoppingCart.add_Product(this.Products.get(product_name), number_product);
                                this.Products.get(product_name).sell(number_product);//remove them/it from vending machine
                                return "SC: " + ls.get(2) + " of " + product_name + " has been added to your shopping cart.";
                            }
                        }catch (NumberFormatException e){
                            System.out.println("The number of products to be selected must be Integer");
                            return "The number of products to be selected must be Integer";
                        }
                    }
                    else{
                        System.out.println("Please type in right format");
                        return "Please type in right format";
                    }
                }else{
                    System.out.println("Product not exist, please type in the correct product name");
                    return "Product not exist, please type in the correct product name";
                }
            }catch (NumberFormatException e){
                System.out.println("Product not exist, please type in the correct product name");
                return "Product not exist, please type in the correct product name";
            }
        }
        return null;
    }

    String user_delete(List<String> ls){
        if (list_of_Product_name.contains(ls.get(1))) {
            Product p = this.Products.get(ls.get(1));
            if (ls.size() == 2) {
                if (this.shoppingCart.getList_of_Products().get(p) < 1) {
                    System.out.println("your shopping cart do not have " + ls.get(1));
                    return "your shopping cart do not have " + ls.get(1);
                } else {
                    this.Products.get(ls.get(1)).add_back(1);//remove them/it from cart
                    this.shoppingCart.delete_Product(Products.get(ls.get(1)), 1); //putting product back in machine, the default number is 1
                    return null;
                }
            }

            if (ls.size() == 3){
                try{
                    int numOfP = Integer.parseInt(ls.get(2));
                    if(numOfP > this.shoppingCart.getList_of_Products().get(p)){
                        System.out.println("The number you input is more than u have in your shopping cart");
                        return "The number you input is more than u have in your shopping cart";
                    } else {
                        this.Products.get(ls.get(1)).add_back(numOfP);
                        this.shoppingCart.delete_Product(Products.get(ls.get(1)), numOfP);
                        return null;
                    }
                } catch(NumberFormatException e) {
                    System.out.println("The number of products to be selected must be Integer");
                    return "The number of products to be selected must be Integer";
                }
            }//if user input amount of products to be selected, the program will accept this requirements

        } else if (!list_of_Product_name.contains(ls.get(1))) {
            System.out.println("Product not exist, please type in the correct product name");
            return "Product not exist, please type in the correct product name";
        }
        return null;
    }

    String user_receipt(){
        String l_r = "";
        Transaction t = transactions.get((transactions.size())-1);
        System.out.println("transaction complete, thank u!");
        l_r = l_r + "transaction complete, thank u!\n";
        System.out.println();
        l_r = l_r + "\n";
        System.out.println("--------------------------------");
        l_r = l_r + "--------------------------------\n";
        System.out.println("Here is your receipt:");
        l_r = l_r + "Here is your receipt:\n";
        for(Map.Entry<Product, Integer> e : t.getItem_sold().entrySet()){
            if (e.getValue() > 0) {
                System.out.println(e.getKey() + " * " + e.getValue());
                l_r += e.getKey() + " * " + e.getValue() + "\n";
            }
        }
        System.out.println();
        l_r = l_r + "\n";
        System.out.println("Transaction id:" + t.getId());
        l_r = l_r + "Transaction id:" + t.getId()+"\n";
        System.out.printf("Total cost: $%.2f\n", t.getMoney_paid());
        l_r = l_r + String.format("Total cost: $%.2f", t.getMoney_paid())+"\n";
        System.out.printf("Total payment: $%.2f\n" , t.getTotal_price());
        l_r = l_r + String.format("Total payment: $%.2f" , t.getTotal_price())+"\n";
        System.out.printf("Total change: $%.2f\n", t.getChange());
        l_r += String.format("Total change: $%.2f\n", t.getChange());
        System.out.println("--------------------------------");
        l_r = l_r + "--------------------------------\n";
        return l_r;
    }


    String user_check(List<String> ls){
        String l_r = "";
        if(ls.size()!=1){
            System.out.println("'CHECK' command is a wrong format");
            return "'CHECK' command is a wrong format";
        }
        else {
            //Tell customer the amount they need to pay
            double total_price = this.shoppingCart.Calculate_total_price();
            System.out.printf("The total price you need to pay is: $%.2f\n", total_price);
            l_r += String.format("The total price you need to pay is: $%.2f\n", total_price);

            //paying progress
            System.out.println("Now you will enter paying progress");
            l_r += "Now you will enter paying progress\n";
            l_r += money_reminder();

            //taking valid input money
            String input_money = ls.get(0);

            //cancel if input equals cancel and return
            if (input_money.equals("cancel")){
                System.out.printf("$%.2f will be given back to you\n", this.input_amount);
                l_r = l_r + String.format("$%.2f will be given back to you\n", this.input_amount);
                l_r += this.user_cancel();
                return l_r;
            }

            if (input_money.equals("check")) {
                //Display the shopping cart before checking and return since no money has been input
                System.out.println(this.shoppingCart.showUI());
                l_r = l_r+ this.shoppingCart.showUI()+"\n" ;
                return l_r;
            }

            double double_money = convert_input_money(input_money);

            if (double_money == -1.0){
                System.out.println("Please input given denominations money");//exception of inputting wrong format
                l_r = l_r + "Please input given denominations money\n";
            }else{
                this.input_amount += double_money;
                if (this.input_amount < total_price){
                    double need_more_money = (double)Math.round((total_price - this.input_amount)*100)/100;//making it not with infinity digit
                    System.out.printf("You still need to pay $%.2f\n", need_more_money);//when paying not enough money
                    l_r = l_r + String.format("You still need to pay $%.2f\n", need_more_money);
                } else {
                    double change = (double) Math.round((this.input_amount - total_price)*100) / 100;
                    ArrayList<String> result = Calculate_change(change);
                    if (!result.isEmpty()) {
                        String final_result = "The change would be: " + result.get(0);
                        for (int i = 1; i < result.size(); i++){
                            final_result = final_result + ", " + result.get(i);
                        }
                        System.out.println(final_result);//paying enough money and then begin to calculate and return change
                        l_r = l_r + final_result+"\n";
                    }

                    //adding the transaction details in the list of tx
                    HashMap<Product,Integer> temp = new HashMap<Product,Integer>();
                    for (Product p: this.shoppingCart.getList_of_Products().keySet()){
                        temp.put(p, this.shoppingCart.getList_of_Products().get(p));
                    }
                    Transaction current_transaction = new Transaction(count, LocalDateTime.now(),
                            temp, this.input_amount, change, total_price);
                    transactions.add(current_transaction);
                    this.shoppingCart.clear();
                    count += 1;

                    //print receipt
                    l_r += user_receipt();

                    //set the program out of transaction status
                    this.isInTransaction = false;
                }
            }
        }
        return l_r;
    }

    String user_machine(){
        System.out.println(this.Product_statusUI());
        return this.Product_statusUI()+"\n";
    }

    String user_cart(){
        System.out.println(this.shoppingCart.showUI());
        return this.shoppingCart.showUI()+"\n";
    }

    String user_cancel(){
        for (Map.Entry<Product, Integer> e : this.shoppingCart.getList_of_Products().entrySet()){
            if(e.getValue() > 0){
                this.Products.get(e.getKey().getName()).add_back(e.getValue());
                this.shoppingCart.delete_Product(Products.get(e.getKey().getName()), e.getValue());
            }
        }
        System.out.println("transaction canceled, products moved back to machine from cart");
        return "transaction canceled, products moved back to machine from cart\n";
    }

    String staff_fill(){
        for (Product p : this.Products.values()) {
            p.fill();
        }
        System.out.println("fill successfully");
        return "fill successfully\n";
    }

    String staff_print(){
        String l_rr = "";
        System.out.println("This part is about daily transaction details");
        l_rr = l_rr + "This part is about daily transaction details\n";
        for (int i=0;i<transactions.size();i++){
            Transaction current_t = transactions.get(i);
            System.out.println("Transaction "+current_t.getId()+": ");
            l_rr = l_rr + "Transaction "+current_t.getId()+": "+"\n";
            System.out.println("(1) Transaction date and time are "+current_t.getDate_time());
            l_rr = l_rr + "(1) Transaction date and time are "+current_t.getDate_time()+"\n";
            System.out.println("(2) In this transaction, these are sold items and sold number: ");
            l_rr = l_rr + "(2) In this transaction, these are sold items and sold number: "+"\n";
            for(Product p: current_t.getItem_sold().keySet()){
                System.out.println("    "+current_t.getItem_sold().get(p)+" "+p.getName()+
                        " are(is) sold");
                l_rr = l_rr + "    "+current_t.getItem_sold().get(p)+" "+p.getName()+
                        " are(is) sold" + "\n";
            }
            System.out.println("(3) In this transaction, amount of money paid is "+current_t.getMoney_paid() );
            l_rr = l_rr + "(3) In this transaction, amount of money paid is "+current_t.getMoney_paid()+"\n";
            System.out.println("(4) In this transaction, the change is "+current_t.getChange() );
            l_rr = l_rr + "(4) In this transaction, the change is "+current_t.getChange()+"\n";
        }
        System.out.println("--------------------------------------------------");
        l_rr = l_rr + "--------------------------------------------------\n";
        System.out.println("This part is about available stock");
        l_rr = l_rr + "This part is about available stock"+"\n";
        for (String name: this.Products.keySet()){
            System.out.println("The stock of " + name + " is " + this.Products.get(name).getNum_of_items());
            l_rr = l_rr + "The stock of " + name + " is " + this.Products.get(name).getNum_of_items()+"\n";
        }
        System.out.println("--------------------------------------------------");
        l_rr = l_rr + "--------------------------------------------------\n";
        return l_rr;
    }

    String user_input(String s){
        List<String> ls = Arrays.asList(s.split(" "));
        String command = ls.get(0).toLowerCase();
        switch (command) {
            case "add":
                this.user_add(ls);
                break;
            case "delete":
                this.user_delete(ls);
                break;
            case "check":
                if (!this.shoppingCart.isEmpty()){
                    user_check(ls);
                }
                else{
                    System.out.println("add something to shoppingcart");
                    return "add something to shoppingcart\n";
                }
                break;
            case "machine":
                this.user_machine();
                break;
            case "cart":
                this.user_cart();
                break;
            case "cancel":
                this.user_cancel();
                break;
        }
        return null;
    }

    String staff_input(String s){
        List<String> ls = Arrays.asList(s.split(" "));
        String command = ls.get(0).toLowerCase();
        if (command.equals("fill") || command.equals("f")) {
            this.staff_fill();
            return null;
        }
        else if (command.equals("print")){
            this.staff_print();
            return null;
        }
        return null;
    }

}