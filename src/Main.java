import java.util.Scanner;

public class Main {
  Agenda agenda = new Agenda("data/contatos.txt");
  Scanner scanner = new Scanner(System.in);
  
  int opcaouser;
  
  do {
    System.out.println("MENU DA AGENDA:");
    System.out.println("1 - Importar Contatos");
    System.out.println("2 - Exportar Contatos");
    System.out.println("3 - Criar novo Contato");
    System.out.println("4 - Remover Contato por Telefone");
    System.out.println("5 - Remover Contato por Nome");
    System.out.println("6 - Localizar Contato por Nome");
    System.out.println("7 - Localizar Contato por Telefone");
    System.out.println("8 - Listar todos os Contatos");
    System.out.println("9 - Realizar Chamada");
    System.out.println("10 - Limpar Agenda");
    System.out.println("11 - Sair");
    System.out.print("Escolha uma opção: ");
    opcaouser = scanner.nextInt();
    scanner.nextLine();
    
    switch (opcao) {
      case 1:
          agenda.importacontato("data/contatos.txt");
          break;
      case 2:
          agenda.exportacontato();
          break;
      case 3:
          System.out.println("Nome: ");
          String nome = scanner.nextLine();
          System.out.println("Telefone: ");
          String fone = scanner.nextLine();
          System.out.println;
          String end = scanner.nextLine();
          agenda.novocontato(nome, fone, end);
          break;
      case 4:
          System.out.println("Número de Telefone: ");
          String deletatelefone = scanner.nextLine();
          agenda.deletaportelefone(deletatelefone);
          break;
      case 5:
          System.out.println("Nome: ");
          String deletanome = scanner.nextLine();
          agenda.deletapornome(deletanome);
          break;
      case 6:
          System.out.println("Nome: ");
          String buscapornome = scanner.nextLine();
          agenda.contatospornome(buscapornome);
          break;
      case 7:
          System.out.println("Telefone: ");
          String buscaporfone = scanner.nextLine();
          agenda.contatoporfone(buscaporfone);
          break;
      case 8:
          agenda.listadecontato();
          break;
      case 9:
          System.out.println("Número de Telefone: ");
          String fonechamada = scanner.nextLine();
          agenda.fazerchamada(fonechamada);
          break;
      case 10:
          agenda.limpezadeagenda();
          break;
      case 11:
          System.out.println("Encerrando aplicação de agenda de contatos...");
          break;
      default:
          System.out.println("Opção inválida! Tente novamente.");
          break;
      } while (opcaouser != 11); 
        scanner.close();
    }
}
