// public class Contato {
//     private String nome;
//     private String fone;
//     private String end;

//     public Contato(String nome, String fone, String end) {
//         this.nome = nome;
//         this.fone = fone;
//         this.end = end;
//     }

//     public String getNome() {
//         return nome;
//     }

//     public String getTelefone() {
//         return fone;
//     }

//     public String getEndereco() {
//         return end;
//     }

//     @Override
//     public String toString() {
//         return "----------------------------------" +
//         "\nNome: " + nome +
//         "\nTelefone: " + fone +
//         "\nEndereço: " + end;
//     }

//     public void setNome(String novoNome) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'setNome'");
//     }

//     public void setTelefone(String novoTelefone) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'setTelefone'");
//     }

//     public void setEndereco(String novoEndereco) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'setEndereco'");
//     }
// }


public class Contato {
    private String nome;
    private String telefone;
    private String endereco;

    public Contato(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone + ", Endereço: " + endereco;
    }
}
