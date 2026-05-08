package dev.erik.mastersys.repository;

import dev.erik.mastersys.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AlunoRepository extends JpaRepository <Aluno, Long>, JpaSpecificationExecutor<Aluno> {

    boolean existsByEmail(String email);
}
