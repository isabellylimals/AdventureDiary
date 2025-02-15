import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Diario {
    private List<Missao> missoes;

    public Diario() {
        this.missoes = new ArrayList<>();
    }

    public void abrirDiario() {
        Scanner sc = new Scanner(System.in);
        
        while (true) { 
            System.out.println("\nO que deseja fazer:");
            System.out.println("[1] Adicionar nova missão");
            System.out.println("[2] Buscar uma missão");
            System.out.println("[3] Listar minhas missões");
            System.out.println("[4] Cancelar uma missão");
            System.out.println("[5] Marcar uma missão como concluída");
            System.out.println("[6] Fechar o diário");

            int opcao = 0;
            boolean entradaValida = false;

            while (!entradaValida) {
                try {
                    System.out.print("Escolha uma opção: ");
                    opcao = sc.nextInt();
                    sc.nextLine(); 

                    if (opcao >= 1 && opcao <= 6) {
                        entradaValida = true;
                    } else {
                        System.out.println("Opção inválida! Tente novamente.");
                    }
                } catch (Exception e) {
                    System.out.println("Entrada inválida! Por favor, insira um número entre 1 e 6.");
                    sc.nextLine(); 
                }
            }

            switch (opcao) {
                case 1:
                    System.out.print("Insira o nome da nova missão:\n");
                    String nome = sc.nextLine();
                    System.out.print("Qual a descrição da Missão?\n");
                    String descricao = sc.nextLine();
                    System.out.print("Qual o código da Missão?\n");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                      
                    
                    boolean codigoRepetido = false;
                    for (Missao missao : missoes) {
                        if (missao.codigo == codigo) {
                            System.out.println("Esse código já pertence à missão: " + missao.getInfo() + "\nInsira outro.");
                            codigoRepetido = true;
                            break;
                        }
                    }

                    if (!codigoRepetido) {
                        boolean status= false;
                        missoes.add(new Missao(nome, descricao, codigo, status));
                        System.out.println("Missão adicionada com sucesso!");
                    }
                    break;

                case 2:
                    buscarmissao();
                    break;

                case 3:
                    listarMissoes();
                    break;

                case 4:
                    cancelarmissão();
                    break;

                case 5:
                    System.out.print("Qual o código da missão que deseja marcar como concluída?\n");
                    int procurarcodigo = sc.nextInt();
                    sc.nextLine();

                    if (missoes.isEmpty()) {
                        System.out.println("Nenhuma missão registrada.");
                        break;
                    }

                    boolean encontrada = false;
                    for (Missao missao : missoes) {
                        if (missao.codigo == procurarcodigo) {
                            missao.status = true;
                            System.out.println("Missão marcada como concluída: " + missao.getInfo());
                            encontrada = true;
                            break;
                        }
                    }

                    if (!encontrada) {
                        System.out.println("Nenhuma missão encontrada com esse código!");
                    }
                    break;

                case 6:
                    System.out.println("Fechando Diário...");
                    sc.close();
                    return; 

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }



    public void addmissão(Missao missao) {
        missoes.add(missao);
        System.out.println("Uma nova missão foi adicionada!");
    }

    public void listarMissoes() {
        if (missoes.isEmpty()) {
            System.out.println("Nenhuma missão registrada.");
            return;
        }

        for (int i = 0; i < missoes.size(); i++) {
            System.out.println((i + 1) + ". " + missoes.get(i).getInfo());
        }
    }

    public void buscarmissao() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qual o código da missão que deseja buscar?\n");
        int procurarcodigo = sc.nextInt();

        if (missoes.isEmpty()) {
            System.out.println("Nenhuma missão registrada.");
            return;
        }

        boolean encontrada = false;
        for (Missao missao : missoes) {
            if (missao.codigo == procurarcodigo) {
                System.out.println("Missão encontrada: " + missao.getInfo());
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Nenhuma missão encontrada com esse código!");
        }
    }

    public void cancelarmissão() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qual o código da missão que deseja remover?\n");
        int procurarcodigo = sc.nextInt();

        if (missoes.isEmpty()) {
            System.out.println("Nenhuma missão registrada.");
            return;
        }

        boolean removida = false;
        for (int i = 0; i < missoes.size(); i++) {
            if (missoes.get(i).codigo == procurarcodigo) {
                missoes.remove(i);
                System.out.println("Missão removida com sucesso!");
                removida = true;
                break;
            }
        }

        if (!removida) {
            System.out.println("Nenhuma missão encontrada com esse código!");
        }
    }

    public void completarmissão(int codigo) {
        for (Missao missao : missoes) {
            if (missao.codigo == codigo) {
                missao.status = true; 
                System.out.println("Missão concluída: " + missao.getInfo());
                return;
            }
        }
        System.out.println("Nenhuma missão encontrada com esse código!");
    }
}