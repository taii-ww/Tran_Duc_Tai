import java.util.Scanner;

public abstract class employee {
    
    protected String maNV;
    protected profile p = new profile();
    protected Scanner sc;

    public employee(){
        sc = new Scanner(System.in);
    }
    

    public void Nhap(){
        System.out.println("Nhap ma NV: ");
        maNV = sc.nextLine();
        p.Nhap(sc);
    }

    public void Xuat(){
        System.out.println("ma NV: "+maNV);
        p.Xuat();
    }
    

    public abstract double PhuCap();
    public abstract double ThucLinh();
}
