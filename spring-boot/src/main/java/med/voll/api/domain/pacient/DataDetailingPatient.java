package med.voll.api.domain.pacient;

import med.voll.api.domain.address.Address;

public record DataDetailingPatient(Long id, String name, String email, String nationalNumber, String phone, Address address) {

    public DataDetailingPatient(Pacient pacient) {
        this(pacient.getId(), pacient.getName(), pacient.getEmail(), pacient.getNationalNumber(), pacient.getPhone(), pacient.getAddress());
    }
}
