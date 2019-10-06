package com.algaworks.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Cliente cliente = new Cliente();
	private List<Cliente> todosClientes = new ArrayList<>();

	public ClienteController() {
		this.todosClientes.add(new Cliente("João da Silva", "joao@dasilva.com"));
		this.todosClientes.add(new Cliente("Maria Abadia", "maria@abadia.com.br"));
	}
	
	public void adicionar() {
		this.todosClientes.add(cliente);
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public List<Cliente> getTodosClientes() {
		return todosClientes;
	}

}