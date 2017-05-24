package hastes;

import java.io.*;
import java.util.HashMap;

public class Algoritmo1 {
	public static int valores[];
	
	public static int descer(int n) {
		System.out.println("desce" + n);

		if (n == 0) {
			return 0;
		}else{
			int melhor = 0;
			
			for(int i = 0; i < n; i++){
				melhor = Math.max(melhor, valores[i] + descer(n - i - 1));
			}
			return melhor;
		}

	}

	public static void main(String args[]) throws IOException {

		HashMap<Integer, Integer> entradaValores = new HashMap<Integer, Integer>();

		// Prepara documento para a leitura.
		InputStream is;
		is = new FileInputStream("C:\\Temp\\arquivo.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String linhaAtual;
		linhaAtual = br.readLine();

		int tamanhoAtual = 1;

		while (linhaAtual != null) {
			entradaValores.put(tamanhoAtual++, Integer.parseInt(linhaAtual));
			linhaAtual = br.readLine();
		}
		
		//Apenas agora o vetor oficial será criado, porque apenas após a leitora o valores é que sabemos o tamanho da haste
		
		valores = new int[entradaValores.size()];
		
		System.out.println("============ EXIBINDO VALORES LIDOS DO ARQUIVO ===========================");
		for (Integer chave : entradaValores.keySet()){
			System.out.println("Tamanho " + chave + ": " + entradaValores.get(chave));
			if(chave < valores.length) valores[chave] = entradaValores.get(chave);
		}
		
		
		System.out.println("\n\n\nO valor encontrado pelo método top down foi: " + descer(valores.length));
		
		br.close();
	}

}
