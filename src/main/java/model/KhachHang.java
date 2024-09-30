package model;

/**
 *
 * Họ tên sinh viên: Trần Nguyễn Tiên Thy
 */
public class KhachHang {

    private String maso;
    private String hoten;
    private int sonhankhau;
    private double chisocu;
    private double chisomoi;

    //constructor
    public KhachHang() {
    }

    public KhachHang(String maso) {
        this.maso = maso;
    }

    public KhachHang(String maso, String hoten, int sonhankhau, double chisocu, double chisomoi) {
        this.maso = maso;
        this.hoten = hoten;
        this.sonhankhau = sonhankhau;
        this.chisocu = chisocu;
        this.chisomoi = chisomoi;
    }

    //setter và getter
    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getSonhankhau() {
        return sonhankhau;
    }

    public void setSonhankhau(int sonhankhau) {
        this.sonhankhau = sonhankhau;
    }

    public double getChisocu() {
        return chisocu;
    }

    public void setChisocu(double chisocu) {
        this.chisocu = chisocu;
    }

    public double getChisomoi() {
        return chisomoi;
    }

    public void setChisomoi(double chisomoi) {
        this.chisomoi = chisomoi;
    }

    //phương thức tính toán    
    public double getTieuThu() {
        return chisomoi - chisocu;
    }

    public int getDinhMuc() {
        return sonhankhau * 4;
    }

    public double tinhTienTra() {
        double tieuThu = getTieuThu();
        int dinhMuc = getDinhMuc();
        double giaBan;
        if (tieuThu <= dinhMuc) {
            giaBan = tieuThu * 6700;
        } else if (tieuThu <= dinhMuc + 2) {
            giaBan = dinhMuc * 6700 + (tieuThu - dinhMuc) * 12900;
        } else {
            giaBan = dinhMuc * 6700 + 2 * 12900 + (tieuThu - dinhMuc - 2) * 14400;
        }

        double thueGTGT = 0.05 * giaBan;
        double phiTDVTN = 0.25 * giaBan;
        double thueTDVTN = 0.08 * phiTDVTN;

        return giaBan + thueGTGT + phiTDVTN + thueTDVTN;
    }

}
