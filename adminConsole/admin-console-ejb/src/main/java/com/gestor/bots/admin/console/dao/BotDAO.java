/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.dao;

import com.gestor.bots.admin.console.model.Bot;
import com.persist.common.dao.DefaultGenericDAOImple;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Gestor
 */
@LocalBean
@Stateless
public class BotDAO extends DefaultGenericDAOImple<Bot, String> {

    private EntityManager em;

    public BotDAO() {
        super(Bot.class);
    }

    public List<Bot> findByRazon(String razon) {
        Query qry = this.em.createQuery("SELECT objB, objC FROM Bot objB, Cliente objC  WHERE objB.ruc = objC.ruc AND objC.razonSocial = ?1");
        qry.setParameter(1, razon); 
        return qry.getResultList();
    }
}
