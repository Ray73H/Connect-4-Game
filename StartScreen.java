import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartScreen extends JFrame implements ActionListener{

    private JLabel rule;

    public StartScreen(){
        setTitle("Connect 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(12,0));
        setSize(700, 600);

        //title
        JLabel title = new JLabel("Connect 4");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title);
        
        //rule
        rule = new JLabel("Rules:");
        rule.setFont(new Font("Arial", Font.BOLD, 16));
        rule.setHorizontalAlignment(JLabel.CENTER);
        add(rule);

        //rule1
        rule = new JLabel("1. Connect Four is a two-player game");
        rule.setFont(new Font("Arial", Font.BOLD, 12));
        rule.setHorizontalAlignment(JLabel.CENTER);
        add(rule);

        //rule2
        rule = new JLabel("2. Each player takes turns dropping a colored disc into the grid");
        rule.setFont(new Font("Arial", Font.BOLD, 12));
        rule.setHorizontalAlignment(JLabel.CENTER);
        add(rule);

        //rule3
        rule = new JLabel("3. The discs fall straight down and occupy the lowest available space in the column");
        rule.setFont(new Font("Arial", Font.BOLD, 12));
        rule.setHorizontalAlignment(JLabel.CENTER);
        add(rule);

        //rule4
        rule = new JLabel("4. The objective of the game is to connect four of your own discs in a row, column, or diagonal");
        rule.setFont(new Font("Arial", Font.BOLD, 12));
        rule.setHorizontalAlignment(JLabel.CENTER);
        add(rule);

        //rule5
        rule = new JLabel("5. Players may only drop one disc per turn");
        rule.setFont(new Font("Arial", Font.BOLD, 12));
        rule.setHorizontalAlignment(JLabel.CENTER);
        add(rule);

        //rule6
        rule = new JLabel("6. If a player drops a disc and it lands on top of another disc, the move is invalid");
        rule.setFont(new Font("Arial", Font.BOLD, 12));
        rule.setHorizontalAlignment(JLabel.CENTER);
        add(rule);

        //rule7
        rule = new JLabel("7. If a player drops a disc and it fills the entire column, the move is invalid");
        rule.setFont(new Font("Arial", Font.BOLD, 12));
        rule.setHorizontalAlignment(JLabel.CENTER);
        add(rule);

        //rule8
        rule = new JLabel("8. If the grid is completely filled and no player has connected four discs, the game is a draw");
        rule.setFont(new Font("Arial", Font.BOLD, 12));
        rule.setHorizontalAlignment(JLabel.CENTER);
        add(rule);

        //rule9
        rule = new JLabel("9. The player who successfully connects four of their discs in a row, column, or diagonal wins the game");
        rule.setFont(new Font("Arial", Font.BOLD, 12));
        rule.setHorizontalAlignment(JLabel.CENTER);
        add(rule);

        //button
        JButton button = new JButton("Start Game");
        button.addActionListener(this);
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameScreen gui = new GameScreen();
        gui.setVisible(true);
        dispose();
    }

}