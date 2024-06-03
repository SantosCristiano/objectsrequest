package br.com.diebold.integration;

import br.com.diebold.dto.MaterialDTO;
import br.com.diebold.dto.RequisicaoDTO;
import br.com.diebold.dto.RequisitaDTO;
import br.com.diebold.dto.SaldoDTO;
import br.com.diebold.dto.TerceiroDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${apitotvs.service.name}", url = "${apitotvs.service.url}", configuration = TotvsConfiguration.class)
public interface TotvsClient {

    @GetMapping("/ObterStatusRequisicao")
    RequisicaoDTO obterStatusRequisicaoById(@RequestParam("RequisicaoId") Integer RequisicaoId);

    @GetMapping("/ObterSaldoTerceiro")
    TerceiroDTO obterSaldoTerceiroByFilialAndProduto(@RequestParam("CodFilial") Integer CodFilial, @RequestParam("CodProduto") String CodProduto);

    @PostMapping("/RecebimentoMaterial")
    MaterialDTO obterRecebimentoMaterialById(@RequestBody() String RequisicaoId);

    @PostMapping("/ObterSaldo")
    SaldoDTO obterSaldoByFilialAndProdutos(@RequestBody SaldoDTO saldoDTO);

    @PostMapping("/RequisicaoMaterial")
    RequisicaoDTO requisitarMaterial(@RequestBody RequisitaDTO requisicaoDTO);
}
