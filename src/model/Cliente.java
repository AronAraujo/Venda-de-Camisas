package model;
public class Cliente {
    private String Cpf;
    private String Nome;
    private String telefone;

    public Cliente(String cpf, String nome, String telefone) {
        this.Cpf = cpf;
        this.Nome = nome;
        this.telefone = telefone;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        this.Cpf = cpf;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    @Override
    public String toString() {
    return "CPF: " + Cpf + ", Nome: " + Nome + ", Telefone: " + telefone;
    }

}
