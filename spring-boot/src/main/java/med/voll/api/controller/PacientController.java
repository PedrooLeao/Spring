package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.pacient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
public class PacientController {

    @Autowired
    private PacientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DataRegistrationPatient data, UriComponentsBuilder uriBuilder) {
        var pacient = new Pacient(data);
        repository.save(pacient);

        var uri = uriBuilder.path("/pacient/{id}").buildAndExpand(pacient.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataDetailingPatient(pacient));
    }

    @GetMapping
    public ResponseEntity<Page<DataListPatient>> listing(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        var page = repository.findAllByAtivoTrue(pageable).map(DataListPatient::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DataUpdatePatient data) {
        var pacient = repository.getReferenceById(data.id());
        pacient.updateInformations(data);

        return ResponseEntity.ok(new DataDetailingPatient(pacient));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var pacient = repository.getReferenceById(id);
        pacient.delete();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detailing(@PathVariable Long id) {
        var pacient = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailingPatient(pacient));
    }


}
