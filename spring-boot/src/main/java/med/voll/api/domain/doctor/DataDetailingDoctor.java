package med.voll.api.domain.doctor;

import med.voll.api.domain.address.Address;

public record DataDetailingDoctor(Long id, String name, String email, String doctorNumber, String phone, Specialty specialty, Address address) {

    public DataDetailingDoctor(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getDoctorNumber(), doctor.getPhone(), doctor.getSpecialty(), doctor.getAddress());
    }
}
