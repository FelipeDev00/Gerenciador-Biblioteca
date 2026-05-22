public class Revista extends ItemBiblioteca {
    private int edicao;
    private String disponivel;

    //Construtor com parâmetros pré-definidos para inicialização do objeto 'Revista'.
    public Revista(int id, String titulo, int edicao) {
        super(id, titulo); //Chamada do SUPER() para referenciar atributos já definidos no construtor da classe mãe.

        this.edicao = edicao; //Atributo próprio que só o objeto 'Revista' tem.
    }

    //Aplicação do método abstrato obrigatório da classe mãe e dizendo como ele será usado pela classe filha 'Revista'. (Polimorfismo)
    @Override
    public void exibirDetalhes() {
        if (isDisponivel() == true){
            disponivel = "Disponível";
        } else {
            disponivel = "Não disponível";
        }
        System.out.println("Revista - ID: " + id + " | Título: " + titulo + " | Edição: " + edicao + " | " + disponivel);
    }

    @Override
    public String toString() {
        return "Revista " + id + " - " +
                "titulo: " + titulo +
                " | Edição: " + edicao;
    }
}