import java.util.Scanner;

void main() {
    int opcao;
    int id = 1;

    Scanner sc = new Scanner(System.in);

    Biblioteca biblioteca = new Biblioteca();

    do {
        System.out.println(" 1 - Cadastrar autor \n 2 - Adicionar item \n 3 - Listar todos os itens \n 4 - Listar autores cadastrados \n 5 - Procurar livro por autor \n 6 - Sair");
        opcao = sc.nextInt();
        sc.nextLine();
        switch (opcao){
            case 1:
                System.out.println("Digite o nome do autor: ");
                String nomeAutor = sc.nextLine();
                System.out.println("Digite a nacionalidade do autor do livro:");
                String nacionalidade = sc.nextLine();

                if (nomeAutor.isBlank() || nacionalidade.isBlank()) {
                    System.out.println("ERRO: Preencha todos os campos para adicionar o autor.");
                    break;
                }
                Autor novoAutor = new Autor(nomeAutor, nacionalidade);
                biblioteca.adicionarAutor(novoAutor);
                break;

            case 2:
                System.out.println("Qual item você deseja adicionar? (Selecione apenas o número correspondente) \n 1 - Livro \n 2 - Revista");
                String item = sc.nextLine();
                if(item.equals("1")){
                    System.out.println("Digite o nome do livro: ");
                    String nomeLivro = sc.nextLine();
                    System.out.println("Digite o nome do autor do livro: ");
                    String autorLivro = sc.nextLine();
                    System.out.println("Digite o ISBN do livro: ");
                    String isbn = sc.nextLine();

                    if (nomeLivro.isBlank() || autorLivro.isBlank() || isbn.isBlank()) {
                        System.out.println("ERRO: Todos os campos são obrigatórios. O livro não foi adicionado.");
                    }

                    else {
                        Autor validarAutor = biblioteca.validarAutor(autorLivro);
                        if (validarAutor == null) {
                            System.out.println("ERRO: O autor não existe ou não foi cadastrado. \n");
                        } else {
                            Livro novoLivro = new Livro(id, nomeLivro,validarAutor, isbn);
                            biblioteca.adicionarItem(novoLivro);
                            id++;
                        }
                    }

                } else if (item.equals("2")) {
                    System.out.println("Digite o nome da Revista: ");
                    String nomeRevista = sc.nextLine();
                    System.out.println("Digite a edição da Revista: ");
                    int edicao = sc.nextInt();

                    if (nomeRevista.isBlank() || edicao == 0) {
                        System.out.println("ERRO: Todos os campos são obrigatórios. O livro não foi adicionado.");
                    } else {
                        Revista novaRevista = new Revista(id, nomeRevista, edicao);
                        biblioteca.adicionarItem(novaRevista);
                        id++;
                    }
                }
                break;

            case 3:
                biblioteca.listarItens();
                break;

            case 4:
                biblioteca.listarAutores();
                break;

            case 5:
                System.out.println("Digite o nome do autor do livro: ");
                String autorLivro = sc.nextLine();
                biblioteca.procurarPorAutor(autorLivro);
                break;



            case 6:
                System.out.println("Obrigado por utilizar nosso sistema! ");
                break;

            default:
                System.out.println("Opção inválida. \n");
        }


    } while (opcao != 6);

    }


