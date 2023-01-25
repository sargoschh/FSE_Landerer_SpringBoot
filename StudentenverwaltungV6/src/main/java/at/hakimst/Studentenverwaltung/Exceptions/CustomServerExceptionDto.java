package at.hakimst.Studentenverwaltung.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomServerExceptionDto {
    private String code;
    private String message;
}
