package com.example.dto;

import com.example.entities.Dummy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DummyDTO {

    @NotEmpty(message = "name field can't be empty")
    private String id;


    public static Set<DummyDTO> fromEntity(Set<Dummy> users) {
        return users
                .stream()
                .map(DummyDTO::fromEntity)
                .collect(toSet());
    }

    public static DummyDTO fromEntity(Dummy dummy) {
        return builder()
                .id(dummy.getId())
                .build();
    }

    public Dummy toEntity() {
        return Dummy.builder()
                .id(id)
                .build();
    }
}

