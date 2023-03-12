package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form){
        return service.create(form);
    }

    @GetMapping
    public List<AvaliacaoFisica> getAll(@RequestParam(value = "peso", required = false) Double peso,
                                        @RequestParam(value = "altura", required = false) Double altura){

        return service.getAll(peso, altura);
    }

    @GetMapping("/{id}")
    public AvaliacaoFisica getId(@PathVariable Long id){
        return service.get(id);
    }

    @PutMapping("/{id}")
    public AvaliacaoFisica update(@PathVariable Long id, @Valid @RequestBody AvaliacaoFisicaUpdateForm form){
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
