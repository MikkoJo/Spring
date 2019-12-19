package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import com.example.demo.controller.*;
import com.example.demo.repository.LangRepository;



//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class Harj10bUnitTest { 
	@Mock
	private LangRepository repoMock;

	@Mock 
	private Lang lang;

	@InjectMocks
	private LangService langService;

    // Alustetaan datat
	private List<Lang> langs = Arrays.asList( 
		new Lang("Suomi", "fi"),
		new Lang("Ruotsi", "se"), 
		new Lang("Norja", "no"),
		new Lang("Islanti", "is"),
		new Lang("Tanska", "de")
	);

	@Test
	public void testFindAllLangs() {
		// Asetus 
		when(repoMock.findAll()).thenReturn(langs);
        // Toiminto
        List<Lang> retLangs = langService.getLangs();
        // Vertaaminen
        assertThat(retLangs, is(equalTo(langs)));
	}



	@Test
	public void testFindLangFi() {
		Lang langFi = new Lang("Suomi", "fi");
		// Asetus 
		when(repoMock.findById("fi")).thenReturn(Optional.of(langFi));
        // Toiminto
        Lang retLang = langService.getLang("fi");
        // Vertaaminen
        assertThat(retLang, is(equalTo(langFi)));
	}


    // Tallennustesti - ei palauta lainkaan arvoa
	@Test
	public void testSaveLangFi() {

		Lang langFi = new Lang("Suomi", "fi");
		// Asetus - palauttaa tallennetun alkion
		when(repoMock.save(any(Lang.class))).thenReturn(langFi);

		//doNothing().when(repoMock).save(langFi);
        // Toiminto
        langService.addLang(langFi);
        // Vertaaminen - tätä ei tarvita 
        // Ei tarvita, kun mitään ei palauteta
	}


    // Poistamisen vertaaminen - ei palauta poistettua alkiota
	@Test
	public void testRemoveLangFi() {
		Lang langFi = new Lang("Suomi", "fi");
		// Asetus 
		when(repoMock.findById("fi")).thenReturn(Optional.of(langFi));
		doNothing().when(repoMock).deleteById("fi");
        // Toiminto
        langService.removeLang("fi");
        // Vertaaminen
        // Ei tarvita, kun mitään ei palauteta
	}

    // Päivittämisen vertaaminen - ei palauta poistettua alkiota
	@Test
	public void testUpdateLangFi() {
		Lang langFi = new Lang("Suomi", "fi");
		// Asetus 
		when(repoMock.save(any(Lang.class))).thenReturn(langFi);
        // Toiminto
        langService.updateLang("fi", langFi);
        // Vertaaminen
        // Ei tarvita, kun mitään ei palauteta
	}



}