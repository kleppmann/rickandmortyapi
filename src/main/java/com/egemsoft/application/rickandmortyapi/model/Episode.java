package com.egemsoft.application.rickandmortyapi.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Builder
@EqualsAndHashCode(callSuper = true)
@Data
public class Episode extends Base {

    private String name;
    private String air_date;
    private String episode;
    private List<String> characters;
    private String url;
    private String created;
}
