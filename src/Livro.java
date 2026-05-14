public class Livro extends ItemBiblioteca{
    private Autor autor;
    private String isbn;

    //Construtor com parâmetros pré-definidos para inicialização do objeto 'Livro'
    public Livro(int id, String titulo, Autor autor, String isbn) {
        super(id, titulo); //Chama os atributos já definidos no construtor da classe mãe.

        //Atributos próprios que só o objeto 'Livro' tem.
        this.autor = autor;
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    //Aplicação do método abstrato obrigatório da classe mãe e dizendo como ele será usado pela classe filha 'Livro'. (Polimorfismo)
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
