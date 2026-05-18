public class Usuario {
    private String nome;
    private String cpf;
    private int id;

    public Usuario(String nome, String cpf, int id) {
        this.nome = nome;
        this.cpf = cpf;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getId() {
        return id;
    }
}
