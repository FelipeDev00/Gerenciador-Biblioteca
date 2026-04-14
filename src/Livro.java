public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int id = 1;

    public Livro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void adicionarLivro(Livro livro){

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.livros.add(livro);
    }

    @Override
    public String toString() {
        return "Livro " + id++ +
                " - titulo: " + titulo +
                ", autor: " + autor +
                ", isbn: " + isbn;
    }
}
