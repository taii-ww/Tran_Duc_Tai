
public class fulltime extends employee {
    
    private double LuongCoBan;
    private int soNamCongTac;

    public fulltime(){
        super();
    }

    public void Nhap() {
        super.Nhap();
        System.out.print("Luong co ban: ");
        LuongCoBan = Double.parseDouble(sc.nextLine());
        System.out.print("So nam cong tac ");
        soNamCongTac = Integer.parseInt(sc.nextLine());
    }

    @Override
    public double PhuCap(){
        return 0.01*soNamCongTac*LuongCoBan;
    }
    
    @Override
    public double ThucLinh(){
        return LuongCoBan + PhuCap();
    }

     public void Xuat() {
        super.Xuat();
        System.out.println("Luong co ban: " + LuongCoBan);
        System.out.println("So nam cong tac: " + soNamCongTac);
        //System.out.println("Thuc linh: " + ThucLinh());
    }



}
