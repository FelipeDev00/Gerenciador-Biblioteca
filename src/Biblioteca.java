import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<ItemBiblioteca> itemBiblioteca =  new ArrayList<>();

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



}
