import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller extends JFrame {
    private JPanel ControlPanel;
    private JButton startButton;
    private JButton stopButton;

    public Controller() {
        add(ControlPanel);

        setTitle("Don't sleep");
        setSize(200, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread thread = new Thread(new Mouse());
                thread.start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mouse.switcher = false;
            }
        });
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        Mouse.switcher = false;
    }
}
