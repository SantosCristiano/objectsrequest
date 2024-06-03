package br.com.diebold.resources;

import br.com.diebold.dto.TerceiroDTO;
import br.com.diebold.exceptions.ResourceException;
import br.com.diebold.integration.TotvsClient;
import feign.FeignException;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ObterSaldoTerceiro")
@RestController
@Import(FeignClientsConfiguration.class)
@SecurityRequirement(name = "bearer-key") //Swagger
public class TerceiroResource {

    @Autowired
    TotvsClient totvsClient;

    @GetMapping
    public ResponseEntity<TerceiroDTO> obterSaldoTerceiroByFilialAndProduto(@RequestParam("CodFilial") Integer CodFilial, @RequestParam("CodProduto") String CodProduto) {
        try {
            TerceiroDTO responseEntity = totvsClient.obterSaldoTerceiroByFilialAndProduto(CodFilial, CodProduto);
            return new ResponseEntity<TerceiroDTO>(responseEntity, HttpStatus.OK);
        } catch (FeignException feignException) {
            throw new ResourceException("Saldo de terceiro não encontrado para Filial " + CodFilial + " e Produto " + CodProduto);
        }
    };
}

