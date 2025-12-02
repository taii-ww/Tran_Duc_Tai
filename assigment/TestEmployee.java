import java.util.Scanner;

public class TestEmployee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        employeeManager ql = new employeeManager();

        int choice;
        do {
          System.out.println("\n===== MENU QUAN LY  =====");
          System.out.println("1. Nhap nhan vien");
          System.out.println("2. Quan Ly Nhan Vien");
          System.out.println("3. Quan Ly Luong");
          System.out.println("4. Quan ly hop dong");
          System.out.println("0. Thoat");
          System.out.print("Chon chuc nang: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    ql.NhapNhanVien();
                    break;
                case 2:
                    ql.QL_NhanVien();
                    break;
                case 3:
                    ql.QL_Luong();
                    break;
                case 4:
                    ql.QL_HopDong();
                    break;
                case 0:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);

        sc.close();
    }
}
