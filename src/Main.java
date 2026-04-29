import java.util.Scanner;

void main() {
    int opcao;
    int id = 1;
    Scanner sc = new Scanner(System.in);

    Biblioteca biblioteca = new Biblioteca();

    do {
        System.out.println(" 1 - Adicionar item \n 2 - Listar todos os itens \n 3 - Procurar livro por autor \n 4 - Sair");
        opcao = sc.nextInt();
        sc.nextLine();
        switch (opcao){
            case 1:
                System.out.println("Qual item você deseja adicionar? (Selecione apenas o número correspondente) \n 1 - Livro \n 2 - Revista");
                String item = sc.nextLine();
                if(item.equals("1")){
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
                        biblioteca.adicionarItem(novoLivro);
                        id++;
                    }

                } else if (item.equals("2")) {
                    System.out.println("Digite o nome da Revista: ");
                    String nome = sc.nextLine();
                    System.out.println("Digite a edição da Revista: ");
                    int edicao = sc.nextInt();

                    if (nome.isBlank() || edicao == 0) {
                        System.out.println("ERRO: Todos os campos são obrigatórios. O livro não foi adicionado.");
                    } else {
                        Revista novaRevista = new Revista(id, nome, edicao);
                        biblioteca.adicionarItem(novaRevista);
                        id++;
                    }
                }
                break;


            case 2:
                biblioteca.listarItens();
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


