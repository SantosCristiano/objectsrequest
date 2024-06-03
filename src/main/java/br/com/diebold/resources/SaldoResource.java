package br.com.diebold.resources;

import br.com.diebold.dto.SaldoDTO;
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

@RequestMapping("/ObterSaldo")
@RestController
@Import(FeignClientsConfiguration.class)
@SecurityRequirement(name = "bearer-key") //Swagger
public class SaldoResource {

	@Autowired
    TotvsClient totvsClient;

    @PostMapping
    public ResponseEntity<SaldoDTO> obterSaldoByFilialAndProdutos(@RequestBody SaldoDTO saldoDTO) {
        try {
            SaldoDTO responseEntity = totvsClient.obterSaldoByFilialAndProdutos(saldoDTO);
            return new ResponseEntity<SaldoDTO>(responseEntity, HttpStatus.OK);
        } catch (FeignException feignException) {
            throw new ResourceException("Saldo não encontrado!");
        }
    };
}

