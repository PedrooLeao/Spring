package med.voll.api.domain.pacient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.Address;

@Table(name = "pacient")
@Entity(name = "Pacient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pacient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    private String phone;

    private String nationalNumber;

    @Embedded
    private Address address;

    private Boolean active;

    public Pacient(DataRegistrationPatient data) {
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.nationalNumber = data.nationalNumber();
        this.address = new Address(data.address());
    }

    public void updateInformations(DataUpdatePatient data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.phone() != null) {
            this.phone = data.phone();
        }
        if (data.address() != null) {
            this.address.updateInformations(data.address());
        }

    }

    public void delete() {
        this.active = false;
    }
}
