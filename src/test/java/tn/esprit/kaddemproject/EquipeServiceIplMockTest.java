package tn.esprit.kaddemproject;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.kaddemproject.entities.DetailEquipe;
import tn.esprit.kaddemproject.entities.Equipe;
import tn.esprit.kaddemproject.entities.Etudiant;
import tn.esprit.kaddemproject.entities.Niveau;
import tn.esprit.kaddemproject.repositories.EquipeRepository;
import tn.esprit.kaddemproject.services.IEquipeServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class EquipeServiceIplMockTest {

    @Mock
    EquipeRepository equipeRepository;

    @InjectMocks
    IEquipeServiceImpl service;

    @Test
    public void testgEquipeById(){
        DetailEquipe d = new DetailEquipe();
        List<Etudiant> l =new ArrayList<>();
        Equipe equipe = new Equipe(1,"1",Niveau.EXPERT,l,d);

        Mockito.when(equipeRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(equipe));
        Assert.assertNotNull(service.retrieveEquipe(1));
    }
}
