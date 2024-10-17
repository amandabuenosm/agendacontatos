import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda("data/contatos.txt");
        Scanner scanner = new Scanner(System.in);

        int opcaouser;
  
        do {
            System.out.println("-----------------------------------");
            System.out.println("Menu do Usuário da Agenda:");
            System.out.println("1 - Importar Contatos");
            System.out.println("2 - Salvar Contatos");
            System.out.println("3 - Criar novo Contato");
            System.out.println("4 - Excluir Contato por Nome");
            System.out.println("5 - Buscar Contato por Nome");
            System.out.println("6 - Buscar Contato por Telefone");
            System.out.println("7 - Listar todos os Contatos");
            System.out.println("8 - Limpar Agenda");
            System.out.println("9 - Editar Contato");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção:");
            opcaouser = scanner.nextInt();
            scanner.nextLine();

            switch (opcaouser) {
                case 1:
                    agenda.importararquivo();
                    break;
                case 2:
                    agenda.salvarcontato();
                case 3:
                    System.out.println("-----------------------------------");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String fone = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String end = scanner.nextLine();
                    agenda.novocontato(nome, fone, end);
                    break;
                case 4:
                    System.out.print("Nome: ");
                    String deletanome = scanner.nextLine();
                    agenda.deletapornome(deletanome);
                    break;
                case 5:
                    System.out.print("Nome: ");
                    System.out.println("-----------------------------------");
                    String buscapornome = scanner.nextLine();
                    agenda.contatospornome(buscapornome);
                    break;
                case 6:
                    System.out.print("Telefone: ");
                    String buscaporfone = scanner.nextLine();
                    agenda.contatoporfone(buscaporfone);
                    break;
                case 7:
                    agenda.listadecontato();
                    break;
                case 8:
                    agenda.limpezadeagenda();
                    break;
                case 9: 
                    System.out.print("Nome: ");
                    String editarpornome = scanner.nextLine();
                    agenda.editarcontato(editarpornome);
                    break;
                case 0:
                    System.out.println("-----------------------------------");
                    System.out.print("ENCERRANDO AGENDA DE CONTATOS...");
                    break;
                default:
                    System.out.print("OPÇÃO INVÁLIDA! TENTE DE NOVO!\n");
                    break;
                } 
            } while (opcaouser != 11);

            scanner.close();
    }
}
