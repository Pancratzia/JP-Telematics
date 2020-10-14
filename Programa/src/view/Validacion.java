package view;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.ToggleButtonBorder;

public class Validacion {

	public void ValidarCantidad(JTextField tx, int longi) {
		tx.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {

				if (tx.getText().length() >= longi) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});

	}

}
