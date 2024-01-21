import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


    public class Receiver  {
        int money;
        String note;
        Date createdAt;

        public Receiver() {
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        public void input() {
            System.out.println("Nhap thong tin nap tien:");
            Scanner scan = new Scanner(System.in);

            System.out.println("Nhap so tien: ");
            money = Integer.parseInt(scan.nextLine());

            System.out.println("Nhap noi dung ghi chu: ");
            note = scan.nextLine();

            createdAt = new Date();

        }

        @Override
        public String toString() {
            return "Receiver{" + "money=" + money + ", note=" + note + ", createdAt=" + getCreatedAtString() + '}';
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


