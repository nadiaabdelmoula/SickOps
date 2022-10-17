package com.esprit.examen.services;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CategorieProduitServiceImplTest {

    @Mock
    CategorieProduitRepository cpr;

    @InjectMocks
    CategorieProduitServiceImpl cps;


    private CategorieProduit category = new CategorieProduit(5L, "c1", "chocolat", null);

//    @Test
//    void retrieveAllCategorieProduits() {
//        List<CategorieProduit> Categorylist = new ArrayList<CategorieProduit>() {
//
//            {
//                add(new CategorieProduit(1L, "123", "lait", null));
//                add(new CategorieProduit(2L, "1234", "beurre", null));
//                add(new CategorieProduit(3L, "123456", "chocolat", null));
//            }};
//
//
//        when(cps.retrieveAllCategorieProduits()).thenReturn(Categorylist);
//        //test
//        List<CategorieProduit> catList = cps.retrieveAllCategorieProduits();
//        assertEquals(3, catList.size());
//        System.out.println(" Retrieve all is working correctly...!!");
//    }

//    @Test
//    void addCategorieProduit() {
//        CategorieProduit cat2 = new CategorieProduit(4L, "123456", "chocolat", null);
//        cat2.setIdCategorieProduit(4L);
//
//        cps.addCategorieProduit(cat2);
//        verify(cpr, times(1)).save(cat2);
//        System.out.println(cat2);
//        System.out.println(" Create is working correctly...!!");
//    }

//    @Test
//    void deleteCategorieProduit() {
//        cpr.save(category);
//        cps.deleteCategorieProduit(category.getIdCategorieProduit());
//
//        verify(cpr, times(1)).deleteById(category.getIdCategorieProduit());
//        System.out.println("Delete works !");
//    }

//    @Test
//    void updateCategorieProduit() {
//        when(cpr.save(category)).thenReturn(category);
//        assertNotNull(category);
//        assertEquals(category, cps.updateCategorieProduit(category));
//        System.out.println("Update works !");
//    }

    @Test
    void retrieveCategorieProduit() {
        CategorieProduit cp = new CategorieProduit(6L, "123456", "fraise", null);

        cp.setIdCategorieProduit(6L);

        Mockito.when(cpr.findById(Mockito.anyLong())).thenReturn(Optional.of(cp));
        CategorieProduit cp1 = cps.retrieveCategorieProduit(6L);
        assertNotNull(cp1);

        System.out.println(cp);
        System.out.println(" Retrieve is working correctly...!!");
    }
}
