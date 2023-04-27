package med.voll.api.domain.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String district;
    private String zipcode;
    private String number;
    private String complement;
    private String city;
    private String state;

    public Address(DataAddress data) {
        this.street = data.street();
        this.district = data.district();
        this.zipcode = data.zipcode();
        this.state = data.state();
        this.city = data.city();
        this.number = data.number();
        this.complement = data.complement();
    }

    public void updateInformations(DataAddress data) {
        if (data.street() != null) {
            this.street = data.street();
        }
        if (data.district() != null) {
            this.district = data.district();
        }
        if (data.zipcode() != null) {
            this.zipcode = data.zipcode();
        }
        if (data.state() != null) {
            this.state = data.state();
        }
        if (data.city() != null) {
            this.city = data.city();
        }
        if (data.number() != null) {
            this.number = data.number();
        }
        if (data.complement() != null) {
            this.complement = data.complement();
        }
    }
}
