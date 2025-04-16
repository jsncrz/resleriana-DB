package com.jcruz.reslerianadb.app.v1;

import com.jcruz.reslerianadb.domain.model.MemoriaResponse;
import com.jcruz.reslerianadb.domain.service.MemoriaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/memorias")
public class MemoriaController {

    private final MemoriaService MemoriaService;

    public MemoriaController(MemoriaService MemoriaService) {
        this.MemoriaService = MemoriaService;
    }

    @GetMapping
    public Page<MemoriaResponse> getMemorias(
            @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language,
            @RequestParam(name = "rarity", required = false) Integer rarity,
            Pageable p) {
        return this.MemoriaService.findMemorias(rarity, language, p);
    }

    @GetMapping(value="/{id}")
    public MemoriaResponse getMemoria(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language, @PathVariable("id") int id) {
        return this.MemoriaService.getMemoria(id, language);
    }
}
