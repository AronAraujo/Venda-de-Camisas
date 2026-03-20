package controller;
import model.Camisa;
import model.Cliente;
import model.Venda;
import java.util.ArrayList;



public class Loja {
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Camisa> listaCamisas;
    private ArrayList<Venda> listaVendas;

    public Loja() {
        listaClientes = new ArrayList<>();
        listaCamisas = new ArrayList<>();
        listaVendas = new ArrayList<>();
    }

    //camisas
    public void adicionarCamisa(Camisa camisa) {
        listaCamisas.add(camisa);
    }

    public ArrayList<Camisa> listarCamisas() {
        return listaCamisas;
    }

    public boolean removerCamisa(Camisa camisa) {
        return listaCamisas.remove(camisa);
    }
    public Camisa buscarCamisa(int codigo) {
        for (Camisa camisa : listaCamisas) {
            if (camisa.getCodigo() == codigo) {
                return camisa;
            }
        }
        return null;
    }

    //  clientes
    public void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public ArrayList<Cliente> listarClientes() {
        return listaClientes;
    }

    public boolean removerCliente(Cliente cliente) {
        return listaClientes.remove(cliente);
    }
    public Cliente encontrarCliente(String cpf) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
    // vendas
    public void registrarVenda(int cod, Camisa camisa, Cliente cliente) {
        listaVendas.add(new Venda(cod, camisa, cliente));
    }

    public ArrayList<Venda> listarVendas() {
        return listaVendas;
    }

    public boolean removerVenda(Venda venda) {
        return listaVendas.remove(venda);
    }

    public Venda buscarVendaPorCPFECodigo(String cpf, int codigoCamisa) {
        for (Venda venda : listaVendas) {
            if (venda.getCliente().getCpf().equals(cpf)) {
                if (venda.getCamisa().getCodigo() == codigoCamisa) {
                    return venda;
                }
            }
        }
        return null;
    }
    
    
    //Relatório
    public Camisa getCamisaMaisCara() {
        if (listaCamisas.isEmpty()) {
            return null;
        }
        Camisa camisaMaisCara = listaCamisas.get(0);
        for (Camisa camisa : listaCamisas) {
            if (camisa.getPreco() > camisaMaisCara.getPreco()) {
                camisaMaisCara = camisa;
            }
        }
        return camisaMaisCara;
    }

    public Camisa getCamisaMaisBarata() {
        if (listaCamisas.isEmpty()) {
            return null;
        }
        Camisa camisaMaisBarata = listaCamisas.get(0);
        for (Camisa camisa : listaCamisas) {
            if (camisa.getPreco() < camisaMaisBarata.getPreco()) {
                camisaMaisBarata = camisa;
            }
        }
        return camisaMaisBarata;
    }
    
    
    public Cliente clienteQueMaisComprou() {
        if (listaVendas.isEmpty()) {
            return null;
        }

        Cliente clienteMaisComprou = null;
        double valorMaisAlto = 0.0;

  
        for (Venda venda : listaVendas) {
            Cliente cliente = venda.getCliente();
            double valorCompra = venda.getCamisa().getPreco(); 

            
            if (valorCompra > valorMaisAlto) {
                clienteMaisComprou = cliente;
                valorMaisAlto = valorCompra;
            }
        }

        return clienteMaisComprou;
    }
    
}
