package fr.atos.msbanque.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "mobile" , types = Compte.class)
public interface CompteProjectionMobile {

    double getSolde();
    TypeCompte getType();
}
