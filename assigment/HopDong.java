import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HopDong {

    private String loaiHopDong;
    private LocalDate ngayBatDau;
    private LocalDate ngayHetHan;

    private DateTimeFormatter df = DateTimeFormatter.ofPattern("d-M-yyyy");


    public HopDong() {}

    public HopDong(String loai, LocalDate batDau, LocalDate hetHan) {
        this.loaiHopDong = loai;
        this.ngayBatDau = batDau;
        this.ngayHetHan = hetHan;
    }

    // ======= NHAP =======
    public void Nhap(Scanner sc) {
        System.out.print("Loai hop dong: ");
        loaiHopDong = sc.nextLine();

        System.out.print("Ngay bat dau : ");
        ngayBatDau = LocalDate.parse(sc.nextLine(), df);

        System.out.print("Ngay het han : ");
        ngayHetHan = LocalDate.parse(sc.nextLine(), df);
    }

    // ======= XUAT =======
    public void Xuat() {
        System.out.println("Loai hop dong : " + loaiHopDong);
        System.out.println("Ngay bat dau  : " + ngayBatDau.format(df));
        System.out.println("Ngay het han  : " + ngayHetHan.format(df));
    }

    // getter dùng cho QuanLyHopDong
    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public String getLoaiHopDong() {
        return loaiHopDong;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayHetHan(LocalDate moi) {
        ngayHetHan = moi;
    }
}
