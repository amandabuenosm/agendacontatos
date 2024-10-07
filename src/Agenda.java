import java.io.*;
import java.util.HashMap;

public class Agenda {
    private HashMap<String, Contato> contatos;
    private String caminhoArquivo; // Novo campo para armazenar o caminho do arquivo

    public Agenda(String caminhoArquivo) {
        this.contatos = new HashMap<>();
        this.caminhoArquivo = caminhoArquivo; // Inicializa o caminho do arquivo
        importarContatos(caminhoArquivo); // Importa os contatos no início
    }

    public void importarContatos(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split("@");
                if (partes.length == 3) {
                    String nome = partes[0];
                    String telefone = partes[1];
                    String endereco = partes[2];
                    Contato contato = new Contato(nome, telefone, endereco);
                    contatos.put(telefone, contato);
                }
            }
            System.out.println("Contatos importados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao importar contatos: " + e.getMessage());
        }
    }

    public void exportarContatos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Contato contato : contatos.values()) {
                bw.write(contato.getNome() + "@" + contato.getTelefone() + "@" + contato.getEndereco());
                bw.newLine();
            }
            System.out.println("Contatos exportados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao exportar contatos: " + e.getMessage());
        }
    }

    public void inserirContato(String nome, String telefone, String endereco) {
        Contato contato = new Contato(nome, telefone, endereco);
        contatos.put(telefone, contato);
        System.out.println("Contato inserido com sucesso!");
        exportarContatos(); // Atualiza o arquivo após inserir o contato
    }

    public void removerContatoPorTelefone(String telefone) {
        if (contatos.remove(telefone) != null) {
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Contato não encontrado!");
        }
        exportarContatos(); // Atualiza o arquivo após remover o contato
    }

    public void removerContatoPorNome(String nome) {
        contatos.values().removeIf(contato -> contato.getNome().equalsIgnoreCase(nome));
        System.out.println("Contatos removidos com sucesso!");
        exportarContatos(); // Atualiza o arquivo após remover contatos
    }

    public void localizarContatoPorNome(String nome) {
        for (Contato contato : contatos.values()) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                System.out.println(contato);
                return;
            }
        }
        System.out.println("Contato não encontrado!");
    }

    public void localizarContatoPorTelefone(String telefone) {
        Contato contato = contatos.get(telefone);
        if (contato != null) {
            System.out.println(contato);
        } else {
            System.out.println("Contato não encontrado!");
        }
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("A agenda está vazia.");
        } else {
            for (Contato contato : contatos.values()) {
                System.out.println(contato);
            }
        }
        exportarContatos(); // Atualiza o arquivo após listar os contatos
    }

    public void realizarChamada(String telefone) {
        Contato contato = contatos.get(telefone);
        if (contato != null) {
            System.out.println("Realizando chamada para " + contato.getNome() + "...");
        } else {
            System.out.println("Contato não encontrado!");
        }
    }

    public void limparAgenda() {
        contatos.clear();
        System.out.println("Agenda limpa com sucesso!");
        exportarContatos(); // Atualiza o arquivo após limpar a agenda
    }
}
