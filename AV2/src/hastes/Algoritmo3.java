package hastes;

public class Algoritmo3 {
	
	
	
	public static int cortarBaixoCima(int precos[], int n){
		int valores[] = new int[n+1];
		int maximoEncotrado;
        valores[0] = 0;
        
        for (int i = 1; i<=n; i++)
        {
            maximoEncotrado = 0;
            for (int j = 0; j < i; j++)
            maximoEncotrado = Math.max(maximoEncotrado, precos[j] + valores[i-j-1]);
            valores[i] = maximoEncotrado;
        }
 
        return valores[n];
	}
	
	public static void main(String[] args) {
		int haste[] =  {1, 5, 8, 9, 10, 17, 17, 20};
		
		System.out.println("o valor máximo que pode ser obtido é: " + cortarBaixoCima(haste, haste.length));
		
	}
}
