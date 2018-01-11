/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.web;

import com.gestor.bots.admin.console.model.Bot;
import com.gestor.bots.admin.console.model.Cliente;
import com.gestor.bots.admin.console.servicio.BotService;
import com.gestor.bots.admin.console.servicio.ClienteService;
import com.gestor.bots.admin.console.web.common.BaseBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author joel
 */
@Named
@ViewScoped
public class GestionBotsBean extends BaseBean implements Serializable {

    private String filtro;
    private String clienteBusqueda;
    private boolean enBusquedaPorCliente;
    private List<Cliente> clientes;
    private String razonSocial;
    private Cliente cliente;
    private List<Bot> bots;
    private Bot bot;
    private Bot botSel;

    @Inject
    private ClienteService clienteService;
    
    @Inject
    private BotService botService;

    @PostConstruct
    public void init() {
        this.filtro = "CLI";
        this.enBusquedaPorCliente = true;
        this.clientes = this.clienteService.obtenerTodos();
    }

    public void buscar() {
        this.bots = this.botService.buscarPorRazon(this.razonSocial);
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public String getClienteBusqueda() {
        return clienteBusqueda;
    }

    public void setClienteBusqueda(String clienteBusqueda) {
        this.clienteBusqueda = clienteBusqueda;
    }

    public boolean isEnBusquedaPorCliente() {
        return enBusquedaPorCliente;
    }

    public void setEnBusquedaPorCliente(boolean enBusquedaPorCliente) {
        this.enBusquedaPorCliente = enBusquedaPorCliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Bot> getBots() {
        return bots;
    }

    public void setBots(List<Bot> bots) {
        this.bots = bots;
    }

    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public Bot getBotSel() {
        return botSel;
    }

    public void setBotSel(Bot botSel) {
        this.botSel = botSel;
    }

}
