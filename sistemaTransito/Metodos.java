package sistemaTransito;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Metodos {
	
	public Estatistica [] cadastrarEstatistica(Estatistica[] est) {
		
		for (int i = 0; i < est.length; i++) {
			est[i] = new Estatistica();
			est[i].codCidade = Integer.parseInt(JOptionPane.showInputDialog("Código da cidade: "));
			est[i].nomeCidade = (JOptionPane.showInputDialog("Nome da cidade: "));
			est[i].qtdAcidentes = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de acidentes de " + est[i].nomeCidade + ": "));
		}
		
		return est;
	}
	
	public void quantidadeAcidentes (Estatistica[] est) {
		
		for (int i = 0; i < est.length; i++) {
			if (est[i].qtdAcidentes > 100 && est[i].qtdAcidentes < 500) {
				System.out.println(est[i].nomeCidade + " tem: " + est[i].qtdAcidentes);
			}
		}
	}
	
	public void maiorMenor (Estatistica[] est) {
		
		int maior = 0;
		int menor = est[0].qtdAcidentes;
		
		for (int i = 0; i < est.length; i++) {
			if (est[i].qtdAcidentes > maior) {
				maior = est[i].qtdAcidentes;
			} else if (est[i].qtdAcidentes < menor) {
				menor = est[i].qtdAcidentes;
			}
		}
		
		for (int i = 0; i < est.length; i++) {
			if (est[i].qtdAcidentes == maior) {
				System.out.println(est[i].nomeCidade + " possui o maior número de acidentes, com: " + est[i].qtdAcidentes);
			} else if (est[i].qtdAcidentes == menor) {
				System.out.println(est[i].nomeCidade + " possui o menor número de acidentes, com: " + est[i].qtdAcidentes);
			}
		}
		
	}
	
	public void media (Estatistica[] est) {
		
		double media;
		int soma = 0;
		
		for (int i = 0; i < est.length; i++) {
			soma += est[i].qtdAcidentes;
		}
		
		media = soma/est.length;
		
		for (int i = 0; i < est.length; i++) {
			if (est[i].qtdAcidentes > media) {
				System.out.println(est[i].nomeCidade + " possui um número de acidentes acima da média >>> " + est[i].qtdAcidentes + " >>> " + media);
			}
		}
	}
	
	public void gravar (Estatistica[] est) throws IOException {
		
		String nomeArquivo = "estatistica.txt";
		BufferedWriter gravar = new BufferedWriter(new FileWriter(nomeArquivo));
		
		for (int i = 0; i < est.length; i++) {
			gravar.write(String.valueOf(est[i].codCidade));
			gravar.newLine();
			gravar.write(String.valueOf(est[i].nomeCidade));
			gravar.newLine();
			gravar.write(String.valueOf(est[i].qtdAcidentes));
			gravar.newLine();
		}
		
		gravar.close();
	}
	
	public void ler (Estatistica[] est) throws IOException{
		
		String nomeArquivo = "estatistica.txt";
		BufferedReader ler = new BufferedReader(new FileReader(nomeArquivo));
		
		for (int i = 0; i < est.length; i++) {
			est[i].codCidade = Integer.parseInt(ler.readLine());
			est[i].nomeCidade = ler.readLine();
			est[i].qtdAcidentes = Integer.parseInt(ler.readLine());
		}
		
		ler.close();
		
	}
}
