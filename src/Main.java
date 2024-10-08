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
            System.out.print("Escolha uma opção:");
            opcaouser = scanner.nextInt();
            scanner.nextLine();

            switch (opcaouser) {
                case 1:
                    agenda.importacontato("data/contatos.txt");
                    break;
                case 2:
                    agenda.exportacontato();
                    break;
                case 3:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String fone = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String end = scanner.nextLine();
                    agenda.novocontato(nome, fone, end);
                    break;
                case 4:
                    System.out.print("Número de Telefone: ");
                    String deletatelefone = scanner.nextLine();
                    agenda.deletaportelefone(deletatelefone);
                    break;
                case 5:
                    System.out.print("Nome: ");
                    String deletanome = scanner.nextLine();
                    agenda.deletapornome(deletanome);
                    break;
                case 6:
                    System.out.print("Nome: ");
                    String buscapornome = scanner.nextLine();
                    agenda.contatospornome(buscapornome);
                    break;
                case 7:
                    System.out.print("Telefone: ");
                    String buscaporfone = scanner.nextLine();
                    agenda.contatoporfone(buscaporfone);
                    break;
                case 8:
                    agenda.listadecontato();
                    break;
                case 9:
                    System.out.print("Número de Telefone: ");
                    String fonechamada = scanner.nextLine();
                    agenda.fazerchamada(fonechamada);
                    break;
                case 10:
                    agenda.limpezadeagenda();
                    break;
                case 11:
                    System.out.print("Encerrando aplicação de agenda de contatos...");
                    break;
                default:
                    System.out.print("Opção inválida! Tente novamente.");
                    break;
                } 
            } while (opcaouser != 11);

            scanner.close();
    }
}
