package fr.atos.msbanque.web;

import fr.atos.msbanque.entities.Compte;
import fr.atos.msbanque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//@RestController
@RequestMapping("/banque")
public class CompteRestControllerAPI {

    @Autowired
    private CompteRepository compteRepository;

    @GetMapping(path = "/comptes" , produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Compte> compteList(){
        return compteRepository.findAll();
    }

    @GetMapping("/comptes/{id}" )
    public Optional<Compte> getOne(@PathVariable(value = "id") Long id){
        return compteRepository.findById(id);
    }

    @PostMapping(path ="/comptes")
    public Compte save(@RequestBody Compte compte){
        return compteRepository.save(compte);
    }

    @PutMapping("/comptes/{id}")
    public Compte update(@RequestBody Compte compte, @PathVariable("id") Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @DeleteMapping("/comptes/{id}")
    public void delete( @PathVariable("id") Long id){
        compteRepository.deleteById(id);
    }

}
