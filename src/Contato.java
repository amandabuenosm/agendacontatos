public class Contato {
    private String nome;
    private String fone;
    private String end;

    public Contato(String nome, String fone, String end) {
        this.nome = nome;
        this.fone = fone;
        this.end = end;
    }

    // obter dados do arquivo
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return fone;
    }

    public String getEndereco() {
        return end;
    }

    // correspondência de variáveis caso algo seja atualizado 
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String fone) {
        this.fone = fone;
    }

    public void setEndereco(String end) {
        this.end = end;
    }
    
    @Override
    public String toString() {
        return "----------------------------------" +
        "\nNome: " + nome +
        "\nTelefone: " + fone +
        "\nEndereço: " + end;
    }
}
