package model;

public class Venda {
    private int id;
    private Camisa camisa;
    private Cliente cliente;


    

    public Venda(int id, Camisa camisa, Cliente cliente) {
        this.id = id;
        this.camisa = camisa;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public Camisa getCamisa() {
        return camisa;
    }

    public Cliente getCliente() {
        return cliente;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setCamisa(Camisa camisa) {
        this.camisa = camisa;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Venda [ camisa=" + camisa + ", cliente=" + cliente + "]";
    }


  
    

    
    
}
