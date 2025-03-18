package aplicativos;

import classes.Aeronave;
import classes.Pessoa;
import classes.Piloto;
import java.io.IOException;
import java.util.Scanner;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 10;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Aeronave[] aeronaves = new Aeronave[MAX_ELEMENTOS]; // Array para armazenar aeronaves
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Cadastrar aeronave");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Remove o ENTER da entrada anterior

            if (opcao == 1) {
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }

                System.out.print("Nome: ");
                String nome = in.nextLine();

                String cpf = null;
                boolean cpfValido = false;
                int tentativas = 0;

                while (tentativas < 3) {
                    System.out.print("CPF: ");
                    cpf = in.nextLine();
                    try {
                        new Pessoa(nome, cpf); // Testa a validação do CPF
                        cpfValido = true;
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                        tentativas++;
                        if (tentativas < 3) {
                            System.out.println("Tente novamente.");
                        }
                    }
                }

                if (!cpfValido) {
                    System.out.println("\nMuitas tentativas inválidas! Voltando ao menu...");
                    voltarMenu(in);
                    continue;
                }

                System.out.print("Brevete: ");
                String brevete = in.nextLine();

                pilotos[qtdCadastrados] = new Piloto(nome, cpf, brevete);
                qtdCadastrados++;

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);

            } else if (opcao == 2) { // Listar pilotos cadastrados
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                } else {
                    System.out.println("\nLista de pilotos cadastrados:");
                    for (int i = 0; i < qtdCadastrados; i++) {
                        System.out.println(pilotos[i]); // `toString()` já mostra as aeronaves associadas
                        System.out.println("--------------------");
                    }
                }
                voltarMenu(in);
            }

            else if (opcao == 3) {
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados.");
                } else {
                    System.out.print("\nDigite o CPF do piloto que deseja localizar: ");
                    String cpfBusca = in.nextLine();
                    boolean encontrado = false;

                    for (int i = 0; i < qtdCadastrados; i++) {
                        if (pilotos[i].getCpf().equals(cpfBusca)) {
                            System.out.println("\nPiloto encontrado:");
                            System.out.println(pilotos[i]);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("\nNenhum piloto encontrado com esse CPF.");
                    }
                }
                voltarMenu(in);

            } else if (opcao == 4) { // Cadastrar aeronave
                if (qtdCadastrados == 0) {
                    System.out.println("\nSem pilotos, não há como cadastrar uma aeronave.");
                    voltarMenu(in);
                    continue;
                }

                System.out.print("Digite o CPF do piloto para cadastrar a aeronave: ");
                String cpfPiloto = in.nextLine();
                Piloto pilotoEncontrado = null;

                // Procura o piloto pelo CPF
                for (int i = 0; i < qtdCadastrados; i++) {
                    if (pilotos[i] instanceof Piloto && pilotos[i].getCpf().equals(cpfPiloto)) {
                        pilotoEncontrado = (Piloto) pilotos[i];
                        break;
                    }
                }

                if (pilotoEncontrado != null) {
                    System.out.print("Modelo da aeronave: ");
                    String modelo = in.nextLine();
                    System.out.print("Número de registro: ");
                    String numeroRegistro = in.nextLine();

                    // Criar e associar aeronave ao piloto
                    Aeronave novaAeronave = new Aeronave(modelo, numeroRegistro, cpfPiloto);
                    pilotoEncontrado.adicionarAeronave(novaAeronave);

                    System.out.println("\nAeronave cadastrada e vinculada ao piloto com sucesso.");
                } else {
                    System.out.println("\nPiloto não encontrado! Verifique o CPF.");
                }

                voltarMenu(in);
            } else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");
        in.close();

    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");

        System.out.flush();
    }
}
