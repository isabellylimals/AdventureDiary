import src.Diario;

public class Missao{
    String nome;
    String descricao;
    int codigo;
    boolean status;


    public void criarmissao(String nome, String descricao, int codigo){
        this.nome=nome;
        this.descricao=descricao;
        this.codigo=codigo;
        this.status=false;
    }
    public void completarmissão(int codigo){
        this.codigo=codigo;
        this.status=true;
    }
    public String getInfo() {
        return "Missão: " + nome + "\nDescrição: " + descricao + "Codigo:" + codigo+
               "\nStatus: " + (status ? "Concluída" : "Em andamento") + "\n";
    }
}