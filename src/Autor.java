public class Autor {
    private String nome;
    private String nacionalidade;

    public Autor(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Autor: " + nome +
                " | Nacionalidade: " + nacionalidade;
    }
}
