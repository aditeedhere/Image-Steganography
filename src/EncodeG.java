
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class EncodeG {
    public static void main(String args[]){
        Encode e = new Encode();

    }
}

class Encode extends JFrame implements ActionListener{
    public static File imageFile;
    public static String path;

    public Encode(){
        JFrame f1 = new JFrame();
        f1.setBounds(400,70,500,500);
        f1.setTitle("Encode");
        f1.getContentPane().setBackground(Color.lightGray);
        JLabel l1 = null;
        try {
            l1 = new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\DELL\\IdeaProjects\\Steganography\\src\\img_7.png"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        l1.setFont(new Font("Times New Roman",Font.BOLD,20));
        l1.setBounds(10,10,50,10);
        l1.setVerticalAlignment(SwingConstants.TOP);
        l1.setText("  \n\n Enter Text:  ");
        l1.setForeground(Color.lightGray);
        f1.add(l1);

        JTextField t1 = new JTextField();
        t1.setBounds(40,40,400,150);
        t1.setBackground(Color.lightGray);
        t1.setFont(new Font("Times New Roman",Font.BOLD,17));
        l1.add(t1);

        JButton b1 =new JButton();
        b1.setText("Browse");
        b1.setBackground(Color.lightGray);
        b1.setFont(new Font("Times New Roman",Font.BOLD,17));
        b1.setBounds(40,250,100,40);
        l1.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imageFile = FileChooser.MakeFileChooser();
                path = imageFile.toString();
                DBconnectivity.Database(path);

            }

        });


        JButton b2 = new JButton();
        b2.setText("Close");
        b2.setFont(new Font("Times New Roman",Font.BOLD,17));
        b2.setBackground(Color.lightGray);
        b2.setBounds(335,250,100,40);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
            }
        });
        l1.add(b2);


        JButton b3 = new JButton();
        b3.setText("Encrypt");
        b3.setBackground(Color.lightGray);
        b3.setBounds(185,250,100,40);
        b3.setFont(new Font("Times New Roman",Font.BOLD,17));
        l1.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(imageFile != null);{
                    EncryptLSB.Encrypt(imageFile,t1.getText());
                }
                JOptionPane.showMessageDialog(null, "Image encoded succesfully");
            }
        });

        f1.setVisible(true);
        f1.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
