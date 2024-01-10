import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ticketTrain {

    private  String name;
    private int cccd;
    private int soGhe;
    private int money;
    Date createdAt;
    public ticketTrain(){

    }

    public ticketTrain(String name, int cccd, int soGhe) {
        this.name = name;
        this.cccd = cccd;
        this.soGhe = soGhe;
        this.money=money;
    }
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCccd() {
        return cccd;
    }

    public void setCccd(int cccd) {
        this.cccd = cccd;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public  void input(int maxMoney){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập Ho & Ten");
        name= sc.nextLine();
        System.out.println("Nhập số cccd");
        cccd=sc.nextInt();
        System.out.println("Nhập số ghế");
        soGhe= sc.nextInt();
        System.out.println("Giá vé là 30000");
        for (; ; ) {


            if (maxMoney >= 30000) {
                System.out.println("Đặt vé thành công!!");
                break;
            }
            System.err.println("TK không đủ tiền!");
            break;
        }

    }

    @Override
    public String toString() {
        return "ticketTrain{" +
                "name='" + name + '\'' +
                ", cccd='" + cccd + '\'' +
                ", soGhe=" + soGhe +
                '}';
    }
    public String getCreatedAtString() {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        String str = format.format(createdAt);

        return str;
    }
    public void display() {
        System.out.println(toString());
    }

}
