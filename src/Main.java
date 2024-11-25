import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorDiscos gerenciador = new GerenciadorDiscos();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionarDisco(gerenciador, scanner);
                case 2 -> adicionarArtista(gerenciador, scanner);
                case 3 -> listarDiscos(gerenciador);
                case 4 -> editarDisco(gerenciador, scanner);
                case 5 -> removerDisco(gerenciador, scanner);
                case 0 -> {
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 - Adicionar Disco");
        System.out.println("2 - Adicionar Artista a um Disco");
        System.out.println("3 - Listar Discos");
        System.out.println("4 - Editar Disco");
        System.out.println("5 - Remover Disco");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarDisco(GerenciadorDiscos gerenciador, Scanner scanner) {
        System.out.print("Digite o título do disco: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o ano do disco: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        Disco disco = new Disco(titulo, ano);
        System.out.print("Quantas faixas deseja adicionar? ");
        int totalFaixas = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < totalFaixas; i++) {
            System.out.print("Digite o nome da faixa: ");
            disco.adicionarFaixa(scanner.nextLine());
        }
        gerenciador.adicionarDisco(disco);
        System.out.println("Disco adicionado com sucesso!");
    }

    private static void adicionarArtista(GerenciadorDiscos gerenciador, Scanner scanner) {
        if (gerenciador.getDiscos().isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
            return;
        }
        System.out.println("Escolha um disco:");
        gerenciador.listarDiscos();
        int escolha = scanner.nextInt() - 1;
        scanner.nextLine();

        Disco discoSelecionado = gerenciador.selecionarDisco(escolha);
        if (discoSelecionado == null) {
            System.out.println("Disco inválido.");
            return;
        }

        System.out.print("Digite o nome do artista: ");
        String nomeArtista = scanner.nextLine();
        System.out.print("Digite o gênero do artista: ");
        String generoArtista = scanner.nextLine();
        discoSelecionado.adicionarArtista(new Artista(nomeArtista, generoArtista));
        System.out.println("Artista adicionado ao disco!");
    }

    private static void listarDiscos(GerenciadorDiscos gerenciador) {
        if (gerenciador.getDiscos().isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
        } else {
            for (Disco disco : gerenciador.getDiscos()) {
                System.out.println("\n" + disco);
            }
        }
    }

    private static void editarDisco(GerenciadorDiscos gerenciador, Scanner scanner) {
        if (gerenciador.getDiscos().isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
            return;
        }
        System.out.println("Escolha um disco para editar:");
        gerenciador.listarDiscos();
        int escolha = scanner.nextInt() - 1;
        scanner.nextLine();

        Disco discoSelecionado = gerenciador.selecionarDisco(escolha);
        if (discoSelecionado == null) {
            System.out.println("Disco inválido.");
            return;
        }

        System.out.print("Digite o novo título: ");
        String novoTitulo = scanner.nextLine();
        System.out.print("Digite o novo ano: ");
        int novoAno = scanner.nextInt();
        scanner.nextLine();
        discoSelecionado.editarDisco(novoTitulo, novoAno);
        System.out.println("Disco editado com sucesso!");
    }

    private static void removerDisco(GerenciadorDiscos gerenciador, Scanner scanner) {
        if (gerenciador.getDiscos().isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
            return;
        }
        System.out.println("Escolha um disco para remover:");
        gerenciador.listarDiscos();
        int escolha = scanner.nextInt() - 1;
        scanner.nextLine();

        Disco discoSelecionado = gerenciador.selecionarDisco(escolha);
        if (discoSelecionado == null) {
            System.out.println("Disco inválido.");
            return;
        }

        gerenciador.removerDisco(discoSelecionado);
        System.out.println("Disco removido com sucesso!");
    }
}
