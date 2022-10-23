package com.esprit.examen.services;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CategorieProduitServiceImplTest {

    @Mock
    CategorieProduitRepository cpr;

    private CategorieProduit cat1 = new CategorieProduit(9L, "c3", "lait", null);
    private CategorieProduit cat2 = new CategorieProduit(8L, "c4", "lait", null);
    List<CategorieProduit> listCategorieProduit = new ArrayList<CategorieProduit>() {
        {

            add(new CategorieProduit(10L, "c5", "lait", null));
            add(new CategorieProduit(60L, "4503","produit3",null));
        }
    };
    @InjectMocks
    CategorieProduitServiceImpl cps;

    @Test
    public void retrieveAllCategorieProduits() {
        when(cpr.findAll()).thenReturn(listCategorieProduit);
        assertEquals(2,cps.retrieveAllCategorieProduits().size());
        System.out.println("Retrieve operators works !");
    }

    @Test
    public void addCategorieProduit() {
        when(cpr.save(cat1)).thenReturn(cat1);
        assertNotNull(cat1);
        assertEquals(cat1, cps.addCategorieProduit(cat1));
        System.out.println("add works !");
    }

    @Test
    public void deleteCategorieProduit() {
        cpr.save(cat1);
        cps.deleteCategorieProduit(cat1.getIdCategorieProduit());

        verify(cpr, times(1)).deleteById(cat1.getIdCategorieProduit());
        System.out.println("Delete works !");
    }

    @Test
    public void updateCategorieProduit() {
        when(cpr.save(cat1)).thenReturn(cat1);
        assertNotNull(cat1);
        assertEquals(cat1, cps.updateCategorieProduit(cat1));
        System.out.println("Update works !");
    }

    @Test
    public void retrieveCategorieProduit() {
        CategorieProduit cp = new CategorieProduit(6L, "123456", "fraise", null);

        cp.setIdCategorieProduit(6L);

        when(cpr.findById(Mockito.anyLong())).thenReturn(Optional.of(cp));
        CategorieProduit cp1 = cps.retrieveCategorieProduit(6L);
        assertNotNull(cp1);

        System.out.println(cp);
        System.out.println(" Retrieve is working correctly...!!");
    }
}