package med.voll.api.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataAddress(
        @NotBlank
        String street,
        @NotBlank
        String district,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String zipcode,
        @NotBlank
        String city,
        @NotBlank
        String state,
        String complement,
        String number) {
}
