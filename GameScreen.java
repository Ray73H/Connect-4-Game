import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameScreen extends JFrame implements ActionListener{
    public static final int ROWS = 6;
    public static final int COLUMNS = 7;
    public static final int CELL_SIZE = 100; // width and height of each cell

    private JButton[][] buttons; // 2D array of buttons representing the game grid

    private JLabel player1;
    private JLabel player2;
    private JLabel turnLabel;

    private Board board;
    private int turn = 0;

    private String winner = "";

    public GameScreen() {
        setTitle("Connect 4");
        setSize(COLUMNS * CELL_SIZE, ROWS * CELL_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(ROWS + 1, COLUMNS));

        buttons = new JButton[ROWS][COLUMNS];
        board = new Board(ROWS, COLUMNS);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                JButton button = new JButton();
                button.addActionListener(this);
                button.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                buttons[i][j] = button;
                add(button);
            }
        }

        JLabel empty = new JLabel();
        add(empty);
        JLabel empty1 = new JLabel();
        add(empty1);
        player1 = new JLabel("Player 1", SwingConstants.CENTER);
        player1.setForeground(Color.red);
        player1.setFont(new Font("Arial", Font.BOLD, 20));
        add(player1);
        turnLabel = new JLabel("<--turn", SwingConstants.CENTER);
        turnLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(turnLabel);
        player2 = new JLabel("Player 2", SwingConstants.CENTER);
        player2.setFont(new Font("Arial", Font.BOLD, 20));
        add(player2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if(e.getSource() == buttons[i][j]){
                    if(!board.isValid(i,j))
                        return;
                    if(turn%2 == 0){
                        buttons[i][j].setBackground(Color.red);
                        board.addPiece(i, j, true);
                        turnLabel.setText("turn-->");
                        player1.setForeground(Color.black);
                        player2.setForeground(Color.yellow);
                    }else{
                        buttons[i][j].setBackground(Color.yellow);
                        board.addPiece(i, j, false);
                        turnLabel.setText("<--turn");
                        player1.setForeground(Color.red);
                        player2.setForeground(Color.black);
                    }
                    if(board.checkWin()){
                        if(turn%2 == 0)
                            winner = "Player 1";
                        else
                            winner = "Player 2";
                        WinScreen frame = new WinScreen(winner);
                        frame.setVisible(true);
                        dispose();
                    }
                    turn++;
                }
            }
        }
    }
}
