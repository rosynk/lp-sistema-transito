package sistemaTransito;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) throws IOException {
		
		int n = 0;
		Metodos m = new Metodos();
		Estatistica[] est = new Estatistica[5];
		
		do {
			
			n = Integer.parseInt(JOptionPane.showInputDialog("---------------------------------------------------------------\r\n"
					+ "|	MENU ESTATÍSTICA	               	\n"
					+ "| Estatísticas de acidentes em 2020		\n"
					+ "| 1 - Cadastro Estatística			\n"
					+ "| 2 - Consulta por quantidade de acidentes	\n"
					+ "| 3 - Consulta por estatísticas de acidentes	\n"
					+ "| 4 - Acidentes acima da média das 10 cidades  \n"
					+ "| 5 - Gravar o Cadastro de Estatísticas \n"
					+ "| 6 - Ler Gravação \n"
					+ "| 9 - Finaliza 		   		              \n"
					+ "----------------------------------------------------------------\r\n"
					+ ""));
			
			switch (n) {
			case 1:
				m.cadastrarEstatistica(est);
				break;
			case 2:
				m.quantidadeAcidentes(est);
				break;
			case 3:
				m.maiorMenor(est);
				break;
			case 4:
				m.media(est);
				break;
			case 5:
				m.gravar(est);
				break;
			case 6:
				m.ler(est);
				break;
			case 9:
				System.out.println("Operação Encerrada");
				break;
			}
			
		} while (n!=9);
		
	}
}
