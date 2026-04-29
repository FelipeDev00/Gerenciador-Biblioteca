public class Revista extends ItemBiblioteca {
    private int edicao;

    public Revista(int id, String titulo, int edicao) {
        super(id, titulo);
        this.edicao = edicao;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Revista [ID: " + id + " | Título: " + titulo + " | Edição: " + edicao + "]");
    }
}