package br.com.inatel.stonks.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("stockcache")
@RequiredArgsConstructor
public class CacheManagerController {

    @DeleteMapping
    @CacheEvict(value = "stockList", allEntries = true)
    public ResponseEntity<Void> delete() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
