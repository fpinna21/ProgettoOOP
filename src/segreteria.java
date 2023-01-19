public class segreteria {
    public String nome;
    public String password;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public segreteria(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }
}
