package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {
    boolean existsByAluno(Aluno aluno);

    List<AvaliacaoFisica> findByAluno(Aluno aluno);

    List<AvaliacaoFisica> findByPeso(double peso);

    List<AvaliacaoFisica> findByAltura(double altura);
}