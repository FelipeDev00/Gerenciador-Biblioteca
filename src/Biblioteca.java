import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> livros =  new ArrayList<>();

    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }

    void listarLivros(){
        if(livros.isEmpty()){
            System.out.println("Nenhum livro encontrado \n");
        } else {
            for(Livro livro : livros){
                System.out.println(livro);
            }
        }
    }
    void procurarPorAutor(String autorBusca){
        boolean encontrado = false;

        for(Livro livro : livros){
            if(livro.getAutor().equalsIgnoreCase(autorBusca)){
                System.out.println(livro);
                encontrado = true;
                System.out.println("\n");
            }
        }
        if(!encontrado){
            System.out.println("Nenhum livro encontrado para este autor. \n");
        }
    }

}
