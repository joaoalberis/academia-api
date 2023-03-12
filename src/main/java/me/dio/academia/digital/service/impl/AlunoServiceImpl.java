package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        return alunoRepository.findById(id).get();
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento, String nome) {
        if(dataDeNascimento != null){
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return alunoRepository.findByDataDeNascimento(localDate);
        } else if (nome != null) {
            return alunoRepository.findByNome(nome);
        } else {
            return alunoRepository.findAll();
        }
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        Aluno aluno = alunoRepository.findById(id).get();
        aluno.setNome(formUpdate.getNome());
        aluno.setBairro(formUpdate.getBairro());
        aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());
        return alunoRepository.save(aluno);
    }

    @Override
    public void delete(Long id) {
        Aluno aluno = alunoRepository.findById(id).get();
        if (!matriculaRepository.existsByAluno(aluno)){
            if(!avaliacaoFisicaRepository.existsByAluno(aluno)){
                alunoRepository.delete(aluno);
            }else{
                List<AvaliacaoFisica> avaliacaoFisica = avaliacaoFisicaRepository.findByAluno(aluno);
                avaliacaoFisicaRepository.deleteAll(avaliacaoFisica);
                alunoRepository.delete(aluno);
            }
        }else{
            Matricula matricula = matriculaRepository.findByAluno(aluno);
            if(!avaliacaoFisicaRepository.existsByAluno(aluno)){
                matriculaRepository.delete(matricula);
            }else{
                List<AvaliacaoFisica> avaliacaoFisica = avaliacaoFisicaRepository.findByAluno(aluno);
                avaliacaoFisicaRepository.deleteAll(avaliacaoFisica);
                matriculaRepository.delete(matricula);
            }
        }
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
        Aluno aluno = alunoRepository.findById(id).get();
        return aluno.getAvaliacoes();
    }

    @Override
    public List<Aluno> getAlunosByNome(String nome) {
        return alunoRepository.findByNome(nome);
    }
}
