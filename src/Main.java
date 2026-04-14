import java.util.Scanner;

void main() {
    int opcao;
    Scanner sc = new Scanner(System.in);

    do {
        System.out.println(" 1 - Adicionar livro \n 2 - Listar todos os livros \n 3 - Procurar livro por autor \n 4 - Sair");
        opcao = sc.nextInt();
        switch (opcao){
            case 1:
                System.out.println("Digite o nome do livro: ");
                String nome = sc.next();
                System.out.println("Digite o autor do livro: ");
                String autor = sc.next();
                System.out.println("Digite o ISBN do livro: ");
                String isbn = sc.next();

                Livro livro = new Livro(nome, autor, isbn);
                livro.setTitulo(nome);
                livro.setAutor(autor);
                livro.setIsbn(isbn);

                bibliotr
                System.out.println("Livro adicionado com sucesso!");


                break;


            case 2:



                break;

            case 3:

                break;

            case 4:

                break;
        }


    } while (opcao != 4 );












    }


