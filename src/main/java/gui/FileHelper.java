package gui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.util.ArrayList;

public class FileHelper {

    // Đọc nội dung từ file và trả về danh sách các dòng (mỗi dòng là một phần tử trong ArrayList)
    public static ArrayList<String> readFile(String filename) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);  // Thêm mỗi dòng đọc được vào danh sách
            }
        } finally {
            if (reader != null) {
                reader.close();  // Đóng file sau khi đọc
            }
        }
        return lines;
    }

    // Ghi danh sách các dòng (ArrayList<String>) vào file
    public static boolean writeFile(String filename, ArrayList<String> lines) throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            for (String line : lines) {
                writer.write(line);   // Ghi từng dòng vào file
                writer.newLine();     // Xuống dòng sau mỗi dòng
            }
        } finally {
            if (writer != null) {
                writer.close();  // Đóng file sau khi ghi
            }
        }
        return true;
    }
}
