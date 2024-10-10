public class Contato {
    private String nome;
    private String fone;
    private String end;

    public Contato(String nome, String fone, String end) {
        this.nome = nome;
        this.fone = fone;
        this.end = end;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return fone;
    }

    public String getEndereco() {
        return end;
    }

    @Override
    public String toString() {
        return "\n----------------------------------" +
        "Nome: " + nome +
        "\nTelefone: " + fone +
        "\nEndereço: " + end;
    }
}
