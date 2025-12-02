import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

public class QuanLyHopDong {

    private HashMap<String, HopDong> dsHopDong = new HashMap<>();
    private DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private Scanner sc = new Scanner(System.in);

    // 1. Ký hợp đồng
    public void kyHopDong(String maNV) {
        HopDong hd = new HopDong();
        hd.Nhap(sc);
        dsHopDong.put(maNV, hd);
        System.out.println(">> Da ky hop dong!");
    }

    // 2. Gia hạn hợp đồng
    public void giaHanHopDong(String maNV, LocalDate ngayHetHanMoi) {
        HopDong hd = dsHopDong.get(maNV);
        if (hd == null) {
            System.out.println("Khong tim thay hop dong cua nhan vien: " + maNV);
            return;
        }

        hd.setNgayHetHan(ngayHetHanMoi);

        System.out.printf(">> Da gia han hop dong den ngay %s%n",
                ngayHetHanMoi.format(df));
    }

    // 3. Hợp đồng sắp hết hạn
    public void kiemTraHopDongSapHetHan() {
        LocalDate homNay = LocalDate.now();
        LocalDate gioiHan = homNay.plusDays(30);

        System.out.println("\n=== HOP DONG SAP HET HAN (trong 30 ngay) ===");

        boolean co = false;

        for (String maNV : dsHopDong.keySet()) {
            HopDong hd = dsHopDong.get(maNV);
            LocalDate hetHan = hd.getNgayHetHan();

            if (hetHan.isAfter(homNay) && hetHan.isBefore(gioiHan.plusDays(1))) {
                System.out.printf("Ma NV: %s | Loai HD: %s | Het han: %s%n",
                        maNV, hd.getLoaiHopDong(), hetHan.format(df));
                co = true;
            }
        }

        if (!co) {
            System.out.println("Khong co hop dong nao sap het han.");
        }
    }

    // 4. Xem hợp đồng
    public void xemHopDong(String maNV) {
        HopDong hd = dsHopDong.get(maNV);
        if (hd == null) {
            System.out.println("Nhan vien " + maNV + " chua co hop dong!");
            return;
        }

        System.out.println("\n--- THONG TIN HOP DONG CUA NV: " + maNV + " ---");
        hd.Xuat();

        if (LocalDate.now().isAfter(hd.getNgayHetHan())) {
            System.out.println("Trang thai     : DA HET HAN");
        } else {
            System.out.println("Trang thai     : CON HAN");
        }
    }
}
