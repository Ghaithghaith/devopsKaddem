package tn.esprit.kaddemproject;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.kaddemproject.entities.DetailEquipe;
import tn.esprit.kaddemproject.entities.Equipe;
import tn.esprit.kaddemproject.entities.Etudiant;
import tn.esprit.kaddemproject.entities.Niveau;
import tn.esprit.kaddemproject.services.IEquipeService;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class EquipeServiceImplTest {

    @Autowired
    IEquipeService service;

    @Test
    public void testAddEquipe(){
        DetailEquipe d = new DetailEquipe();
        List<Etudiant> l =new ArrayList<>();
        Equipe equipe = new Equipe(2,"1", Niveau.EXPERT,l,d);

       Equipe savedEquipe = service.addEquipe(equipe);
        Assert.assertNotNull(savedEquipe.getIdEquipe());
        service.deleteEquipe(savedEquipe.getIdEquipe());

    }

    @Test
    public void testDeleteEquipe(){
        DetailEquipe d = new DetailEquipe();
        List<Etudiant> l =new ArrayList<>();
        Equipe equipe = new Equipe(3,"1", Niveau.EXPERT,l,d);
        Equipe savedEquipe = service.addEquipe(equipe);
        service.deleteEquipe(savedEquipe.getIdEquipe());
        Assert.assertNull(savedEquipe.getIdEquipe());


    }

}
