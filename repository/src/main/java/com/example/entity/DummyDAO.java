package com.example.entity;

import com.example.entities.Dummy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


import static java.lang.Long.valueOf;
import static org.springframework.util.StringUtils.isEmpty;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DummyDAO {
    private Long id;

    public Dummy toEntity() {
        return Dummy.builder()
                .id(id.toString())
                .build();
    }

    public static DummyDAO fromEntity(Dummy dummy) {
        return builder()
                .id(isEmpty(dummy.getId()) ? null : valueOf(dummy.getId()))
                .build();
    }
}

