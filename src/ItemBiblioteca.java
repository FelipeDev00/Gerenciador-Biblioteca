public abstract class ItemBiblioteca {
    protected int id;
    protected String titulo;

    public ItemBiblioteca(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }
    public int getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }

    public abstract void exibirDetalhes();


}
