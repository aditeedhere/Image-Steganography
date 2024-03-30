import java.io.FileOutputStream;
import java.sql.*;

public class Retrieve {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost/images","root","");

            PreparedStatement ps=con.prepareStatement("select * from e_image_table");
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {

                Blob b = rs.getBlob(2);
                byte barr[] = b.getBytes(1, (int) b.length());

                FileOutputStream fout = new FileOutputStream("C://Users/DELL/Desktop/image.jpg");
                fout.write(barr);

                fout.close();
            }
            System.out.println("Image Retrived Succesfully");

            con.close();
        }catch (Exception e) {e.printStackTrace();  }
    }
}
