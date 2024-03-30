
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBconnectivity {
    public static void main(String args[]) {
        DBconnectivity db = new DBconnectivity();

    }
   public static void Database(String path){

       try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/images","root","");
            File file=new File(path);
            FileInputStream fis=new FileInputStream(file);
            PreparedStatement ps = con.prepareStatement("insert into E_image_table (name,images) values(?,?)");


            ps.setString(1, "name " );
            ps.setBinaryStream(2, fis, (int) file.length());
            ps.executeUpdate();


            ps.close();
            fis.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
