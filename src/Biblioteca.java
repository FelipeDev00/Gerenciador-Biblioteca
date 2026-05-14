import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<ItemBiblioteca> itemBiblioteca =  new ArrayList<>(); //Lista que armazena objetos do tipo ItemBiblioteca (Livros e Revistas).
    private List<Autor> autores = new ArrayList<>(); //Lista que armazena objetos do tipo Autor.

    //Método para adicionar o objeto autor na lista 'autores'.
    //Ao ser chamado, recebe como parâmetro um objeto completo do tipo Autor.
    public void adicionarAutor(Autor autor) {
        autores.add(autor);
        System.out.println("Autor '" + autor.getNome() + "' adicionado com sucesso!" );
    }

    //Método para adicionar um objeto do tipo 'ItemBiblioteca' na lista.
    //Ao ser chamado, recebe como parâmetro um objeto completo do tipo ItemBiblioteca (Livro ou Revista).
    public void adicionarItem(ItemBiblioteca item){
        itemBiblioteca.add(item);
        System.out.println("Item '" + item.getTitulo() + "' adicionado com sucesso!");
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
                    System.out.println(livro);
                    encontrado = true;
                    System.out.println("\n");
                }
            }
        }
        if(!encontrado){
            System.out.println("Nenhum livro encontrado para este autor. \n");
        }
    }
}
