package exemplo06;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		//Condicioanl simples
		int idade = Integer.parseInt(JOptionPane.showInputDialog("Infrome a idade"));
		
		if(idade >= 18) {
			JOptionPane.showMessageDialog(null, "Maior de idade");
		}else {
			JOptionPane.showMessageDialog(null, "Menor de idade");
		}
	}

}
