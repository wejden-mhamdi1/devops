package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

@ExtendWith(MockitoExtension.class)
public class FournisseurServiceImplUTest {

	@InjectMocks
	FournisseurServiceImpl fournisseurServiceImpl;
	
	@Mock
	FournisseurRepository fournisseurRepository;
	@Mock
	DetailFournisseurRepository detailFournisseurRepository;
	@Mock
	ProduitRepository produitRepository;
	@Mock
	SecteurActiviteRepository secteurActiviteRepository;
	
	
	@Test
	void test_retrieveAllFournisseurs_ok() {
		
		when(fournisseurRepository.findAll()).thenReturn(new ArrayList());
		List<Fournisseur> response= fournisseurServiceImpl.retrieveAllFournisseurs();
		assertEquals(0, response.size());
	}
	void test_addFournisseur_ok() {
		DetailFournisseur df= new DetailFournisseur();
		df.setIdDetailFournisseur(1L);
		//mock
		when(fournisseurRepository.save(any())).thenReturn(df);	
		//call function 
		fournisseurServiceImpl.addFournisseur(new Fournisseur());
		//assert
		assertEquals(1L,df.getIdDetailFournisseur());
		}

	
}
