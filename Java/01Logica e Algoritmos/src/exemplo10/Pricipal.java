 package exemplo10;

public class Pricipal {

	public static void main(String[] args) {
		
		//Operadores L�gicos
		
		/*
		&& = E
		|| = Ou
		! = N�O
		*/
		
		String segmento = "elet�nico";
		double valor = 100;
				
		if((segmento.equals("eletr�nico")) && (valor > 100)) {
			System.out.println("Desconto de 10% - R$ "+valor*0.9);
		}else {
			System.out.println("Sem desconto - R$ "+valor);
			
		}

	}

}
