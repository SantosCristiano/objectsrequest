package br.com.diebold.resources;

import br.com.diebold.dto.MaterialDTO;
import br.com.diebold.exceptions.ResourceException;
import br.com.diebold.integration.TotvsClient;
import feign.FeignException;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/RecebimentoMaterial")
@RestController
@Import(FeignClientsConfiguration.class)
@SecurityRequirement(name = "bearer-key") //Swagger
public class MaterialResource {

    @Autowired
    TotvsClient totvsClient;

    @PostMapping
    public ResponseEntity<MaterialDTO> obterRecebimentoMaterialById(@RequestBody String RequisicaoId) {
        try {
            MaterialDTO responseEntity = totvsClient.obterRecebimentoMaterialById(RequisicaoId);
            return new ResponseEntity<MaterialDTO>(responseEntity, HttpStatus.OK);
        } catch (FeignException feignException) {
            throw new ResourceException("Recebimento do material não encontrado para o ID: " + RequisicaoId);
        }
    };
}

