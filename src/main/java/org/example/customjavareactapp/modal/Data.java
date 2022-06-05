package org.example.customjavareactapp.modal;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Data {

    @Id
    private UUID id;
    private Long requestCameTime;
    private String data;

}