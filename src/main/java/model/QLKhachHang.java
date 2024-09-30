package model;

import gui.FileHelper;
import gui.FrmQLKhachHang;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import gui.FileHelper;
/**
 *
 * Họ tên sinh viên: Trần Nguyễn Tiên Thy
 */
public class QLKhachHang {

    private ArrayList<KhachHang> dsKhachHang;

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public QLKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

   
    public void DocKhachHang(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    String maso = parts[0];
                    String hoten = parts[1];
                    int sonhankhau = Integer.parseInt(parts[2]);
                    double chisocu = Double.parseDouble(parts[3]);
                    double chisomoi = Double.parseDouble(parts[4]);
                    KhachHang kh = new KhachHang(maso, hoten, sonhankhau, chisocu, chisomoi);
                    dsKhachHang.add(kh);
                } else {
                    System.out.println("Dòng dữ liệu không hợp lệ: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file: " + filename);
            throw e;
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
            throw e;
        }
    }

    public boolean GhiHoaDon(String filename) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        for (KhachHang kh:dsKhachHang){
            String line = kh.getMaso() + ";" + kh.getHoten() + ";" + kh.getTieuThu() + ";" + kh.tinhTienTra();
            lines.add(line);
        }
        return FileHelper.writeFile(filename, lines);
    }

   
    public void sapXepTheoMucTieuThu() {
        Collections.sort(dsKhachHang, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang kh1, KhachHang kh2) {
                return Double.compare(kh1.getTieuThu(), kh2.getTieuThu());
            }
        });
    }
    
    public double getTieuThuCaoNhat()
    {
      double max=0;
      return max;
    }
    
    public double getTieuThuThapNhat()
    {
       if (dsKhachHang.isEmpty()) {
            return 0;
        }
        double min = dsKhachHang.get(0).getTieuThu();
        for (KhachHang kh : dsKhachHang) {
            if (kh.getTieuThu() < min) {
                min = kh.getTieuThu();
            }
        }
        return min;     
    }
    
    public double getTieuThuTrungBinh()
    {
       if (dsKhachHang.isEmpty()) {
            return 0;
        }
        double tongTieuThu = 0;
        for (KhachHang kh : dsKhachHang) {
            tongTieuThu += kh.getTieuThu();
        }
        return tongTieuThu / dsKhachHang.size();
    }
}
