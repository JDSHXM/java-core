package Lesson3;

import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {
    private String accNumber;
    private String fio;
    private double balance;

    public BankSystem(String accNumber, String fio, double balance) {
        this.accNumber = accNumber;
        this.fio = fio;
        this.balance = balance;


    }
    private static ArrayList<BankSystem> accounts = new ArrayList<>();




    public void getAccInfo(){
        System.out.println("BankSystem{" +
                "accNumber='" + accNumber + '\'' +
                ", fio='" + fio + '\'' +
                ", balance=" + balance +
                '}');
    }
    public static BankSystem findByAcc(String accNumber){
        for (BankSystem bs : accounts){
            if(bs.accNumber.equals(accNumber)) return bs;
        }
        return null;
    }
    public static void addAccount(String accNumber, String fio, double balance){
        if(findByAcc(accNumber) != null){
            System.out.println("this account number already exists! ");

        }
        BankSystem acc = new BankSystem(accNumber, fio, balance);
        accounts.add(acc);
        System.out.println(fio+ ", your account added added successfully ");

    }
    public static void deleteAcc(String accNumber){
        BankSystem acc = findByAcc(accNumber);
        if(acc != null){
            accounts.remove(acc);
            System.out.println("account deleted: "+ accNumber);
        }else{
            System.out.println("acc not found");
        }
    }
    public void replenish(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println(accNumber+ " replenished by "+ amount+ ". current balance: "+ balance);
        } else {
            System.out.println("insufficient amount!");
        }
    }
    public static void transferMoney(String fromAcc, String toAcc, double amount){
        BankSystem acc1 = findByAcc(fromAcc);
        BankSystem acc2= findByAcc(toAcc);

        if(acc1 == null || acc2 == null) System.out.println(" one of the acc numbers not found");

        if(acc1.balance>= amount){
            acc1.balance-=amount;
            acc2.balance+=amount;

            System.out.println("transfer amount "+ amount +" from account "+ fromAcc+ " to  account "+ toAcc);
        } else{
            System.out.println("insufficient funds");
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        addAccount("123","EFG H", 50000);
        addAccount("121","ABC D", 20000);

        while(true){
            System.out.println("1) add account  2) delete account  3) show all accounts 4) replenish  5) transfer  6) exit ");
            int choice= scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("enter account number: ");
                    String accNum= scanner.nextLine();
                    System.out.println("FIO: ");
                    String fio = scanner.nextLine();
                    System.out.println("enter primary balance: ");
                    double balance = scanner.nextDouble();
                    addAccount(accNum, fio, balance);
                    break;

                case 2:
                    System.out.println(" acc number to delete: ");
                    String delAcc = scanner.nextLine();
                    deleteAcc(delAcc);
                    break;

                case 3:
                    for(BankSystem acc: accounts) acc.getAccInfo();
                    break;

                case 4:
                    System.out.println("enter acc number: ");
                    String accNumRepl = scanner.nextLine();
                    BankSystem acc = findByAcc(accNumRepl);
                    if(acc != null){
                        System.out.println("enter the amount: ");
                        double sum = scanner.nextDouble();
                        acc.replenish(sum);

                    }else{
                        System.out.println("account not found");
                    }
                    break;

                case 5:
                    System.out.println("enter the sender acc number: ");
                    String from = scanner.nextLine();
                    System.out.println("enter receiver acc number: ");
                    String to = scanner.nextLine();
                    System.out.println("enter transfer amount: ");
                    double amount = scanner.nextDouble();
                    transferMoney(from, to , amount);
                    break;

                case 6:
                    System.out.println("exiting...");
                    return;
            }
        }
    }
}
