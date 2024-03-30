import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass {
    public static void main(String args[]){
        GuiMain obj = new GuiMain();
    }
}
class GuiMain extends JFrame {
    JLabel l;
    public GuiMain() {

        JFrame f=new JFrame();

        f.setTitle("steganograpy");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l=new JLabel("Image Steganograpy");
        l.setFont(new Font("Courier BOLD",Font.BOLD,50));
        l.setForeground(Color.DARK_GRAY);
        l.setBounds(265, 125, 500, 70);
        f.add(l);




        JButton encodeButton = new JButton("Encode");
        encodeButton.setBounds(450,235,150,50);
        f.setFont(new Font("Italic",Font.ITALIC,20));
        encodeButton.setBackground(Color.LIGHT_GRAY);
        encodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Encode();
                dispose();
            }
        });
        JButton DecodeButton = new JButton("Decode");
        f.setFont(new Font("Italic",Font.ITALIC,20));
        DecodeButton.setBounds(450,315,150,50);
        DecodeButton.setBackground(Color.LIGHT_GRAY);
        DecodeButton.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Decode();
                dispose();
            }
        }));

        f.add(encodeButton);
        f.add(DecodeButton);

        ImageIcon background_image = new ImageIcon("C:/Users/DELL/Desktop/Steganogr.jpg");
        f.add(new JLabel(background_image));
        f.pack();
        f.setBounds(500,30,1000,700);
        f.setVisible(true);
        f.setLayout(null);


    }
}
