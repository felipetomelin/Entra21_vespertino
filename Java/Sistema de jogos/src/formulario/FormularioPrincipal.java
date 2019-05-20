package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Principal.Principal;
import acao.acao;
import beans.jogo;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormularioPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textValor;
	private JTextField textClassificacao;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public FormularioPrincipal() {
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Instanciar objeto da classe Acao
		acao a = new acao();
		
		JLabel lblNomeDoJogo = new JLabel("Nome do jogo");
		lblNomeDoJogo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblNomeDoJogo.setBounds(10, 11, 85, 25);
		contentPane.add(lblNomeDoJogo);
		
		textNome = new JTextField();
		textNome.setBounds(103, 13, 321, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblGnero = new JLabel("Genero");
		lblGnero.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblGnero.setBounds(10, 49, 85, 25);
		contentPane.add(lblGnero);
		
		JLabel lblPlataforma = new JLabel("Plataforma");
		lblPlataforma.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblPlataforma.setBounds(10, 85, 85, 25);
		contentPane.add(lblPlataforma);
		
		JLabel lblClassificao = new JLabel("Classifica\u00E7\u00E3o");
		lblClassificao.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblClassificao.setBounds(10, 121, 85, 25);
		contentPane.add(lblClassificao);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblValor.setBounds(10, 157, 85, 25);
		contentPane.add(lblValor);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(103, 160, 321, 20);
		contentPane.add(textValor);
		
		textClassificacao = new JTextField();
		textClassificacao.setColumns(10);
		textClassificacao.setBounds(103, 124, 321, 20);
		contentPane.add(textClassificacao);
		
		JComboBox CbxPlataforma = new JComboBox();
		CbxPlataforma.setBounds(103, 87, 321, 22);
		CbxPlataforma.addItem("Xbox One");
		CbxPlataforma.addItem("Playstation 4");
		CbxPlataforma.addItem("PC");
		contentPane.add(CbxPlataforma);
		
		JComboBox CbxGenero = new JComboBox();
		CbxGenero.addItem("A��o");
		CbxGenero.addItem("Aventura");
		CbxGenero.addItem("Suspense");
		CbxGenero.setBounds(103, 51, 321, 22);
		contentPane.add(CbxGenero);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
				
				 //Criar um objeto da classe Jogo
				 jogo j = new jogo();
				 j.setNome(textNome.getText());
				 j.setGenero(CbxGenero.getSelectedItem().toString());
				 j.setPlataforma(CbxPlataforma.getSelectedItem().toString());
				 j.setClassicacao(Integer.parseInt(textClassificacao.getText()));
				 j.setValor(Double.parseDouble(textValor.getText()));
				 
				//Realizar o cadastro
				a.cadastrar(j);
				
				//Atualizar a tabela
				table.setModel(a.selecionar());
				
					//Mensagem
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
				}catch(Exception erro) {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar, tente novamente");
				}
				
				//Limpar os campos
				textNome.setText("");
				CbxGenero.setSelectedIndex(0);
				CbxPlataforma.setSelectedIndex(0);
				textClassificacao.setText("");
				textValor.setText("");
				
				//Cursos no campo nome jogo
				textNome.requestFocus();
				
			}
		});
		btnCadastrar.setFont(new Font("Yu Gothic Light", Font.PLAIN, 16));
		btnCadastrar.setBounds(20, 192, 119, 36);
		contentPane.add(btnCadastrar);
		
		JLabel lblIndice = new JLabel("");
		lblIndice.setBounds(0, 0, 48, 14);
		contentPane.add(lblIndice);
		lblIndice.setVisible(false);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Obter o indice
				int indice = Integer.parseInt(lblIndice.getText());
				
				//Chamar o medoto de exclusao
				a.excluir(indice);
				
				//Atualizar tabela
				table.setModel(a.selecionar());
				
				//Limpar os campos
				textNome.setText("");
				CbxGenero.setSelectedIndex(0);
				CbxPlataforma.setSelectedIndex(0);
				textClassificacao.setText("");
				textValor.setText("");
				lblIndice.setText("");
				
				//Cursos no campo nome
				textNome.requestFocus();
				
				//Mnesagem
				JOptionPane.showMessageDialog(null , "Jogo excluido com sucesso");
				
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setFont(new Font("Yu Gothic Light", Font.PLAIN, 16));
		btnExcluir.setBounds(305, 191, 119, 36);
		contentPane.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Obter o indice a ser alterado
				int indice = Integer.parseInt(lblIndice.getText());
				
				//Instanciar um objeto da classe jogo
				jogo j = new jogo();
				j.setNome(textNome.getText());
				j.setGenero(CbxGenero.getSelectedItem().toString());
				j.setPlataforma(CbxPlataforma.getSelectedItem().toString());
				j.setClassicacao(Integer.parseInt(textClassificacao.getText()));
				j.setValor(Double.parseDouble(textValor.getText()));
				
				//Realizar altera��o
				a.alterar(indice, j);
				
				//Atualizar tabela
				table.setModel(a.selecionar());
				
				//Limpar os campos
				textNome.setText("");
				CbxGenero.setSelectedIndex(0);
				CbxPlataforma.setSelectedIndex(0);
				textClassificacao.setText("");
				textValor.setText("");
				lblIndice.setText("");
				
				//Ativar bot�o cadastrar e desabilitar os demais
				btnCadastrar.setEnabled(true);
				btnAlterar.setEnabled(false);
				btnExcluir.setEnabled(false);
				
				//Cursos no campo nome
				textNome.requestFocus();
				
				//Mnesagem
				JOptionPane.showMessageDialog(null , "Jogo alterado com sucesso");
				
			}
		});
		btnAlterar.setEnabled(false);
		btnAlterar.setFont(new Font("Yu Gothic Light", Font.PLAIN, 16));
		btnAlterar.setBounds(159, 191, 119, 36);
		contentPane.add(btnAlterar);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(0, 239, 434, 231);
		contentPane.add(scrollPane);
		
		table = new JTable(a.selecionar());
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				//Obter a linha selecionada
				int indice = table.getSelectedRow();
				
				//Obtendo os dados de cada coluna
				String nome = table.getValueAt(indice, 0).toString();
				String genero = table.getValueAt(indice, 1).toString();
				String plataforma = table.getValueAt(indice, 2).toString();
				int classificacao = Integer.parseInt(table.getValueAt(indice, 3).toString());
				double valor = Double.parseDouble(table.getValueAt(indice, 4).toString());
				
				JOptionPane.showMessageDialog(null, nome);
				
				//Enviando dados ao formul�rio
				lblIndice.setText(String.valueOf(indice));
				textNome.setText(nome);
				textClassificacao.setText(String.valueOf(classificacao));
				textValor.setText(String.valueOf(valor));
				
				switch (genero) {
				case "A��o":
					CbxGenero.setSelectedIndex(0);
					break;
					
				case "Aventura":
					CbxGenero.setSelectedIndex(1);
					break;
					
				case "Suspense":
					CbxGenero.setSelectedIndex(2);
					break;
				}
				
				switch (plataforma) {
				case "Xbox One":
					CbxPlataforma.setSelectedIndex(0);
					break;
						
				case "Playstation 4":
					CbxPlataforma.setSelectedIndex(1);
					break;
						
				case "PC":
					CbxPlataforma.setSelectedIndex(2);
					break;
				}
				
				//Ativar bot�es de alterar e excluir e desativar bot�o cadastrar
				btnCadastrar.setEnabled(false);
				btnAlterar.setEnabled(true);
				btnExcluir.setEnabled(true);
				
				
				
			}
		});
		
		
	}
}
