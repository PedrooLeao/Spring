package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.doctor.DataListingDataDoctor;
import med.voll.api.domain.doctor.Doctor;
import med.voll.api.domain.doctor.DoctorRepository;
import med.voll.api.domain.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DataRegistrationDoctor dados, UriComponentsBuilder uriBuilder) {
        var medico = new Doctor(dados);
        repository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailingDoctor(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DataListingDataDoctor>> listar(@PageableDefault(size = 10, sort = {"name"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DataListingDataDoctor::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DataUpdateDoctor data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.updateInformations(data);

        return ResponseEntity.ok(new DataDetailingDoctor(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.delete();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailingDoctor(doctor));
    }


}
