import java.util.HashMap;

public class QuanLyLuong {

    private HashMap<String, Double> bangLuong = new HashMap<>();

    // 1. Cập nhật lương cho một nhân viên
    public void capNhatLuong(employee e) {
        if (e == null) return;
        double luong = e.ThucLinh();
        bangLuong.put(e.maNV, luong);
    }

    // 2. Xem lương thực lĩnh của nhân viên theo mã
    public void xemLuongTheoMa(String maNV) {
        Double luong = bangLuong.get(maNV);
        if (luong != null) {
            System.out.printf("luong thuc linh cua nhan vien %s: %,15.0f VNĐ%n", maNV, luong);
        } else {
            System.out.println("ko tim thay luong nhan vien co ma: " + maNV + " (chưa cập nhật lương)");
        }
    }

    // 3. In bảng lương toàn công ty
    public void inBangLuong() {
        if (bangLuong.isEmpty()) {
            System.out.println("chua co du lieu luong nao!");
            return;
        }

        System.out.println("\n=== BANG LUONG TOAN CONG TY ===");
        System.out.println("MA NHAN VIEN     |   LUONG THUC LINH");
        System.out.println("--------------------------------------");
        for (String ma : bangLuong.keySet()) {
            System.out.printf("%-15s  |  %,15.0f VNĐ%n", ma, bangLuong.get(ma));
        }
    }

    // 4. Tổng lương phải trả cho toàn công ty
    public double tongLuongCongTy() {
        double tong = 0;
        for (double luong : bangLuong.values()) {
            tong += luong;
        }
        return tong;
    }
}