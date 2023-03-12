package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        matricula.setAluno(aluno);

        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return matriculaRepository.findById(id).get();
    }

    @Override
    public List<Matricula> getAll(String bairro, String dataDeMatricula) {
        if (bairro != null){
            return matriculaRepository.findAlunosMatriculadosBairro(bairro);
        } else if (dataDeMatricula != null) {
            LocalDateTime localDate = LocalDateTime.parse(dataDeMatricula, JavaTimeUtils.LOCAL_DATE_TIME_FORMATTER);
            return matriculaRepository.findByDataDaMatriculaLessThanEqual(localDate);
        } else{
            return matriculaRepository.findAll();
        }
    }

    @Override
    public void delete(Long id) {
        matriculaRepository.deleteById(id);
    }
}
