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

                Livro livro = new Livro(id, nome, autor, isbn);
                livro.setTitulo(nome);
                livro.setAutor(autor);
                livro.setIsbn(isbn);

                Livro novoLivro = new Livro(id, nome, autor, isbn);

                biblioteca.adicionarLivro(novoLivro);
                System.out.println("Livro adicionado com sucesso! \n");
                id++;
                livro.setId(id);
                break;


            case 2:
                biblioteca.listarLivros();
                break;

            case 3:

                break;

            case 4:

                break;
        }


    } while (opcao != 4 );












    }


