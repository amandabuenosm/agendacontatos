import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Agenda {
  private HashMap<String, Contato> contatos;
  private String localarquivo;
  
  public Agenda(String localarquivo) {
    this.contatos = new HashMap<>();
    this.localarquivo = localarquivo;
    importararquivo();
  

// função para carregar dados dos contatos no arquivo
  public void importararquivo() {
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
    } catch (IOException e) {
        System.out.println("ERRO NA IMPORTAÇÃO DOS CONTATOS: " + e.getMessage());
    }
  }

// função para salvar/atualizar contatos
  public void salvarcontato() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(localarquivo))) {
        for (Contato contato : contatos.values()) {
            bw.write(contato.getNome() + "@" + contato.getTelefone() + "@" + contato.getEndereco());
            bw.newLine();
        }
    } catch (IOException e) {
        System.out.println("Erro na exportação dos contatos: " + e.getMessage());
    }
  }

// função para inserção de novo contato
  public void novocontato(String nome, String fone, String end) {
    Contato contato = new Contato(nome, fone, end);
        contatos.put(fone, contato);
        System.out.println("CONTATO NOVO GRAVADO COM SUCESSO!");
        salvarcontato(); 
  }

// função de exclusão por nome
  public void deletapornome(String nome) {
    boolean contatodeletado = contatos.values().removeIf(contato -> contato.getNome().equalsIgnoreCase(nome));
    if (contatodeletado) {
      System.out.println("CONTATO EXCLUÍDO COM SUCESSO!");
    } else {
      System.out.println("CONTATO NÃO LOCALIZADO POR ESSE NOME!");
    } salvarcontato();
  }
  
// função de busca de contatos por nome
  public void contatospornome(String nome) {
      for (Contato contato : contatos.values()) {
          if (contato.getNome().equalsIgnoreCase(nome)) {
              System.out.println(contato);
              return;
          }
      } System.out.println("CONTATO NÃO LOCALIZADO POR ESSE NOME!");
  }
  
// função de busca de contatos por telefone
  public void contatoporfone(String fone) {
    Contato contato = contatos.get(fone);
    if (contato != null) {
        System.out.println(contato);
    } else {
        System.out.println("CONTATO NÃO LOCALIZADO POR ESSE TELEFONE!");
    }
  }

// função para listar contatos da agenda
  public void listadecontato() {
    if (contatos.isEmpty()) {
        System.out.println("A AGENDA DE CONTATOS ESTÁ VAZIA!");
    } else {
        for (Contato contato : contatos.values()) {
            System.out.println(contato);
        }
    } salvarcontato(); 
  }

// função para editar o contato da agenda
  public void editarcontato(String nome) {
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);
    for (Contato contato : contatos.values()) {
        if (contato.getNome().equalsIgnoreCase(nome)) {
            System.out.println(contato);
            System.out.println("---EDITAR CONTATO SELECIONADO---");

            // editar o contato antigo
            System.out.print("Nome: ");
            String nomeeditado = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefoneeditado = scanner.nextLine();
            System.out.print("Endereço: ");
            String enderecoeditado = scanner.nextLine();

            // salvar o contato com os novos dados
            contato.setNome(nomeeditado);
            contato.setTelefone(telefoneeditado);
            contato.setEndereco(enderecoeditado);

            System.out.println("CONTATO ATUALIZADO COM SUCESSO!");
            salvarcontato();
            return;
        }
    } System.out.println("CONTATO NÃO LOCALIZADO POR ESSE NOME!");
  }
  
// função para excluir tudo da agenda
  public void limpezadeagenda() {
      contatos.clear();
      System.out.println("AGENDA ESTÁ LIMPA COM SUCESSO!");
      salvarcontato();
  }
}
