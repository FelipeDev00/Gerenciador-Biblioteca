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
                System.out.println(item);
            }
        }
    }

    public void listarLivrosDisponiveis(){
        for (ItemBiblioteca item : itemBiblioteca){
            if (item instanceof Livro && item.isDisponivel()){
                System.out.println(item);
            } else {
                System.out.println("Não há livros disponíveis no momento. \n");
            }
        }
    }
    public void listarRevistasDisponiveis(){
        for (ItemBiblioteca item : itemBiblioteca){
            if (item instanceof Revista && item.isDisponivel()){
                System.out.println(item);
            } else {
                System.out.println("Não há revistas disponíveis no momento.");
            }
        }
    }

    public void emprestarItem(int idItem, int idUsuario){
        if (itemBiblioteca.isEmpty()){
            System.out.println("Não há item disponível para emprestar. \n");
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
