import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        Main.plano.paintSQRFunc(Main.plano.getGraphics(),-0.2,2,-15,-200,200);

    }
}
