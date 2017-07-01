package com.github.shmvanhouten.musicstore.Track;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static com.github.shmvanhouten.musicstore.Track.Track.TrackBuilder.aTrack;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(TrackResource.class)
public class TrackResourceTest {

    @Autowired
    private MockMvc mockMvc;

    private Track track;

    @MockBean
    private TrackService trackService;


    @Before
    public void setup() throws Exception{
        track = aTrack()
                .withTrackId(232)
                .withAlbumTitle("Foo")
                .withArtistName("Bar")
                .withMediaTypeId(1L)
                .withMilliseconds(30000)
                .withName("FooBarSpecial")
                .withPrice(BigDecimal.valueOf(2.23))
                .build();

    }

    @Test
    public void itShouldTest() throws Exception {
        when(trackService.getById(anyLong())).thenReturn(track);
        mockMvc.perform(get("/track/byId/232").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
               .andExpect(jsonPath("$.name",is("FooBarSpecial")));
    }
}