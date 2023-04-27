package med.voll.api.domain.doctor;

public record DataListingDataDoctor(Long id, String name, String email, String doctorNumber, Specialty specialty) {

    public DataListingDataDoctor(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getDoctorNumber(), doctor.getSpecialty());
    }

}
