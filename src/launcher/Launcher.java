package launcher;

import javax.swing.*;
//Importo los componentes de las otras carpetas
import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	//Considero el atributo id como numero de legajo, ya que la presentacion se hace ene el contexto de una universidad
            	Student yo = new Student(133960, "Zentrigen", "Rocio", "rociozentrigen@gmail.com", "https://github.com/Ro1407", "/PrimerProyecto/images/master Stack Overflow.png");
            	@SuppressWarnings("unused")
				JFrame ventana = new SimplePresentationScreen(yo);
            }
        });
    }
}