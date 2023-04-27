package med.voll.api.domain.pacient;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.DataAddress;

public record DataUpdatePatient(
        @NotNull
        Long id,
        String name,
        String phone,
        DataAddress address) {
}
