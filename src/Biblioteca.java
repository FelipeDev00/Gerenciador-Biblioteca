import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> livros =  new ArrayList<>();

    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }

    public void listarLivros(){
        if(livros.isEmpty()){
            System.out.println("Nenhum livro encontrado \n");
        } else {
            for(Livro livro : livros){
                System.out.println(livro);
            }
        }
    }

}
