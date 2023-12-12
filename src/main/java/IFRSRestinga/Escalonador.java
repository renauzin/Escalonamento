package IFRSRestinga;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Escalonador {
    private List<Processo> processList;

    public void addProcess(Processo processo) {
        if (processList == null) {
            processList = new ArrayList<>();
        }
        processList.add(processo);
    }

    public void fcfs() {
        int tempo_espera = 0;
        int t_p2 = 0;

        for (Processo processo : processList) {
            System.out.println("processo["+processo.getId()+"]");

            System.out.println("processo["+processo.getId()+"] tempo_espera:"+tempo_espera);
            tempo_espera += processo.getTempo_execucao();

            t_p2 = (processList.get(0).getTempo_execucao() * 2) + processList.get(1).getTempo_execucao();
        }

        double media_espera = (double) t_p2 / processList.size();
        System.out.println("tempo_médio: "+media_espera);

        imprime_stats();
    }

    public void sjf_NaoPreemptivo() {
        processList.sort(Comparator.comparingInt(Processo::getTempo_execucao));//metodo array para ordenar

        int tempo_espera = 0;
        int t_p2 = 0;

        for (Processo processo : processList) {
            System.out.println("processo["+processo.getId()+"]");

            System.out.println("processo["+processo.getId()+"] tempo_espera:"+tempo_espera);
            tempo_espera += processo.getTempo_execucao();

            t_p2 = (processList.get(0).getTempo_execucao() * 2) + processList.get(1).getTempo_execucao();
        }

        double media_espera = (double) t_p2 / processList.size();
        System.out.println("tempo_médio: "+media_espera);

        imprime_stats();
    }

    public void prioridade_NaoPreemptivo() {
        processList.sort(Comparator.comparingInt(Processo::getPrioridade));

        int tempo_espera = 0;
        int t_p2 = 0;

        for (Processo processo : processList) {
            System.out.println("processo["+processo.getId()+"]");

            System.out.println("processo["+processo.getId()+"] tempo_espera:"+tempo_espera);
            tempo_espera += processo.getTempo_execucao();

            t_p2 = (processList.get(0).getTempo_execucao() * 2) + processList.get(1).getTempo_execucao();
        }

        double media_espera = (double) t_p2 / processList.size();
        System.out.println("tempo_médio: "+media_espera);

        imprime_stats();
    }

    public void imprime_stats() {
        for (Processo processo : processList) {
            System.out.println("\n\nimprime_stats();\nprocesso["+processo.getId()+"]");
            System.out.println("tempo_execucao = "+processo.getTempo_execucao());
            System.out.println("tempo_restante = "+processo.getTempo_execucao());
            System.out.println("tempo_chegada = "+processo.getTempo_chegada());
            System.out.println("prioridade = "+processo.getPrioridade());
        }
    }

}