public class Livro extends ItemBiblioteca{
    private Autor autor;
    private String isbn;

    public Livro(int id, String titulo, Autor autor, String isbn) {
        super(id, titulo);
        this.autor = autor;
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Livro - ID: " + id + " | Título: " + titulo + " | Autor: " + autor.getNome() + "]");
    }

    @Override
    public String toString() {
        return "Livro " + id +" - " +
                " Titulo: " + titulo +
                " | Autor: " + autor +
                " | isbn: " + isbn;
    }
}
