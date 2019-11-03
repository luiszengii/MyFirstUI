import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class countDown implements Runnable {
    public void run(){
        for(int i=0; i<16; i++){
            try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e){break;};
            if(i>=7 && i<14) {
                System.out.printf("transaction will be canceled in %d seconds, press ENTER to awake the machine \n", 14 - i);
            } else if (i==15){
                Application.VM.user_cancel();
            }
        }
    }
}

public class Application {

    static VendingMachine VM = new VendingMachine();

    public static void main(String[] args) throws InterruptedException {

        System.out.println(VendingMachine.MAINMENU + "Vending Machine activated\nEmpty, Waiting for staff to fill, please type in \'staff\' to enter staff mode.\n" );
        Scanner scan = new Scanner(System.in);
        countDown cd = new countDown();
        Thread counter = new Thread(cd);//initialize counter, Time out for user mode: 10s in total, last 5s print countdown message

        while (scan.hasNextLine()) {
            String s = scan.nextLine();
            if (s.equals("staff") || s.equals("s")) {
                VM.mode = "staff";
                System.out.println("now in staff mode\n" + VendingMachine.Staff_Instruction);
                continue;
            } else if (s.equals("user") || s.equals("u")) {
                VM.mode = "user";
                System.out.println(VendingMachine.User_Instruction);
                continue;
            }

            switch (VM.mode){
                case "user":
                    //shut down the counter when the new input come
                    counter.interrupt();

                    //look for check to enter check status
                    if (s.equals("check")){
                        if (!VM.shoppingCart.isEmpty()) {
                            VM.isInTransaction = true;
                            VM.input_amount = 0.0;
                        }
                    }

                    //if in transaction pass it to user_check() directly
                    if (VM.isInTransaction) {
                        VM.user_check(Arrays.asList(s.split(" ")));
                    } else {
                        VM.user_input(s);
                        System.out.println(VendingMachine.User_Instruction);//print instruction before each user input
                    }

                    //reset the counter
                    counter = new Thread(cd);
                    if (!VM.shoppingCart.isEmpty() && VM.mode.equals("user")) { counter.start(); }

                    //print out all the items that are in low inventory level
                    List<String> ls = new ArrayList<>();
                    for (Product p : VM.getProduct_status().keySet()) {
                        if (p.getNum_of_items()==0) {
                            ls.add(p.getName());
                        }
                    }
                    if (!ls.isEmpty()) {
                        System.out.println(Arrays.toString(ls.toArray()) + " is out of stock! call a staff ASAP!!!\n");
                    }

                    break;
                case "staff":
                    VM.staff_input(s);
                    System.out.println(VendingMachine.Staff_Instruction);
                    break;
            }

        }
    }
}
