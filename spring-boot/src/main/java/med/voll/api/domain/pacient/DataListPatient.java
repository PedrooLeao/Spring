package med.voll.api.domain.pacient;

    public record DataListPatient(Long id, String name, String email, String nationalNumber) {

    public DataListPatient(Pacient pacient) {
        this(pacient.getId(), pacient.getName(), pacient.getEmail(), pacient.getNationalNumber());
    }

}
