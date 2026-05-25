import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<ItemBiblioteca> itemBiblioteca =  new ArrayList<>(); //Lista que armazena objetos do tipo ItemBiblioteca (Livros e Revistas).
    private List<Autor> autores = new ArrayList<>(); //Lista que armazena objetos do tipo Autor.
    private List <Usuario> usuarios = new ArrayList<>(); //Lista que armazena os usuários da biblioteca

    //Método para adicionar um autor na lista de autores.
    //Recebe como parâmetro um objeto completo do tipo Autor e executa o método.
    public void adicionarAutor(Autor autor) {
        autores.add(autor);
        System.out.println("Autor '" + autor.getNome() + "' adicionado com sucesso!" );
    }

    //Método para adicionar um item (Revista ou Livro) na lista 'ItemBiblioteca'.
    //Recebe como parâmetro um objeto completo do tipo 'ItemBiblioteca (Livro ou Revista)' e executa o método.
    public void adicionarItem(ItemBiblioteca item){
        itemBiblioteca.add(item);
        System.out.println("Item '" + item.getTitulo() + "' adicionado com sucesso!");
    }
    //Método para adicionar um usuário na lista de usuários.
    //Recebe como parâmetro um objeto completo do tipo 'Usuário' e executa o método
    public void adicionarUsuario(Usuario usuario){
        usuarios.add(usuario);
        System.out.println("Usuario '" + usuario.getNome() + "' adicionado com sucesso! \n");
    }
    //Método para listar todos os usuários da biblioteca.
    public void listarUsuarios(){
        if (usuarios.isEmpty()){
            System.out.println("Nenhum usuario encontrado \n");
        } else {
            for (Usuario usuario : usuarios){
                System.out.println(usuario);
            }
        }
    }
    //Método para listar todos os itens da biblioteca.
    //Percorre a lista itemBiblioteca com for each, armazena os itens na variavel 'item' do tipo 'ItemBiblioteca' e mostra os resultados 1 por 1 até o final da lista.
   public void listarItens(){
        if(itemBiblioteca.isEmpty()){
            System.out.println("Nenhum item encontrado \n"); //Verifica se a lista está vazia antes de executar o for each.
        } else {
            for(ItemBiblioteca item : itemBiblioteca){
                item.exibirDetalhes();
            }
            System.out.println("");
        }
    }

    public boolean listarLivrosDisponiveis() {
        boolean encontrouAlgum = false;

        for (ItemBiblioteca item : itemBiblioteca) {
            // Verifica se é Livro E se está disponível
            if (item instanceof Livro && item.isDisponivel()) {
                encontrouAlgum = true;
                item.exibirDetalhes();
            }
        }
        return encontrouAlgum;
    }
    public boolean listarRevistasDisponiveis() {
        boolean encontrouAlgum = false;

        for (ItemBiblioteca item : itemBiblioteca) {
            if (item instanceof Revista && item.isDisponivel()) {
                encontrouAlgum = true;
                item.exibirDetalhes();

            }  else  {
                encontrouAlgum = false;
            }
        }
        return encontrouAlgum;
    }

    public void emprestarItem(int idItem, int idUsuario){
        for (ItemBiblioteca item : itemBiblioteca){
            if (item.id == idItem && item.isDisponivel()) {
                for (Usuario usuario : usuarios){
                    if (usuario.getId() == idUsuario){
                        if (item instanceof Livro){
                            System.out.println("O livro '" + item.getTitulo() + "' foi emprestado para o usuário '" + usuario.getNome() + "'! \n");
                            usuario.pegarItem(item);
                            item.setDisponivel(false);
                        }
                        if(item instanceof Revista){
                            System.out.println("A revista '" + item.getTitulo() + "' foi emprestada para o usuário '" + usuario.getNome() + "'! \n");
                            usuario.pegarItem(item);
                            item.setDisponivel(false);
                        }
                    }
                }
            }
        }
    }

    public void devolucaoItem(int idItem, int idUsuario){
        for (ItemBiblioteca item : itemBiblioteca){
            if (item.id == idItem && !item.isDisponivel()) {
                for (Usuario usuario : usuarios){
                    if (usuario.getId() == idUsuario){
                        if (item instanceof Livro){
                            usuario.devolverItem(item);
                            item.setDisponivel(true);
                            System.out.println("O livro '" + item.getTitulo() + "' foi devolvido com sucesso! \n");
                        }
                        if (item instanceof Revista){
                            usuario.devolverItem(item);
                            item.setDisponivel(true);
                            System.out.println("A revista '" + item.getTitulo() + "' foi devolvida com sucesso! \n");
                        }
                    }
                }
            }
        }
    }

    public void listarItensEmprestados(String nomeUsuario){
        for (Usuario usuario : usuarios){
            if (usuario.getNome().equalsIgnoreCase(nomeUsuario)){
                System.out.println(usuario.getItensEmprestados());
            }
        }
    }

    //Método para listar todos os autores cadastrados no sistema.
    //Mesma dinâmica do método 'listarItens', mas com variável do tipo Autor.
    public void listarAutores(){
        if(autores.isEmpty()){
            System.out.println("Nenhum autor encontrado \n");
        }  else {
            for(Autor autor : autores){
                System.out.println(autor);
            }
        }
    }

    //Método para verificar se o autor existe no sistema.
    //Recebe como parâmetro um nome (String) e executa um for each na lista de autores para procurar o autor com o mesmo nome que recebeu no parâmetro.
    public Autor validarAutor(String nome){
        for(Autor autor : autores) {
            if (autor.getNome().equalsIgnoreCase(nome)) {
                return autor;
            }
        }
        return null; //Retorna null caso não ache nenhum autor com o mesmo nome do parâmetro passado ao método.
    }

    public int getIdUsuario(String nome){
        int idUsuario = 0;
        for(Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                idUsuario = usuario.getId();
            }
        }
        return idUsuario;
    }

    public int getIdItem(String nome){
        int idItem = 0;
        for(ItemBiblioteca item : itemBiblioteca) {
            if (item instanceof Livro && item.getTitulo().equalsIgnoreCase(nome)) {
                idItem = item.id;
                break;
            }
            if (item instanceof Revista && item.getTitulo().equalsIgnoreCase(nome)) {
                idItem = item.id;
                break;
            }

        }
        return idItem;
    }

    //Método para procurar um livro que seja relacionado a um autor específico.
    //Executa um for each na lista itemBiblioteca e se for um livro, verifica se o autor relacionado é o mesmo do parâmetro recebido.
    public void procurarPorAutor(String autorBusca){ //Recebe como parâmetro o nome do autor.
        boolean encontrado = false;

        for(ItemBiblioteca item : itemBiblioteca){ //Percorre a lista de itemBiblioteca
            if(item instanceof Livro livro){ //SE o item for da mesma instância que 'Livro', faça.
                if(autorBusca.equalsIgnoreCase(livro.getAutor().getNome())){
                    livro.exibirDetalhes();
                    encontrado = true;
                }
            }
        }
        if(!encontrado){
            System.out.println("Nenhum livro encontrado para este autor. \n");
        }
    }
}
