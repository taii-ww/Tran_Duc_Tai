import java.util.HashMap;

public class QuanLyNhanVien {

    private HashMap<String, employee> ds = new HashMap<>();

    public void them(employee e){
        ds.put(e.maNV, e);
    }

    public employee tim(String ma){
        return ds.get(ma);
    }

    public employee xoa(String ma){
        return ds.remove(ma);
    }

    public void xuatTatCa(){
        for(employee e : ds.values()){
            e.Xuat();
            System.out.println("----------------------");
        }
    }

    public void thongKe(){
        int pt = 0, ft = 0;
        for(employee e : ds.values()){
            if(e instanceof partime) pt++;
            if(e instanceof fulltime) ft++;
        }
        System.out.println("Tong NV: " + ds.size());
        System.out.println("PartTime: " + pt);
        System.out.println("FullTime: " + ft);
    }

    public HashMap<String, employee> getDanhSach(){
        return ds;
    }
}

