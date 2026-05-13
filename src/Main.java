import java.util.Scanner;

void main() {
    int opcao;
    int id = 1;

    //Scanner para receber os dados digitados pelo usuário no terminal. (Sem front-end ou interface)
    Scanner sc = new Scanner(System.in);
    //Inicialização do objeto biblioteca para usar seus métodos públicos na classe Main.
    Biblioteca biblioteca = new Biblioteca();

    //Loop DO-WHILE para fazer as perguntas (DO) depois verificar a resposta (WHILE)
    do {
        System.out.println(" 1 - Cadastrar autor \n 2 - Adicionar item \n 3 - Listar todos os itens \n 4 - Listar autores cadastrados \n 5 - Procurar livro por autor \n 6 - Sair");
        opcao = sc.nextInt();
        sc.nextLine();
        switch (opcao){
            case 1:
                System.out.println("Digite o nome do autor: ");
                String nomeAutor = sc.nextLine(); //Armazena o nome do autor
                System.out.println("Digite a nacionalidade do autor do livro:");
                String nacionalidade = sc.nextLine(); //Armazena a nacionalidade do autor

                //Verifica se o nome ou a nacionalidade do autor estão vazias antes de prosseguir.
                if (nomeAutor.isBlank() || nacionalidade.isBlank()) {
                    System.out.println("ERRO: Preencha todos os campos para adicionar o autor.");
                    break;
                }
                //Com tudo preenchido, é criado um novo objeto do tipo Autor com nome e nacionalidade
                //É adicionado o novo objeto do tipo autor na biblioteca
                Autor novoAutor = new Autor(nomeAutor, nacionalidade);
                biblioteca.adicionarAutor(novoAutor);
                break;

            case 2:
                System.out.println("Qual item você deseja adicionar? (Selecione apenas o número correspondente) \n 1 - Livro \n 2 - Revista");
                String item = sc.nextLine(); //Lê e armazena a opção digitada pelo usuário.

                //Se a opção for '1'(livro), pergunta ao usuário informações sobre o livro.
                if(item.equals("1")){
                    System.out.println("Digite o nome do livro: ");
                    String nomeLivro = sc.nextLine();
                    System.out.println("Digite o nome do autor do livro: ");
                    String autorLivro = sc.nextLine();
                    System.out.println("Digite o ISBN do livro: ");
                    String isbn = sc.nextLine();

                    //Verifica se todas as informações foram preenchidas antes de continuar.
                    if (nomeLivro.isBlank() || autorLivro.isBlank() || isbn.isBlank()) {
                        System.out.println("ERRO: Todos os campos são obrigatórios. O livro não foi adicionado.");
                    }

                    else {
                        //Chama o método que busca o objeto Autor na lista. Se encontrar, traz o objeto para o Main; se não, traz null.
                        Autor validarAutor = biblioteca.validarAutor(autorLivro);
                        if (validarAutor == null) {
                            System.out.println("ERRO: O autor não existe ou não foi cadastrado. \n");
                        } else {
                            //Com tudo validado, é criado um novo objeto do tipo Livro e adicionado a biblioteca.
                            Livro novoLivro = new Livro(id, nomeLivro,validarAutor, isbn);
                            biblioteca.adicionarItem(novoLivro);
                            id++;
                        }
                    }
                  //Se o item for '2'(revista), pergunta ao usuário informações sobre a revista
                } else if (item.equals("2")) {
                    System.out.println("Digite o nome da Revista: ");
                    String nomeRevista = sc.nextLine();
                    System.out.println("Digite a edição da Revista: ");
                    int edicao = sc.nextInt();

                    //Verifica se os campos foram preenchidos.
                    if (nomeRevista.isBlank() || edicao == 0) {
                        System.out.println("ERRO: Todos os campos são obrigatórios. O livro não foi adicionado.");
                    } else {
                        //Com tudo preenchido, é criado um novo objeto do tipo Revista e adicionado a biblioteca.
                        Revista novaRevista = new Revista(id, nomeRevista, edicao);
                        biblioteca.adicionarItem(novaRevista);
                        id++;
                    }
                }
                break;

            case 3:
                biblioteca.listarItens(); //Chama o método que lista todos os itens da biblioteca (Livros e Revistas).
                break;

            case 4:
                biblioteca.listarAutores(); //Chama o método que lista todos os autores e seus dados cadastrados na biblioteca.
                break;

            case 5:
                System.out.println("Digite o nome do autor do livro: ");
                String autorLivro = sc.nextLine();
                biblioteca.procurarPorAutor(autorLivro); //Chama o método que procura um livro específico na lista relacionado ao nome do autor digitado pelo usuário e mostra seus detalhes.
                break;



            case 6:
                System.out.println("Obrigado por utilizar nosso sistema! ");
                break;

            default:
                System.out.println("Opção inválida. \n");
        }


    } while (opcao != 6);

    }


