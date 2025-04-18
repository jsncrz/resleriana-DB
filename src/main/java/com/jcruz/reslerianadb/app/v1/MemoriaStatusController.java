package com.jcruz.reslerianadb.app.v1;

import com.jcruz.reslerianadb.domain.model.CharacterStatsResponse;
import com.jcruz.reslerianadb.domain.model.MemoriaResponse;
import com.jcruz.reslerianadb.domain.model.MemoriaStatusResponse;
import com.jcruz.reslerianadb.domain.service.CharacterStatsService;
import com.jcruz.reslerianadb.domain.service.MemoriaService;
import com.jcruz.reslerianadb.domain.service.MemoriaStatusService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/memorias/{id}/status")
public class MemoriaStatusController {

    private final MemoriaStatusService service;

    public MemoriaStatusController(MemoriaStatusService service) {
        this.service = service;
    }

    @GetMapping
    public MemoriaStatusResponse getMemoriaStatus(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language, @PathVariable("id") int id) {
        return this.service.getMemoriaStatus(id);
    }
}
