package com.egemsoft.application.service;

import com.egemsoft.application.rickandmortyapi.service.CharacterService;
import com.egemsoft.application.rickandmortyapi.service.impl.CharacterServiceImpl;
import com.egemsoft.application.rickandmortyapi.helper.ReportingHelper;
import com.egemsoft.application.rickandmortyapi.model.Character;
import com.egemsoft.application.rickandmortyapi.repository.CharacterRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class CharacterServiceTest {

    private CharacterService characterService;

    @Mock
    private CharacterRepository characterRepository;
    @Mock
    private ReportingHelper reportingHelper;

    @Before
    public void init() {

        characterService = new CharacterServiceImpl(characterRepository, reportingHelper, null);
    }

    @Test
    public void getCharacterById() {

        // given
        Character character = Character
                .builder()
                .name("Rick")
                .status("Alive")
                .species("Human")
                .url("https://rickandmortyapi.com/api/character/1")
                .build();
        character.setId(1L);

        when(characterRepository.getCharacters()).thenReturn(Collections.singletonList(character));

        // when
        Character foundCharacter = characterService.findById(1L);

        // then
        assertNotNull(foundCharacter);
        assertEquals(character, foundCharacter);
    }
}
