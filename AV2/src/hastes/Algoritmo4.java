package hastes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFileChooser;

public class Algoritmo4 {

	public static int s[]; // Inicio das atividades
	public static int f[]; // Final das atividades
	public static int a[]; // identificador da atividade

	public static int[] selecionarAtividades() {
		// Vetor para armazenas as atividades selecionadas
		int A[] = new int[s.length];
		int n = s.length;

		A[0] = a[0];

		// interator das atividades armazenadas
		int y = 1;
		// interator da próxima atividade
		int k = 0;

		// Verifica se o fim atividade atual é menor ou igual ao ínicio da próxima
		for (int i = 1; i < n; i++) {
			if (s[i] >= f[k]) {
				A[y++] = a[i];
				k = i;
			}
		}

		return A;
	}

	public static int getInicioAtividade(String linhaArquivo) {
		String inicioAtividade = "";

		for (int i = 0; linhaArquivo.charAt(i) != ' ' && i < linhaArquivo.length(); i++) {
			inicioAtividade += linhaArquivo.charAt(i);
		}

		return Integer.parseInt(inicioAtividade);
	}

	public static int getFimAtividade(String linhaArquivo) {
		String fimAtividade = "";
		boolean achouFinal = false;

		for (int i = 0; i < linhaArquivo.length(); i++) {
			if (achouFinal)
				fimAtividade += linhaArquivo.charAt(i);
			if (linhaArquivo.charAt(i) == ' ')
				achouFinal = true;
		}

		return Integer.parseInt(fimAtividade);
	}

	public static void main(String args[]) throws IOException {

		// Exibe caixa de diagologo para selecionar arquivos
		JFileChooser selecionaArquivo = new JFileChooser();
		selecionaArquivo.showOpenDialog(null);

		// Prepara documento para a leitura.
		InputStream arquivo = new FileInputStream(selecionaArquivo.getSelectedFile().getAbsolutePath());
		InputStreamReader leitorArquivo = new InputStreamReader(arquivo);
		BufferedReader buffer = new BufferedReader(leitorArquivo);

		// Percorrer todas as linhas do arquivo
		String linhaAtual;
		linhaAtual = buffer.readLine();

		// Armazenar os valores de ínicio e fim das atividades no vetor
		int sequenciaAtividade = 1;
		List<Atividade> atividades = new ArrayList<Atividade>();
		System.out.println("\n\n=================== ATIVIDADES LIDAS DO ARQUIVO ===============================");
		while (linhaAtual != null) {
			Atividade atividade = new Atividade(sequenciaAtividade++, getInicioAtividade(linhaAtual),
					getFimAtividade(linhaAtual));
			atividades.add(atividade);
			System.out.println(atividade);
			linhaAtual = buffer.readLine();
		}

		// Ordena a lista de atividades pelo critério do fim da atividade
		Collections.sort(atividades);

		s = new int[atividades.size()];
		f = new int[atividades.size()];
		a = new int[atividades.size()];

		int i = 0;

		// Exibe a lista de atividade ordenadas e armazena nos vetores
		// principais.
		System.out.println("\n\n========= ATIVIDADES ORDENADAS PELO TEMPO DE TÉRMINO ================");
		for (Atividade atividade : atividades) {
			s[i] = atividade.getInicio();
			f[i] = atividade.getFim();
			a[i++] = atividade.getSequencia();
			System.out.println(atividade);
		}

		System.out.println("=================== ATIVIDADES SELECIONADAS ===============================");
		System.out.printf("ATIVIDADE SELECIONADAS: [");
		for (int nroAtividade : selecionarAtividades()) {
			// Condição para não mostra posições vazias do vetor das atividades
			// que foram selecionadas
			if (nroAtividade != 0)
				System.out.printf("%d | ", nroAtividade);
		}
		System.out.printf("]");

		buffer.close();
	}

}
