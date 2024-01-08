import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

public abstract class AUserManager {
    abstract void userChangeUsername(Scanner scanner, User user, String fileName);

    abstract void userChangeEmail(Scanner scanner, User user, String fileName) throws Exception;

    abstract void userChangePassword(Scanner scanner, User user, String fileName);

    abstract void userLogout(Scanner scanner, String fileName);

    // Ghi Object JSON file (Object là 1 đối tượng bất kỳ : Có thể là Single Object hoặc List Object)
    public void convertObjectToJsonFile(String fileName, Object obj) {
        try {
            // Tạo đối tượng gson
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Tạo đối tượng Writer để ghi nội dung vào file
            Writer writer = Files.newBufferedWriter(Paths.get(fileName));

            // Ghi object vào file
            gson.toJson(obj, writer);

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getListObjectFromJsonFile(String fileName) {
        try {
            // Khởi tạo đối tượng gson
            Gson gson = new Gson();

            // Tạo đối tượng reader để đọc file
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            // Đọc thông tin từ file và binding và class

            //check file khong co data => list rong
            User[] userArr = gson.fromJson(reader, User[].class);
            if (userArr == null) {
                return Collections.emptyList(); //tuong duong List<User> users = new ArrayList<>();
            } else {
                List<User> users = Arrays.asList(userArr);
                // Đọc file xong thì đóng lại
                // Và trả về kết quả
                reader.close();
                return users;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    boolean checkLegalEmail(String email) {
        String EMAIL_PATTERN =
                "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        return Pattern.matches(EMAIL_PATTERN, email);
    }

    boolean isExistsEmail(String fileName, String email) {
        List<User> users = getListObjectFromJsonFile(fileName);
        Optional<List<User>> usersOptional = Optional.ofNullable(users);
        if (usersOptional.isPresent()) {
            for (User user :
                    users) {
                if (user.getEmail().equals(email)) {
                    return true;
                }
            }
        }
        return false;
    }

    String checkPassword(Scanner scanner) {
        while (true) {
            String password = scanner.nextLine();
            Pattern pattern = Pattern.compile("\\S{7,15}");
            boolean isPassword = pattern.matcher(password).matches();
            if (!isPassword) {
                System.out.println("Mat khau khong hop le!\nVui long nhap lai!");
            } else {
                System.out.println("Thong tin da duoc cap nhat!");
                return password;

            }
        }
    }

    int checkIntNumber(Scanner scn) {
        while (!scn.hasNextInt()) {
            System.out.println("Ban can nhap vao 1 so nguyen!");
            scn.next();
        }
        return scn.nextInt();
    }
}