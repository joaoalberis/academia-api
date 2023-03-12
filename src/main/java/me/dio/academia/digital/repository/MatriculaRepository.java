package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    /**
     *
     * @param bairro bairro referencia para o filtro
     * @return lista de alunos matriculados que residem no bairro passado como parametro
     */

    /*@Query(value = "SELECT * FROM tb_matriculas m " +
            "INNER JOIN tb_alunos a ON m.aluno_id = a.id " +
            "WHERE a.bairro = :bairro", nativeQuery = true)*/
    @Query("FROM Matricula m WHERE m.aluno.bairro = :bairro ")
    List<Matricula> findAlunosMatriculadosBairro(String bairro);

    //List<Matricula> findByAlunoBairro(String bairro);
    Matricula findByAluno(Aluno aluno);

    boolean existsByAluno(Aluno aluno);

    List<Matricula> findByDataDaMatriculaLessThanEqual(LocalDateTime dataDaMatricula);
}
