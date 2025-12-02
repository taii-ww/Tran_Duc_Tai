import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class employeeManager {

    private Scanner sc = new Scanner(System.in);
    private QuanLyNhanVien qlNV = new QuanLyNhanVien();
    private QuanLyLuong qlLuong = new QuanLyLuong();
    private QuanLyHopDong qlHD = new QuanLyHopDong();

    // NHẬP NHÂN VIÊN
    public void NhapNhanVien() {
        employee e = null;

        System.out.println("\n=== NHAP THONG TIN NHAN VIEN ===");
        while (true) {
            System.out.println("P(PartTime) F(FullTime) X(Thoat) ");
            char type = sc.nextLine().toUpperCase().charAt(0);

            switch(type){
                case'P':
                  e = new partime();
                  break;
                case'F':
                  e = new fulltime();
                  break;
            }
            if(type == 'X')
              break;
            e.Nhap();
            qlNV.them(e);
            qlLuong.capNhatLuong(e);
        }
    }

    // MENU QUẢN LÝ NHÂN VIÊN
    public void QL_NhanVien() {
        while (true) {
            System.out.println("\n=== QUAN LY NHAN VIEN ===");
            System.out.println("1. Hien thi tat ca nhan vien");
            System.out.println("2. Tim kiem nhan vien theo ma");
            System.out.println("3. Xoa nhan vien theo ma");
            System.out.println("4. Thong ke so luong nhan vien theo loai");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Chon chuc nang: ");
            
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("\n--- DANH SACH TAT CA NHAN VIEN ---");
                    qlNV.xuatTatCa();
                    break;

                case "2":
                    System.out.print("Nhap ma nhan vien can tim: ");
                    String maTim = sc.nextLine();
                    employee e = qlNV.tim(maTim);
                    if (e != null) {
                        System.out.println("\n--- Thong tin nhan vien ---");
                        e.Xuat();
                    } else {
                        System.out.println("Khong tim thay nhan vien co ma: " + maTim);
                    }
                    break;

                case "3":
                    System.out.print("nhap ma nhan vien can xoa: ");
                    String maXoa = sc.nextLine();
                    employee removed = qlNV.xoa(maXoa);
                    if (removed != null) {
                        System.out.println("Đã xóa nhân viên mã: " + maXoa);
                    } else {
                        System.out.println("Không tìm thấy nhân viên để xóa!");
                    }
                    break;

                case "4":
                    System.out.println("\n--- THỐNG KÊ ---");
                    qlNV.thongKe();
                    break;

                case "0":
                    System.out.println("Quay lại menu chính...");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }

    // MENU QUẢN LÝ LƯƠNG
    public void QL_Luong() {
    while (true) {
        System.out.println("\n=== QUAN LY LUONG ===");
        System.out.println("1. Xem luong theo ma nhan vien");
        System.out.println("2. In bang luong toan cong ty");
        System.out.println("3. Xem tong luong cong ty");
        System.out.println("0. Quay lại");
        System.out.print("Chon: ");

        String chon = sc.nextLine();

        switch (chon) {
            case "1":
                System.out.print("Nhap ma nhan vien can xem luong: ");
                String maXem = sc.nextLine();
                qlLuong.xemLuongTheoMa(maXem);
                break;

            case "2":
                qlLuong.inBangLuong();
                break;

            case "3":
                System.out.printf("Tong Luong cong ty: %,15.0f VNĐ%n", qlLuong.tongLuongCongTy());
                break;

            case "0":
                return;

            default:
                System.out.println("Vui long chon tu 0-4!");
        }
    }
}

    // MENU QUAN LY HOP DONG 
public void QL_HopDong() {
    while (true) {
        System.out.println("\n=== QUAN LY HOP DONG ===");
        System.out.println("1. Ky hop dong moi");
        System.out.println("2. Gia han hop dong");
        System.out.println("3. Kiem tra hop dong sap het han");
        System.out.println("4. Xem thong tin hop dong theo ma nhan vien");
        System.out.println("0. Quay lai");
        System.out.print("Chon: ");

        String chon = sc.nextLine().trim();

        switch (chon) {

            case "1":
                System.out.print("Nhap ma nhan vien: ");
                String maNV = sc.nextLine();

                if (qlNV.tim(maNV) == null) {
                    System.out.println("Khong tim thay nhan vien!");
                    break;
                }

                qlHD.kyHopDong(maNV);
                break;

            case "2":
                System.out.print("Nhap ma nhan vien can gia han: ");
                String maGiaHan = sc.nextLine();

                System.out.print("Ngay het han moi : ");
                LocalDate moi = LocalDate.parse(sc.nextLine(),
                        DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                qlHD.giaHanHopDong(maGiaHan, moi);
                break;

            case "3":
                qlHD.kiemTraHopDongSapHetHan();
                break;

            case "4":
                System.out.print("Nhap ma nhan vien: ");
                String maXem = sc.nextLine();
                qlHD.xemHopDong(maXem);
                break;

            case "0":
                return;

            default:
                System.out.println("Vui long chon tu 0-4!");
        }
    }
}

}