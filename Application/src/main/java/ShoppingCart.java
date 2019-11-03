import java.util.HashMap;

class ShoppingCart{

    private HashMap<Product, Integer> list_of_Products;
    private String UI;

    ShoppingCart(){
        this.list_of_Products = new HashMap<Product, Integer>(){{}};
        for (Product p : Product.values()) {
            this.list_of_Products.put(p, 0);
        }
    }

    String showUI(){
        String UI =
                "           Shopping Cart            \n"+
                "------------------------------------\n"+
                "|     Drinks      |   Chocolates   |\n"+
                "------------------------------------\n"+
  String.format("|     water %d    |     MandM %d   |\n", this.list_of_Products.get(Product.water), this.list_of_Products.get(Product.MandM))+
  String.format("|   soft_drink %d |      Mars %d   |\n", this.list_of_Products.get(Product.soft_drink), this.list_of_Products.get(Product.Mars))+
  String.format("|     juice %d    |    Sneakers %d |\n", this.list_of_Products.get(Product.juice), this.list_of_Products.get(Product.Sneakers))+
  String.format("|                 |     Bounty %d  |\n", this.list_of_Products.get(Product.Bounty))+
                "------------------------------------\n"+
                "|     Chips       |     Lollies    |\n"+
                "------------------------------------\n"+
  String.format("|    original %d  |  sour_worms %d |\n", this.list_of_Products.get(Product.original), this.list_of_Products.get(Product.sour_worms))+
  String.format("|     chicken %d  |  jellybeans %d |\n", this.list_of_Products.get(Product.chicken), this.list_of_Products.get(Product.jellybeans))+
  String.format("|       BBQ %d    | little_bears %d|\n", this.list_of_Products.get(Product.BBQ), this.list_of_Products.get(Product.little_bears))+
  String.format("|sweet_chillies %d|   part_mix %d  |\n", this.list_of_Products.get(Product.sweet_chillies), this.list_of_Products.get(Product.part_mix))+
                "------------------------------------\n";
        return UI;
    }

    HashMap<Product, Integer> getList_of_Products() {return this.list_of_Products;}

    //customer adding product to the cart, set product amount
    void add_Product(Product p, int num){
        if(num < 1){
            System.out.println("SC: Cannot add negative or 0 number of product");
            return;
        } else {
            int new_num = this.list_of_Products.get(p) + num;
            this.list_of_Products.replace(p, new_num);
            System.out.printf("SC: %d of %s has been added to your shopping cart.\n", num, p.getName());
        }
    }

    void delete_Product(Product p, int num){
        if(num < 1){
            System.out.println("SC: Cannot add negative number of product");
            return;
        } else if (num > this.list_of_Products.get(p)) {
            System.out.println("SC: number exceed the actual number of product in shopping cart");
        } else {
            int new_num = this.list_of_Products.get(p) - num;
            this.list_of_Products.put(p, new_num);
            System.out.printf("SC: %d of %s has been deleted from your shopping cart.\n", num, p.getName());
        }
    }

    //customer changing the num of product in the cart or delete it, can be applied in adding or decreasing the num of product as well
    void change_num_of_product(Product p, int num){
        if (num >= 0) {
            if (this.list_of_Products.containsKey(p)) {
                this.list_of_Products.replace(p, num);
                System.out.println("SC: Number of item changed successfully.");
            } else {
                System.out.println("SC: Good not in cart");
            }
        } else {
            System.out.println("SC: Cannot change number of product to a negative number");
        }
    }

    Double Calculate_total_price(){
        double amount = 0;
        for (Product p: this.list_of_Products.keySet()){
            double current_amount = p.getPrice() * (double) this.list_of_Products .get(p);
            amount = amount + current_amount;
        }
        return amount;
    }

    void clear(){
        for (Product p : Product.values()) { this.list_of_Products.put(p, 0); }
    }

    boolean isEmpty() {
        for (Integer n : this.getList_of_Products().values()){
            if(n > 0){
                return false;
            }
        }
        return true;
    }

}