import java.util.Scanner;

void main() {
    int tipoUsuario = 0;
    int idUsuario = 1;
    int opcao;
    int id = 1;

    //Scanner para receber os dados digitados pelo usuário no terminal. (Sem front-end ou interface)
    Scanner sc = new Scanner(System.in);
    //Inicialização do objeto biblioteca para usar seus métodos públicos na classe Main.
    Biblioteca biblioteca = new Biblioteca();

    //Loop DO-WHILE para fazer as perguntas (DO) depois verificar a resposta (WHILE)
    do {
        try {
            System.out.println("Bem vindo ao sistema da biblioteca! Selecione a opção desejada \n");
            System.out.println(" 1 - Realizar login como funcionário \n 2 - Realizar login como usuário \n 3 - Sair do sistema");
            tipoUsuario = sc.nextInt();
            if (tipoUsuario == 1) {
                System.out.println(" \nLogin realizado como funcionário.\nSelecione a opção desejada:");
                do {
                    System.out.println(" \n 1 - Cadastrar usuário \n 2 - Cadastrar autor \n 3 - Adicionar item (Livro ou Revista) \n 4 - Listar usuários cadastrados \n 5 - Listar autores cadastrados \n 6 - Listar todos os itens cadastrados \n 7 - Procurar livro por autor \n 8 - Voltar a página inicial");
                    opcao = sc.nextInt();
                    sc.nextLine();
                    switch (opcao) {
                        case 1:
                            System.out.println("Digite o nome completo do usuário: ");
                            String nomeUsuario = sc.nextLine();
                            System.out.println("Digite o CPF do usuário: ");
                            String cpfUsuario = sc.nextLine();

                            Usuario novoUsuario = new Usuario(nomeUsuario, cpfUsuario, idUsuario);
                            novoUsuario.setId(idUsuario);
                            biblioteca.adicionarUsuario(novoUsuario);
                            idUsuario++;
                            break;
                        case 2:
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

                        case 3:
                            System.out.println("Qual item você deseja adicionar? (Selecione apenas o número correspondente) \n 1 - Livro \n 2 - Revista");
                            String item = sc.nextLine(); //Lê e armazena a opção digitada pelo usuário.

                            //Se a opção for '1'(livro), pergunta ao usuário informações sobre o livro.
                            if (item.equals("1")) {
                                System.out.println("Digite o nome do livro: ");
                                String nomeLivro = sc.nextLine();
                                System.out.println("Digite o nome do autor do livro: ");
                                String autorLivro = sc.nextLine();
                                System.out.println("Digite o ISBN do livro: ");
                                String isbn = sc.nextLine();

                                //Verifica se todas as informações foram preenchidas antes de continuar.
                                if (nomeLivro.isBlank() || autorLivro.isBlank() || isbn.isBlank()) {
                                    System.out.println("ERRO: Todos os campos são obrigatórios. O livro não foi adicionado.");
                                } else {
                                    //Chama o método que busca o objeto Autor na lista. Se encontrar, traz o objeto para o Main; se não, traz null.
                                    Autor validarAutor = biblioteca.validarAutor(autorLivro);
                                    if (validarAutor == null) {
                                        System.out.println("ERRO: O autor não existe ou não foi cadastrado. \n");
                                    } else {
                                        //Com tudo validado, é criado um novo objeto do tipo Livro e adicionado a biblioteca.
                                        Livro novoLivro = new Livro(id, nomeLivro, validarAutor, isbn);
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

                        case 4:
                            biblioteca.listarUsuarios();
                            break;

                        case 5:
                            biblioteca.listarAutores(); //Chama o método que lista todos os autores e seus dados cadastrados na biblioteca.
                            break;

                        case 6:
                            biblioteca.listarItens(); //Chama o método que lista todos os itens da biblioteca (Livros e Revistas).
                            break;

                        case 7:
                            System.out.println("Digite o nome do autor do livro: ");
                            String autorLivro = sc.nextLine();
                            biblioteca.procurarPorAutor(autorLivro); //Chama o método que procura um livro específico na lista relacionado ao nome do autor digitado pelo usuário e mostra seus detalhes.
                            break;


                        case 8:
                            System.out.println("Realizando Logon... \n");
                            break;

                        default:
                            System.out.println("Opção inválida. \n");
                    }

                } while (opcao != 8);


            } else if (tipoUsuario == 2) {
                System.out.println(" \nLogin realizado como usuário. \nSelecione a opcao desejada: \n");
                do {
                    System.out.println(" 1 - Pegar um item emprestado \n 2 - Devolver um item\n 3 - Listar todos os itens \n 4 - Listar autores cadastrados \n 5 - Procurar livro por autor \n 6 - Voltar a página inicial");
                    opcao = sc.nextInt();
                    sc.nextLine();
                    switch (opcao) {
                        case 1:
                            System.out.println("Qual item você deseja pegar emprestado? Livro [1] | Revista [2] \n Digite somente o número do item desejado: ");
                            String item = sc.nextLine();

                            if (item.equals("1")) {
                                System.out.println("Ok! Essa é a lista de livros disponíveis no sistema: \n");
                                if (biblioteca.listarLivrosDisponiveis()){
                                    System.out.println("\nDigite o título do livro que você quer pegar emprestado: ");
                                    String livro = sc.nextLine();
                                    int idLivro = biblioteca.getIdItem(livro);
                                    System.out.println("");
                                    System.out.println("Digite o nome do seu usuário cadastrado no sistema: ");
                                    String nomeUsuario = sc.nextLine();
                                    System.out.println("");
                                    int usuarioId = biblioteca.getIdUsuario(nomeUsuario);
                                    biblioteca.emprestarItem(idLivro, usuarioId);
                                } else {
                                    System.out.println("Não há livros disponíveis no momento. \n");
                                }





                            } else if (item.equals("2")) {
                                System.out.println("Ok! Essa é a lista de revistas disponíveis no sistema: \n");
                                if (biblioteca.listarRevistasDisponiveis()){
                                    System.out.println("\nDigite o titulo da revista que você quer pegar emprestado: ");
                                    String revista = sc.nextLine();
                                    int idRevista = biblioteca.getIdItem(revista);
                                    System.out.println("");
                                    System.out.println("Digite o nome do seu usuário cadastrado no sistema: ");
                                    String nomeUsuario = sc.nextLine();
                                    System.out.println("");
                                    int usuarioId = biblioteca.getIdUsuario(nomeUsuario);
                                    biblioteca.emprestarItem(idRevista, usuarioId);
                                } else {
                                    System.out.println("Não há revistas disponíveis no momento. \n");
                                }
                            }
                            break;

                        case 2:
                            System.out.println("Digite seu nome completo cadastrado no sistema: ");
                            String nomeUsuario = sc.nextLine();
                            int usuarioId = biblioteca.getIdUsuario(nomeUsuario);
                            System.out.println("\nLista de itens emprestados para " + nomeUsuario + ":\n");
                            biblioteca.listarItensEmprestados(nomeUsuario);
                            System.out.println("Digite o nome do item que deseja devolver: ");
                            String nomeItem = sc.nextLine();
                            int  idItem = biblioteca.getIdItem(nomeItem);
                            biblioteca.devolucaoItem(idItem, usuarioId);



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
                            System.out.println("Realizando Logon... \n");
                    }
                } while (opcao != 6);

            } else {
                System.out.println("Obrigado por utilizar nosso sistema! \n");
            }

        } catch (InputMismatchException e) {
            System.out.println("ERRO: Selecione apenas o número da opção desejada. \n");
            sc.nextLine();
            opcao = 0;
        }

    } while (tipoUsuario != 3);


}


