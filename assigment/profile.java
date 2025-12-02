import java.util.Scanner;

public class profile{

    private String hoTen;
    private String ngaySinh;
    private String gioiTinh;
    private String soDienThoai;
    private String email;

    public profile(){}

    public void Nhap(Scanner sc) {
        System.out.print("Ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("Ngay sinh: ");
        ngaySinh = sc.nextLine();
        System.out.print("Gioi tinh: ");
        gioiTinh = sc.nextLine();
        System.out.print("So dien thoai: ");
        soDienThoai = sc.nextLine();
        System.out.print("Email: ");
        email = sc.nextLine();
    }

    public void Xuat() {
        System.out.println("Ho ten: " + hoTen);
        System.out.println("Ngay sinh: " + ngaySinh);
        System.out.println("Gioi tinh: " + gioiTinh);
        System.out.println("SDT: " + soDienThoai);
        System.out.println("Email: " + email); 
    }
}