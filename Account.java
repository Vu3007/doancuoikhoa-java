import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account  {
    String fullname, stk, phoneNumber, address;
    int money;

    List<Receiver> receiverList = new ArrayList<>();
    List<Transfer> transferList = new ArrayList<>();
    List<ticketTrain>ticketTrainList=new ArrayList<>();

    public Account() {
    }

    public Account(String fullname, String stk, String phoneNumber, String address, int money) {
        this.fullname = fullname;
        this.stk = stk;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.money = money;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Receiver> getReceiverList() {
        return receiverList;
    }

    public List<Transfer> getTransferList() {
        return transferList;
    }
    public List<ticketTrain>getTicketTrainList(){
        return ticketTrainList;
    }

    public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap Ho & Ten: ");
        fullname = scan.nextLine();

        System.out.println("Nhap STK: ");
        stk = scan.nextLine();

        System.out.println("Nhap SDT: ");
        phoneNumber = scan.nextLine();

        System.out.println("Nhap dia chi: ");
        address = scan.nextLine();

        money = 0;
    }

    public void addReceiver() {
        Receiver receiver = new Receiver();
        receiver.input();

        receiverList.add(receiver);

        //Cong tien vao tai khoan
        money += receiver.getMoney();
    }

    public void transfer() {
        Transfer transfer = new Transfer();
        transfer.input(money);

        transferList.add(transfer);

        //Tru tien trong TK
        money -= transfer.getMoney();
    }

    public void displayReceiverHistory() {
        System.out.println("Lich su nhan tien: ");
        receiverList.forEach((receiver) -> {
            receiver.display();
        });
    }

    public void displayTransferHistory() {
        System.out.println("Lich su chuyen tien: ");
        transferList.forEach((transfer) -> {
            transfer.display();
        });
    }
    public void TicketTrainList(){
        ticketTrain TicketTrain=new ticketTrain();
        TicketTrain.input(money);
     ticketTrainList.add(TicketTrain);


    }
    public void displayHistoryTicketTrain(){
        System.out.println("Lịch sử đặt vé");
        ticketTrainList.forEach((ticketTrain) ->ticketTrain.display() );
        money -=30000;
        System.out.println("Số tiền còn lại là: "+money);
    }

    @Override
    public String toString() {
        return "Account{" + "fullname=" + fullname + ", stk=" + stk + ", phoneNumber=" + phoneNumber + ", address=" + address + ", money=" + money + '}';
    }

    public void display() {
        System.out.println(toString());

//        displayReceiverHistory();
//
//        displayTransferHistory();
    }
}

