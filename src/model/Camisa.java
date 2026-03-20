package model;
public class Camisa {
    private int codigo;
    private String tamanho;
    private String cor;
    private double preco;

    public Camisa(int codigo, String tamanho, String cor, double preco) {
        this.codigo = codigo;
        this.tamanho = tamanho;
        this.cor = cor;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Tamanho: " + tamanho + ", Cor: " + cor + ", Preço: " + preco;
    }
}
