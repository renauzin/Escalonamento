package IFRSRestinga;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner in;
    static Escalonador escalonador = new Escalonador();

    public static void main(String[] args) {
        in = new Scanner(System.in);
        principalMenu();
    }

    private static void principalMenu() {
        int op;

        do {
            System.out.println("1=Automático 2=Manual 0=Sair");

            op = in.nextInt();

            switch (op) {
                case 1:
                    addAuto(escalonador);
                    menu(escalonador);
                    break;
                case 2:
                    addManual(escalonador);
                    menu(escalonador);
                    break;
                case 0:
                    System.out.println("encerrando...");
                    break;
                default:
                    System.out.println("opcao n encontrada.");
                    break;
            }
        } while (op != 0);
    }

    private static void addAuto(Escalonador escalonador) {
        Random random = new Random();
        int quantidadeProcessos = 3;
        for (int i = 0; i < quantidadeProcessos; i++) {
            int tempo_execucao = random.nextInt(20) + 1;
            int tempo_chegada = random.nextInt(10) + 1;
            int prioridade = random.nextInt(10) + 1;

            Processo novoProcesso = new Processo(tempo_execucao, tempo_chegada, prioridade);
            escalonador.addProcess(novoProcesso);
            System.out.println("processo add auto");
        }
    }

    private static void addManual(Escalonador escalonador) {
        int quantidadeProcessos = 3;
        for (int i = 0; i < quantidadeProcessos; i++) {
            System.out.println("tempo de execução:");
            int tempo_execucao = in.nextInt();
            System.out.println("tempo de chegada:");
            int tempo_chegada = in.nextInt();
            System.out.println("prioridade:");
            int prioridade = in.nextInt();

            Processo novoProcesso = new Processo(tempo_execucao, tempo_chegada, prioridade);
            escalonador.addProcess(novoProcesso);
            System.out.println("processo adicionado");
        }

    }

    private static void menu(Escalonador escalonador) {
        int op;
        do {
            System.out.println("escolha uma opcao:");
            System.out.println("1=FCFS");
            System.out.println("2=SJF nao-preemptivo");
            System.out.println("3. Executar Prioridade Não-Preemptivo");
            System.out.println("4=imprimir stats");
            System.out.println("0=sair");
            op = in.nextInt();

            switch (op) {
                case 1:
                    escalonador.fcfs();
                    break;
                case 2:
                    escalonador.sjf_NaoPreemptivo();
                    break;
                case 3:
                    escalonador.prioridade_NaoPreemptivo();
                    break;
                case 0:
                    System.out.println("encerrando...");
                    break;
                default:
                    System.out.println("opcao n encontrada.");
                    break;
            }
        } while (op != 0);
    }

}