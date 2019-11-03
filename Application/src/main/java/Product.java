public enum Product {

    water("water", 0, "drinks", 1, 2),
    soft_drink("soft_drink", 0, "drinks", 2, 3),
    juice("juice", 0, "drinks", 3,2.5),
    MandM("MandM", 0, "chocolates", 4,8),
    Mars("Mars", 0, "chocolates", 5,5),
    Sneakers("Sneakers", 0, "chocolates", 6,2.5),
    Bounty("Bounty", 0, "chocolates", 7,1),
    original("original", 0, "chips", 8,2.5),
    chicken("chicken", 0, "chips", 9,3),
    BBQ("BBQ", 0, "chips", 10,2.7),
    sweet_chillies("sweet_chillies", 0, "chips", 11,3),
    sour_worms("sour_worms", 0, "lollies", 12,5),
    jellybeans("jellybeans", 0, "lollies", 13,2),
    little_bears("little_bears", 0, "lollies", 14,6.5),
    part_mix("part_mix", 0, "lollies", 15,4.5);

    private String name;
    private int num_of_items;
    private String category;
    private int product_id;
    private double price;

    Product(String name, int num_of_items, String category, int id, double price) {
        this.name = name;
        this.num_of_items = num_of_items;
        this.category = category;
        this.product_id = id;
        this.price=price;
    }

    String getName() {
        return this.name;
    }

    int getNum_of_items(){
        return this.num_of_items;
    }

    void setNum_of_items(int n) {
        this.num_of_items = n;
    }

    int getProduct_id(){
        return this.product_id;
    }

    String getCategory(){
        return this.category;
    }

    double getPrice() {return this.price; }

    // fill can only be used by the staff
    void fill(){
        this.num_of_items = 10;
    }

    // used after the transaction has been confirmed
    void sell(int n){
        if(n < 1){
            System.out.println("VM: Cannot sell less than 1 product");
            return;
        } else if (n > this.num_of_items) {
            System.out.println("VM: Cannot sell more than we have");
            return;
        }
        this.num_of_items -= n;
    }

    void add_back(int n) {
        if(n < 1){
            System.out.println("VM: Cannot add back less than 1 product");
            return;
        } else if (n > (10 - this.num_of_items)) {
            System.out.println("VM: Cannot add back more than 10");
            return;
        }
        this.num_of_items += n;
//        System.out.printf("VM: %d of %s has been add back to vending machine\n", n, this.name);
    }

}