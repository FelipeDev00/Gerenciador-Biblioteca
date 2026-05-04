import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<ItemBiblioteca> itemBiblioteca =  new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
        System.out.println("Autor '" + autor.getNome() + "' adicionado com sucesso!" );
    }

    public void adicionarItem(ItemBiblioteca item){
        itemBiblioteca.add(item);
        System.out.println("Item '" + item.getTitulo() + "' adicionado com sucesso!");
    }

   public void listarItens(){
        if(itemBiblioteca.isEmpty()){
            System.out.println("Nenhum item encontrado \n");
        } else {
            for(ItemBiblioteca item : itemBiblioteca){
                System.out.println(item);
            }
        }
    }

    public void procurarPorAutor(String autorBusca){
        boolean encontrado = false;

        for(ItemBiblioteca item : itemBiblioteca){
            if(item instanceof Livro livro){
                if(livro.getAutor().equalsIgnoreCase(autorBusca)){
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
