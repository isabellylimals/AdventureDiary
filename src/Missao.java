

public class Missao{
    String nome;
    String descricao;
    int codigo;
    boolean status;

//construtor
    public Missao(String nome, String descricao, int codigo, boolean status){ 
        this.nome=nome;
        this.descricao=descricao;
        this.codigo=codigo;
        this.status=false;
    }
    
    public String getInfo() {
        return "Missão: " + nome + "\nDescrição: " + descricao + "\nCodigo:" + codigo+
               "\nStatus: " + (status ? "Concluída" : "Em andamento") + "\n";
    }
}