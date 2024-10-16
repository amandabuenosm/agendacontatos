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
  }

// função para carregar contatos do arquivo
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

// função para editar um contato
  // public void editarcontato(String nome) {
  //   Scanner scanner = new Scanner(System.in);
  //   for (Contato contato : contatos.values()) {
  //     if (contato.getNome().equalsIgnoreCase(nome)) {
  //         System.out.println(contato);
  //         System.out.println("---EDITAR CONTATO SELECIONADO---");
  //         contatos.put(contato.getNome(), contato); {
  //             System.out.println("Nome: ");
  //             scanner.nextLine();
  //             System.out.println("Telefone: ");
  //             scanner.nextLine();
  //             System.out.println("Endereço: ");
  //             scanner.nextLine();
  //         }
  //           System.out.println("CONTATO ATUALIZADO COM SUCESSO!");
  //           salvarcontato();
  //           return;
  //     }
  //       scanner.close();
  //   }   System.out.println("CONTATO NÃO LOCALIZADO POR ESSE NOME!");
  // }
// função para editar um contato
public void editarcontato(String nome) {
  @SuppressWarnings("resource")
  Scanner scanner = new Scanner(System.in);
  for (Contato contato : contatos.values()) {
      if (contato.getNome().equalsIgnoreCase(nome)) {
          System.out.println(contato);
          System.out.println("---EDITAR CONTATO SELECIONADO---");

          // Atualizar os valores do contato
          System.out.print("Nome: ");
          String novoNome = scanner.nextLine();
          System.out.print("Telefone: ");
          String novoTelefone = scanner.nextLine();
          System.out.print("Endereço: ");
          String novoEndereco = scanner.nextLine();

          // Atualiza o contato com os novos dados
          contato.setNome(novoNome);
          contato.setTelefone(novoTelefone);
          contato.setEndereco(novoEndereco);

          System.out.println("CONTATO ATUALIZADO COM SUCESSO!");
          salvarcontato();  // Salva as mudanças no arquivo
          return;
      }
  }
  System.out.println("CONTATO NÃO LOCALIZADO POR ESSE NOME!");
}

// função para excluir tudo da agenda
  public void limpezadeagenda() {
      contatos.clear();
      System.out.println("AGENDA ESTÁ LIMPA COM SUCESSO!");
      salvarcontato();
  }
}
