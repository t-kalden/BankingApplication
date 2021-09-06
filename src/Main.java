public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("NAB");
        bank.addBranch("Adelaide");
        bank.addCustomer("Adelaide", "Tim", 175.34);
        bank.addCustomer("Adelaide", "Mike", 50.05);
        bank.addCustomer("Adelaide", "Percy", 220.12);

        bank.addBranch("Sydney");
        bank.addCustomer("Sydney", "Bob", 150.54);

        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);

        bank.listCustomer("Adelaide", true);
        bank.listCustomer("Sydney", true);


        bank.addBranch("Melbourne");
        if(!bank.addCustomer("Melbourne", "Brian", 5.53)) {
            System.out.println("Error Melbourne branch does not exist");
        }
        if(!bank.addBranch("Adelaide")) {
            System.out.println("Adelaide branch already exists");
        }
        if(!bank.addCustomerTransaction("Adelaide", "Fergus", 52.33)) {
            System.out.println("Customer does not exist at this branch");
        }

    }
}
