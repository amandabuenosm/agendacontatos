import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Passa o caminho do arquivo diretamente ao criar a agenda
        Agenda agenda = new Agenda("data/contatos.txt");
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Importar Contatos");
            System.out.println("2 - Exportar Contatos");
            System.out.println("3 - Inserir Contato");
            System.out.println("4 - Remover Contato pelo Telefone");
            System.out.println("5 - Remover Contato pelo Nome");
            System.out.println("6 - Localizar Contato pelo Nome");
            System.out.println("7 - Localizar Contato pelo Telefone");
            System.out.println("8 - Listar todos os Contatos");
            System.out.println("9 - Realizar Chamada");
            System.out.println("10 - Limpar Agenda");
            System.out.println("11 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    agenda.importarContatos("data/contatos.txt");
                    break;
                case 2:
                    agenda.exportarContatos();
                    break;
                case 3:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    agenda.inserirContato(nome, telefone, endereco);
                    break;
                case 4:
                    System.out.print("Número de Telefone: ");
                    String telefoneRemover = scanner.nextLine();
                    agenda.removerContatoPorTelefone(telefoneRemover);
                    break;
                case 5:
                    System.out.print("Nome: ");
                    String nomeRemover = scanner.nextLine();
                    agenda.removerContatoPorNome(nomeRemover);
                    break;
                case 6:
                    System.out.print("Nome: ");
                    String nomeLocalizar = scanner.nextLine();
                    agenda.localizarContatoPorNome(nomeLocalizar);
                    break;
                case 7:
                    System.out.print("Telefone: ");
                    String telefoneLocalizar = scanner.nextLine();
                    agenda.localizarContatoPorTelefone(telefoneLocalizar);
                    break;
                case 8:
                    agenda.listarContatos();
                    break;
                case 9:
                    System.out.print("Número de Telefone: ");
                    String telefoneChamada = scanner.nextLine();
                    agenda.realizarChamada(telefoneChamada);
                    break;
                case 10:
                    agenda.limparAgenda();
                    break;
                case 11:
                    System.out.println("Saindo da agenda.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 11);

        scanner.close();
    }
}
