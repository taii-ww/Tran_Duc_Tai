public class partime extends employee{
    
    private int soGioLam;
    private double LuongTheoGio;

    public partime(){
        super();
    }

    public void Nhap(){
        super.Nhap();
        System.out.println("Nhap so gio lam: ");
        soGioLam = sc.nextInt();
        System.out.print("Nhap luong theo gio: ");
        LuongTheoGio = sc.nextDouble();
        sc.nextLine();
    }

    @Override
    public double PhuCap(){
        if(soGioLam >= 100)
          return 300000;
        return 0;
    }

    @Override
    public double ThucLinh(){
        return (soGioLam * LuongTheoGio) + PhuCap();
    }

    public void Xuat() {
        super.Xuat();
        System.out.println("So gio lam: " + soGioLam);
        System.out.println("Luong theo gio: " + LuongTheoGio);
       // System.out.println("Thuc linh: " + ThucLinh());

    }

   
}
