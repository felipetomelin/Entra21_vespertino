package acao;

import javax.swing.table.DefaultTableModel;

import beans.login;
import principal.Principal;

public class acao {

		
		
		//Cadastrar login
		public void cadastrar(login l) {
			Principal.vetorLogin.add(l);
		}
		
		//Selecionar login
		public DefaultTableModel selecionar (){
			DefaultTableModel loginsTabela = new DefaultTableModel();
			loginsTabela.addColumn("Nome de Usu�rio");
			loginsTabela.addColumn("Senha");
			loginsTabela.addColumn("Tipo de Usu�rio");
			loginsTabela.addColumn("E-mail");	
			
			for(int i=0; i<Principal.vetorLogin.size(); i++) {
				loginsTabela.addRow(new Object[] {
						Principal.vetorLogin.get(i).getNome(),
						Principal.vetorLogin.get(i).getSenha(),
						Principal.vetorLogin.get(i).getUsario(),
						Principal.vetorLogin.get(i).getEmail(),
				});
				
			}
		
			return loginsTabela;
		}
		//Excluir login
		public void excluir(int indice) {
			Principal.vetorLogin.remove(indice);
		}
		
		//Alterar o login
		public void alterar(int indice, login l) {
			Principal.vetorLogin.set(indice, l);
		}
		
	}



