package dev.erik.mastersys.repository;

import dev.erik.mastersys.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository <Aluno, Long>{

    boolean existsByEmail(String email);
}
