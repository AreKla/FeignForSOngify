package com.feignforsongify;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongDeserializationTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testSongDeserialization() throws Exception {
        String json = "{\"name\":\"song2\",\"artist\":\"Pezet\"}";
        Song song = objectMapper.readValue(json, Song.class);
        assertEquals("song2", song.name());
        assertEquals("Pezet", song.artist());
    }
}
