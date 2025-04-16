package com.jcruz.reslerianadb.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TagResponse(
        @JsonProperty("id") Integer id,
        @JsonProperty("name") String name) {

    public static final class Builder {
        Integer id;
        String name;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public TagResponse build() {
            return new TagResponse(
                    id,
                    name);
        }
    }
}
