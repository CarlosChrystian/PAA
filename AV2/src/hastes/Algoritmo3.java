package hastes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.swing.JFileChooser;

public class Algoritmo3 {

	public static int cortarBaixoCima(int precos[], int n) {
		int valores[] = new int[n + 1];
		int maximoEncotrado;
		valores[0] = 0;

		for (int i = 1; i <= n; i++) {
			maximoEncotrado = 0;
			//
			for (int j = 0; j < i; j++)
				maximoEncotrado = Math.max(maximoEncotrado, precos[j] + valores[i - j - 1]);
			valores[i] = maximoEncotrado;
		}

		return valores[n];
	}

	public static void main(String[] args) throws IOException{
		
		//Exibe caixa de diagologo para selecionar arquivos
		JFileChooser selecionaArquivo = new JFileChooser(); 
		selecionaArquivo.showOpenDialog(null);   
		
		// Prepara documento para a leitura.
		InputStream arquivo = new FileInputStream(selecionaArquivo.getSelectedFile().getAbsolutePath());
		InputStreamReader leitorArquivo = new InputStreamReader(arquivo);
		BufferedReader buffer = new BufferedReader(leitorArquivo);

		// Percorrer todas as linhas do arquivo
		String linhaAtual;
		linhaAtual = buffer.readLine();

		int temp[];
		int haste[] = new int[1];

		// Armazenar os valores para cada tamanho da barra
		while (linhaAtual != null) {
			try {
				haste[haste.length - 1] = Integer.parseUnsignedInt(linhaAtual);
			} catch (NumberFormatException e) {
				System.out.println("O valor na linha " + haste.length + " é inválido: " + linhaAtual);
				System.exit(0);
			}
			linhaAtual = buffer.readLine();

			// Essas instruções permitem criar um vetor dinâmico proporcional ao
			// tamanho do arquivo.
			temp = haste;
			haste = Arrays.copyOf(temp, temp.length + 1);
		}

		// Retira o último elemento inválido
		haste = Arrays.copyOf(haste, haste.length - 1);
		
		System.out
				.println("\n\n=================== VALORES PARA CADA TAMANHO DA HASTE ===============================");
		for (int i = 0; i < haste.length; i++)
			System.out.println("Tamanho " + (i + 1) + ": " + haste[i]);

		System.out.println("o valor máximo que pode ser obtido é: " + cortarBaixoCima(haste, haste.length));
		
		buffer.close();
	}
}
