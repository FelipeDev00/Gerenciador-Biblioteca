public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int id = 1;

    public Livro(int id, String titulo, String autor, String isbn) {
        this.id = id;
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



    @Override
    public String toString() {
        return "Livro " + id +":" +
                " titulo: " + titulo +
                " | autor: " + autor +
                " | isbn: " + isbn;
    }
}
