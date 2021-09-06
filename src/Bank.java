import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    private Branch findBranch(String branch) {
        for(int i = 0; i < branches.size(); i++) {
            Branch checkBranch = this.branches.get(i);
            if(checkBranch.getName().equals(branch)) {
                return checkBranch;
            }
        }
        return null;
    }

    public boolean addBranch(String branchName) {
        Branch branch = findBranch(branchName);
        if(branch == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customer, double transaction) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.newCustomer(customer, transaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customer, double transaction) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.addTransaction(customer, transaction);
        }
        return false;
    }

    public boolean listCustomer(String branchName, boolean showTransaction) {
        Branch branch = findBranch(branchName);

        if(branch != null) {
            System.out.println("Customer details for branch " + branchName);
            ArrayList<Customer> branchCustomers = branch.getCustomers();

            for(int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");

                if(showTransaction) {
                    System.out.println("Transactions");
                    ArrayList<Double> transaction = branchCustomer.getTransactions();
                    for(int j = 0; j < transaction.size(); j++) {
                        System.out.println("[" + (j+1) + "] Amount " + transaction.get(j));
                    }
                }
            }
            return true;
        }
        return false;
    }
}
