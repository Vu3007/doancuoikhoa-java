import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Transfer {
    String transferStk, note;
    int money;
    Date createdAt;

    public Transfer() {
    }

    public String getTransferStk() {
        return transferStk;
    }

    public void setTransferStk(String transferStk) {
        this.transferStk = transferStk;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void display() {
        System.out.println(toString());
    }

    public void input(int maxMoney) {
        System.out.println("Nhap thong tin nguoi nhan:");
        Scanner scan = new Scanner(System.in);

        System.out.println("Nhap STK nhan: ");
        transferStk = scan.nextLine();

        for (; ; ) {
            System.out.println("Nhap so tien: ");
            money = Integer.parseInt(scan.nextLine());

            if (money <= maxMoney) {
                System.out.println("Chuyển tiền thành công!!");
                break;
            }
            System.err.println("So tien chuyen vuot qua so tien trong TK");
        }

        System.out.println("Nhap noi dung ghi chu: ");
        note = scan.nextLine();

        createdAt = new Date();
    }

    @Override
    public String toString() {
        return "Transfer{" + "transferStk=" + transferStk + ", note=" + note + ", money=" + money + ", createdAt=" + getCreatedAtString() + '}';
    }

    public String getCreatedAtString() {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        String str = format.format(createdAt);

        return str;
    }
}

