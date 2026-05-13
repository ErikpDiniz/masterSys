package dev.erik.mastersys.controller;


import dev.erik.mastersys.projection.AlunosPorCidadeProjection;
import dev.erik.mastersys.projection.FaturamentoMensalProjection;
import dev.erik.mastersys.projection.FaturasEmAbertoProjection;
import dev.erik.mastersys.repository.RelatorioAcademiaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioAcademiaController {

    private final RelatorioAcademiaRepository relatorioAcademiaRepository;

    public RelatorioAcademiaController(RelatorioAcademiaRepository repository){
        this.relatorioAcademiaRepository = repository;
    }

    @GetMapping("/faturamento-mensal")
    public List<FaturamentoMensalProjection> faturamentoMensal(){
        return  relatorioAcademiaRepository.faturamentoMensal();
    }

    @GetMapping("/alunos-por-cidade")
    public List<AlunosPorCidadeProjection> alunosPorCidade(){
        return  relatorioAcademiaRepository.alunosPorCidade();
    }

    @GetMapping("/faturas-em-aberto")
    public List<FaturasEmAbertoProjection> faturasEmAberto(){
        return  relatorioAcademiaRepository.faturasEmAberto();
    }
}