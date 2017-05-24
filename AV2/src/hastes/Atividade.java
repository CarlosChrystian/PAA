package hastes;

public class Atividade implements Comparable<Atividade>{
	
	private int sequencia;
	private int inicio;
	private int fim;
	
	
	public Atividade(int sequencia, int inicio, int fim) {
		this.sequencia = sequencia;
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public int getSequencia() {
		return sequencia;
	}
	public void setSequencia(int sequencia) {
		this.sequencia = sequencia;
	}
	public int getInicio() {
		return inicio;
	}
	public void setInicio(int inicio) {
		this.inicio = inicio;
	}
	public int getFim() {
		return fim;
	}
	public void setFim(int fim) {
		this.fim = fim;
	}
	
	
	public String toString(){
		return "Atividade " + sequencia + ": INICIO[" + inicio + "] FIM[" + fim + "]";
	}
	
	public int compareTo(Atividade o) {
		
		if(this.fim < o.fim){
			return -1;
		}
		
		if(this.fim > o.fim){
			return 1;
		}
		
		return 0;
	}
	
	
	
}
