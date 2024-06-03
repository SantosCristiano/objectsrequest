package br.com.diebold.resources;

import br.com.diebold.integration.TotvsClient;
import br.com.diebold.dto.RequisicaoDTO;
import br.com.diebold.exceptions.ResourceException;
import feign.FeignException;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ObterStatusRequisicao")
@RestController
@Import(FeignClientsConfiguration.class)
@SecurityRequirement(name = "bearer-key") //Swagger
public class RequisicaoResource {

    @Autowired
    TotvsClient totvsClient;

    @GetMapping
    public ResponseEntity<RequisicaoDTO> obterStatusRequisicaoById(@RequestParam("RequisicaoId") Integer RequisicaoId) {
        try {
            RequisicaoDTO responseEntity = totvsClient.obterStatusRequisicaoById(RequisicaoId);
            return new ResponseEntity<RequisicaoDTO>(responseEntity, HttpStatus.OK);
        } catch (FeignException feignException) {
            throw new ResourceException("Status da requisição não encontrado para o ID: " + RequisicaoId);
        }
    };
}

