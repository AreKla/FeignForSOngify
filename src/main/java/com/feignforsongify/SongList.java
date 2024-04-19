package com.feignforsongify;

import java.util.Map;

public record SongList(Map<Integer, Song> song) {
}
