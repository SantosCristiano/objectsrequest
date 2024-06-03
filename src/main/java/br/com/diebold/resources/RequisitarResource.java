package br.com.diebold.resources;

import br.com.diebold.dto.RequisicaoDTO;
import br.com.diebold.dto.RequisitaDTO;
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

@RequestMapping("/RequisicaoMaterial")
@RestController
@Import(FeignClientsConfiguration.class)
@SecurityRequirement(name = "bearer-key") //Swagger
public class RequisitarResource {

    @Autowired
    TotvsClient totvsClient;

    @PostMapping("/Requisitar")
    public ResponseEntity<RequisicaoDTO> requisitarMaterial(@RequestBody RequisitaDTO requisitaDTO) {
        try {
            RequisicaoDTO responseEntity = totvsClient.requisitarMaterial(requisitaDTO);
            return new ResponseEntity<RequisicaoDTO>(responseEntity, HttpStatus.OK);
        } catch (FeignException feignException) {
            throw new ResourceException("Requisição não realizada!");
        }
    };
}

