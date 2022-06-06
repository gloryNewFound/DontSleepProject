import java.awt.*;
import java.util.Random;

public class Mouse implements Runnable{
    public static Boolean switcher = false;
    private final int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;
    private final int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2;

    @Override
    public void run() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {

        }
        switcher = true;

        while (switcher) {
            try {
                Random random1 = new Random();
                int a = random1.nextInt(1000) - 500;
                for (int i = Math.min(a,0); i < Math.max(0,a); i++) {
                    Thread.sleep(2);
                    robot.mouseMove(x + i, y);
                }
                Thread.sleep(10000);
                for (int i = Math.max(0,a); i > Math.min(a,0) ; i--) {
                    Thread.sleep(2);

                    robot.mouseMove(x + i, y);
                }
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
