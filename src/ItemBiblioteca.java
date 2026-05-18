public abstract class ItemBiblioteca {
    //Criação de atributos 'Protected' onde somente a própria classe ou as classes filhas terão acesso.
    protected int id;
    protected String titulo;
    private boolean disponivel = true;

    //Construtor padrão que servirá de base para as classes filhas 'Livro' e 'Revista'.
    public ItemBiblioteca(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }
    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    //Método abstrato para exibir detalhes de um livro ou revista.
    public abstract void exibirDetalhes();


}
