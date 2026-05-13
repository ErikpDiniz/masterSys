package dev.erik.mastersys.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface FaturasEmAbertoProjection {

    Long getMatriculaId();
    String getAlunoNome();
    LocalDate getDataNascimento();
    BigDecimal getValor();
}