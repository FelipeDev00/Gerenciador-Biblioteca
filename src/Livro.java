public class Livro extends ItemBiblioteca{
    private String autor;
    private String isbn;

    public Livro(int id, String titulo, String autor, String isbn) {
        super(id, titulo);
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Livro - ID: " + id + " | Título: " + titulo + " | Autor: " + autor + "]");
    }

    @Override
    public String toString() {
        return "Livro " + id +" - " +
                " Titulo: " + titulo +
                " | Autor: " + autor +
                " | isbn: " + isbn;
    }
}
