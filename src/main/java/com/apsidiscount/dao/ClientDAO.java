package com.apsidiscount.dao;

import java.util.List;

import com.apsidiscount.entity.Client;
import com.apsidiscount.exceptions.LoginAndPasswordException;


public interface ClientDAO {

    void create(Client c);

    Client getById(long id);

    List<Client> getAll();

    List<Client> getAllByNom(String nom);

    List<Client> getAllByAnneDeNaissance(int annee);

    void delete(long id);

    long getNbClientByCodePostal(String codePostal);

    Client getByIdWithPanier(long id);
    
    Client getClientByNameAndPassword(String email, String password) throws LoginAndPasswordException;

}