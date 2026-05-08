package dev.erik.mastersys.dto;

import dev.erik.mastersys.domain.Aluno;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlunoRequest(
        @NotBlank(message = "O nome é obrigatorio.")
        @Size(max = 150, message = "O nome deve ter o maximo de 150 caracteres.")
        String nome,

        @Past(message = "A data de nascimento deve estar no passado.")
        LocalDate dataNascimento,

        @Size(max = 1, message = "O genero deve conter apenas uma letra.")
        String sexo,

        @Size(max = 30, min = 11, message = "O telefone deve ter entre 11 e 30 caracteres.")
        String telefone,

        @Size(max = 30, min = 11, message = "O celular deve ter entre 11 e 30 caracteres.")
        String celular,

        @Email(message = "Email invalido")
        @Size(max = 150, message ="O email deve ter no máximo 150 caracteres")
        String email,

        String observacao,

        @Size(max = 50, message = "O endereço deve ter no máximo 150 caracteres.")
        String endereco,

        @Size(max = 5, message = "O numero da residencia deve ter no máximo 5 caracteres.")
        String numero,

        @Size(max = 100, message = "O complemento deve ter no máximo 100 caracteres." )
        String complemento,

        @Size(max = 25, message = "O nome do bairro deve ter no máximo 25 caracteres.")
        String bairro,

        @Size(max = 25, message = "O nome da cidade deve ter no máximo 25 caracteres")
        String cidade,

        @Size(max = 2, message = "O nome do estado deve ter no máximo 2 caracteres")
        String estado,

        @Size(max = 9, message = "O cep deve ter no máximo 9 caracteres.")
        String cep
) {

    public Aluno toEntity() {
        Aluno aluno = new Aluno();
        preencher(aluno);
        return aluno;
    }

    public void preencher(Aluno aluno) {
        aluno.setNome(nome);
        aluno.setDataNascimento(dataNascimento);
        aluno.setSexo(sexo);
        aluno.setTelefone(telefone);
        aluno.setCelular(celular);
        aluno.setEmail(email);
        aluno.setObservacao(observacao);
        aluno.setEndereco(endereco);
        aluno.setNumero(numero);
        aluno.setComplemento(complemento);
        aluno.setBairro(bairro);
        aluno.setCidade(cidade);
        aluno.setEstado(estado);
        aluno.setCep(cep);
    }

}
