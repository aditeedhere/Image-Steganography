import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class DecodeG {
    public static void main(String args[]) {
        Decode e = new Decode();
    }
}
    class Decode extends JFrame implements ActionListener {
    public Decode() {
        JFrame f2 = new JFrame();
        f2.setTitle("Decode");
        f2.getContentPane().setBackground(Color.GRAY );
        f2.setBounds(400,0,500,500);

        JLabel l2;
        try {
            l2 = new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\DELL\\IdeaProjects\\Steganography\\src\\img_7.png"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        l2.setText("Encoded Text");
        l2.setForeground(Color.white);
        l2.setFont(new Font("Times New Roman",Font.BOLD,20));
        l2.setVerticalAlignment(SwingConstants.TOP);

        JTextField t2 = new JTextField();
        t2.setBounds(40,40,400,145);
        t2.setFont(new Font("Times New Roman",Font.BOLD,17));

        JButton b1 =new JButton();
        b1.setText("Decode");
        b1.setFont(new Font("Times New Roman",Font.BOLD,17));
        b1.setBounds(80,250,100,40);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DecryptLSB.Decrypt();
                   String msg = DecryptLSB.Message();
                   t2.setText(msg);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Data Decoded succesfully");
            }
        });
        l2.add(b1);


        JButton b2 = new JButton();
        b2.setText("Close");
        b2.setFont(new Font("Times New Roman",Font.BOLD,17));
        b2.setBounds(300,250,100,40);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(false);
            }
        });
        l2.add(b2);

        l2.add(t2);

        f2.add(l2);
        f2.setVisible(true);

    }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }