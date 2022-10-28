package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.rh.achat.dto.SecteurDTO;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;
@ExtendWith(MockitoExtension.class)
class SectrueTest {
	@InjectMocks SecteurActiviteServiceImpl s;
	@Mock SecteurActiviteRepository r;
	//logging
	SecteurActivite secteur = new SecteurActivite(null,"libelle","code");
	List<SecteurActivite> list = new ArrayList<SecteurActivite>() {
		
		{
			add(new SecteurActivite(null,"libelle1","code1"));
			add(new SecteurActivite(null,"libelle2","code2"));
			
		}
	};
	
	
	
	@Test
	void all() {
		
		when(r.findAll()).thenReturn(new ArrayList());
		List<SecteurDTO> response= s.retrieveAllSecteurActivite2();
		assertEquals(0, response.size());
	}
	void add() {
		SecteurActivite se= new SecteurActivite();
		se.setIdSecteurActivite(null);
		//mock
		when(r.save(any())).thenReturn(s);	
		//call function 
		s.addANDupdate2(new SecteurDTO());
		//assert
		assertEquals(1L,se.getIdSecteurActivite());
		}
	
	
	public void selectOne(){
	Mockito.when(r.findById(Mockito.anyLong())).thenReturn(Optional.of(secteur));
	SecteurDTO sec = s.retrieveSecteurActivite2((long) 2 );
	Assertions.assertNotNull(sec);
	}
	public void delete() {
 	
		SecteurActivite e = r.findById(1L).get();	
		 r.delete(e);
		 s.deleteSecteurActivite(null);
		
	}
	public void modifier(){
		SecteurDTO se= new SecteurDTO();
		se.setIdSecteurActivite(null);;
		//mock
		when(r.save(any())).thenReturn(s);	
		//call function 
		s.addANDupdate2(new SecteurDTO());
		//assert
		assertEquals(1L,se.getIdSecteurActivite());
}

}
