package hastes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.swing.JFileChooser;


public class Algoritmo2 {

	public static final int DESCONHECIDO = -1;

	public static int topDownMemo(int haste[], int memo[], int n) {
		int maximoEncotrado = 0;
		
		//SE A SOLU��O FOR CONHECIDA N�O SER� NECESS�RIO BUSCAR O �TIMO VALOR PARA ESTE N
		if (memo[n] != DESCONHECIDO) {
			return memo[n];
		}

		if (n == 0) {
			memo[n] = 0;//UMA HASTE DE TAMANHO 0 SEMPRE TER� VALOR 0
		} else {
			maximoEncotrado = 0;
			
			//REALIZA AS COMBINA��ES DE MELHOR VALOR PARA O TAMANHO N
			for (int i = 0; i < n; ++i) {
				maximoEncotrado = Math.max(maximoEncotrado, haste[i] + topDownMemo(haste, memo, n - i - 1));
			}
			//ARMAZENA O MELHOR VALOR PARA TAMANHO N
			memo[n] = maximoEncotrado;
		}

		return memo[n];
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
				System.out.println("O valor na linha " + haste.length + " � inv�lido: " + linhaAtual);
				System.exit(0);
			}
			linhaAtual = buffer.readLine();

			// Essas instru��es permitem criar um vetor din�mico proporcional ao
			// tamanho do arquivo.
			temp = haste;
			haste = Arrays.copyOf(temp, temp.length + 1);
		}

		// Retira o �ltimo elemento inv�lido
		haste = Arrays.copyOf(haste, haste.length - 1);
		
		//Aloca o vetor auxiliar
		int memoria[] = new int[haste.length + 1];
		for (int i = 0; i < memoria.length; i++)
			memoria[i] = DESCONHECIDO;

		System.out
				.println("\n\n=================== VALORES PARA CADA TAMANHO DA HASTE ===============================");
		for (int i = 0; i < haste.length; i++)
			System.out.println("Tamanho " + (i + 1) + ": " + haste[i]);

		System.out.println("O valor m�ximo que pode ser obtido para essa haste �: " + topDownMemo(haste, memoria, haste.length));

		buffer.close();

	}

}
