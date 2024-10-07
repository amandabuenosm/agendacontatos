import java.io.*;
import java.util.HashMap;

public class Agenda {
  private HashMap<String, Contato> contatos;
  private String localarquivo;
  
  public Agenda(String localarquivo) {
    this.contatos = new HashMap<>();
    this.localarquivo = localarquivo;
    importacontato(localarquivo);
  }
  
  // função de importação de contatos
  public void importacontato(String localarquivo) {
    try (BufferedReader br = new BufferedReader(new FileReader(localarquivo))) {
        String linha;
        while ((linha = br.readLine()) != null) {
            String[] dadosdocontato = linha.split("@");
            if (dadosdocontato.length == 3) {
                String nome = dadosdocontato[0];
                String fone = dadosdocontato[1];
                String end = dadosdocontato[2];
                Contato contato = new Contato(nome, fone, end);
                contatos.put(fone, contato);
            }
        }
        System.out.println("Contatos importados!");
    } catch (IOException e) {
        System.out.println("Erro na importação dos contatos: " + e.getMessage());
    }
  }

// função para exportar contatos
  public void exportacontato() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(localarquivo))) {
        for (Contato contato : contatos.values()) {
            bw.write(contato.getNome() + "@" + contato.getTelefone() + "@" + contato.getEndereco());
            bw.newLine();
        }
        System.out.println("Contatos exportados!");
    } catch (IOException e) {
        System.out.println("Erro na exportação dos contatos: " + e.getMessage());
    }
  }

// função para inserção de novo contato
  public void novocontato(String nome, String fone, String end) {
    Contato contato = new Contato(nome, fone, end);
        contatos.put(fone, contato);
        System.out.println("Contato novo gravado com sucesso!");
        exportacontato(); 
  }

// função de exclusão por telefone
  public void deletaportelefone(String fone) {
    if(contatos.remove(telefone) != null) {
    System.out.println("Contato excluído com sucesso!");
    } else {
      System.out.println("Contato não localizado por esse telefone!");
    } exportacontato();
  }

// função de exclusão por nome
  public void deletapornome(String nome) {
      contatos.values().removeIf(contato -> contato.getNome().equalsIgnoreCase(nome));
      System.out.println("Contato excluído com sucesso!");
      exportacontato(); // Atualiza o arquivo após remover contatos
  }
  
// função de busca de contatos por nome
  public void contatospornome(String nome) {
      for (Contato contato : contatos.values()) {
          if (contato.getNome().equalsIgnoreCase(nome)) {
              System.out.println(contato);
              return;
          }
      }
      System.out.println("Contato não localizado por esse nome!");
  }
  
// função de busca de contatos por telefone
  public void contatoporfone(String fone) {
    Contato contato = contatos.get(fone);
    if (contato != null) {
        System.out.println(contato);
    } else {
        System.out.println("Contato não localizado por esse telefone!");
    }
  }
}
