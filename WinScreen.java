import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WinScreen extends JFrame implements ActionListener{

    public WinScreen(String winner){
        setTitle("Connect 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        Container contentPane = getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        contentPane.setLayout(gridbag);
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel winLabel = new JLabel(winner + " is the Winner!");
        winLabel.setForeground(Color.green);
        winLabel.setFont(new Font("Arial", Font.BOLD, 34));
        c.ipady = 40;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        gridbag.setConstraints(winLabel, c);
        contentPane.add(winLabel);

        JButton button = new JButton("New Game");
        button.addActionListener(this);
        c.ipady = 0;
        c.anchor = GridBagConstraints.SOUTH;
        c.gridx = 1;
        c.gridwidth = 3;
        c.gridy = 2;
        gridbag.setConstraints(button, c);
        contentPane.add(button);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        GameScreen gui = new GameScreen();
        gui.setVisible(true);
        dispose();
    }

}