package IFRSRestinga;
public class Processo {
    private static int ids = 0;
    private int id;
    private int tempo_execucao;
    private int tempo_chegada;
    private int prioridade;

    public Processo(int tempo_execucao, int tempo_chegada, int prioridade) {
        this.id = ++ids;
        this.tempo_execucao = tempo_execucao;
        this.tempo_chegada = tempo_chegada;
        this.prioridade = prioridade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTempo_execucao() {
        return tempo_execucao;
    }

    public void setTempo_execucao(int tempo_execucao) {
        this.tempo_execucao = tempo_execucao;
    }

    public int getTempo_chegada() {
        return tempo_chegada;
    }

    public void setTempo_chegada(int tempo_chegada) {
        this.tempo_chegada = tempo_chegada;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

}