import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import src.Missao;

public class Diario {
    private List<Missao> missoes;

    public Diario() {
        this.missoes = new ArrayList<>();
    }

    public void abrirDiario() {
        Scanner sc = new Scanner(System.in);
        System.out.print("O que deseja fazer:\n");
        System.out.print("[1] Adicionar nova missão\n[2] Buscar uma missão\n[3] Listar minhas missões\n[5] Cancelar uma missão\n[6] Marcar uma missão como concluída\n[7] Fechar o diario\n");

        int opcao = sc.nextInt();
        

       
    }
  public void addmissão(Missao missao){
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
        for (int i = 0; i < missoes.size(); i++) {
            if (missoes.get(i).codigo == procurarcodigo) {
                System.out.println("Missão encontrada: " + missoes.get(i).getInfo());
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

}