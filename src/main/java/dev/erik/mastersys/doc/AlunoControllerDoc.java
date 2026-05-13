package dev.erik.mastersys.doc;

import dev.erik.mastersys.dto.AlunoFiltroRequest;
import dev.erik.mastersys.dto.AlunoRequest;
import dev.erik.mastersys.dto.AlunoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(
        name = "Alunos",
        description = "Operações para cadastro, consulta, atualização, exclusão" +
                        " e filtragem de alunos"
)
public interface AlunoControllerDoc {

    @Operation(
            summary = "Cadastrar aluno",
            description = "Criar um novo aluno no sistema da academia",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Aluno cadastrado com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Erro de validação ou regra de negócio",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    )
            }
    )

    AlunoResponse cadastrar
            (
                    @RequestBody
                    @Valid
                    @io.swagger.v3.oas.annotations.parameters.RequestBody(
                            description = "Dados necessários para cadastrar um aluno",
                            required = true,
                            content = @Content(schema = @Schema(implementation = AlunoRequest.class),
                            examples = @ExampleObject(
                                    name = "Aluno válido",
                                    value = """
                                            {
                                                "nome" : "radames p",
                                                 "dataNascimento": "1991-11-21",
                                                 "sexo": "M",
                                                 "telefone": "49917588937",
                                                 "celular": "499829000319",
                                                 "email" : "radames@gmail",
                                                 "observacao": "aluno iniciante",
                                                 "endereco": "rua casemiro de abreu",
                                                 "numero": "403",
                                                 "complemento": "casa de pedra",
                                                 "bairro": "efapi",
                                                 "cidade": "florianopolis",
                                                 "estado": "sc",
                                                 "cep": "89132901"
                                            }
                                            """
                            ))
                    )
                    AlunoRequest alunoRequest
            );


    @Operation(
            summary = "Listar alunos",
            description = "Lista alunos de forma paginada, permitindo filtros opcionais por " +
                    "nome, e-mail, celular, cidade e estado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de alunos retornada com sucesso")
            }
    )
    Page<AlunoResponse> listar(
            @Parameter(description = "Filtros opcionais para busca de alunos")
            AlunoFiltroRequest filtro,

            @Parameter(description = "Informações de paginação e ordenação")
            Pageable pageable
    );

    @Operation(
            summary = "Buscar aluno por ID",
            description = "Retorna os dados de um aluno específico",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Aluno encontrado"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Aluno não encontrado",
                            content = @Content(schema = @Schema(implementation = ErrorViewResolver.class))
                    )
            }
    )

    AlunoResponse buscarPorId(
            @Parameter(description = "Id do aluno", example = "2", required = true)
            Long id);
}
