package com.example.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.StringUtils;

@Builder
@Data
@EqualsAndHashCode(of = "id")
public class Dummy {

    private String id;

    public boolean hasId() {
        return !hasNotId();
    }

    public boolean hasNotId() {
        return StringUtils.isEmpty(id);
    }
}
