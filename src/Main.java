import java.util.Scanner;

void main() {
    int opcao;
    int id = 1;
    Scanner sc = new Scanner(System.in);

    Biblioteca biblioteca = new Biblioteca();

    do {
        System.out.println(" 1 - Adicionar livro \n 2 - Listar todos os livros \n 3 - Procurar livro por autor \n 4 - Sair");
        opcao = sc.nextInt();
        sc.nextLine();
        switch (opcao){
            case 1:
                System.out.println("Digite o nome do livro: ");
                String nome = sc.nextLine();
                System.out.println("Digite o autor do livro: ");
                String autor = sc.nextLine();
                System.out.println("Digite o ISBN do livro: ");
                String isbn = sc.nextLine();

                if (nome.isBlank() || autor.isBlank() || isbn.isBlank()) {
                    System.out.println("ERRO: Todos os campos são obrigatórios. O livro não foi adicionado.");
                } else {
                    Livro novoLivro = new Livro(id, nome, autor, isbn);

                    biblioteca.adicionarLivro(novoLivro);
                    System.out.println("Livro adicionado com sucesso!");
                    id++;
                }
                break;


            case 2:
                biblioteca.listarLivros();
                break;

            case 3:
                System.out.println("Digite o nome do autor do livro: ");
                String nomeAutor = sc.nextLine();

                biblioteca.procurarPorAutor(nomeAutor);
                break;

            case 4:
                System.out.println("Obrigado por utilizar nosso sistema! ");
                break;

            default:
                System.out.println("Opção inválida. \n");
        }


    } while (opcao != 4 );












    }


