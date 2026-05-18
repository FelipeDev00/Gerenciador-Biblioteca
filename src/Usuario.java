import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String cpf;
    private int id;

    private List<ItemBiblioteca> itensEmprestados = new ArrayList<>();

    public Usuario(String nome, String cpf, int id) {
        this.nome = nome;
        this.cpf = cpf;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getId() {
        return id;
    }

    public void pegarItem(ItemBiblioteca item) {
        itensEmprestados.add(item);
    }
    public void devolverItem(ItemBiblioteca item) {
        itensEmprestados.remove(item);
    }

    public List<ItemBiblioteca> getItensEmprestados() {
        return itensEmprestados;
    }
}
