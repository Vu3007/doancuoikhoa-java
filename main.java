import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);
        String fileName = "user.json";
        userService.startProgram(scanner, fileName);
        System.out.println("Nhap lua chon cua ban:");
    }
}
