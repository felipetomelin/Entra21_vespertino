package Cargos;

public class Estagi�rio extends Cargos{
	
	//Construtor
	public Estagi�rio(String cargo, double salario) {
		this.cargo = cargo;
		this.salario = salario;
	
	}
	
	//Ir
	public void impostoRenda() {
		System.out.println("N�o h� imposto de renda para estagi�rios");
		
	}
	
}
