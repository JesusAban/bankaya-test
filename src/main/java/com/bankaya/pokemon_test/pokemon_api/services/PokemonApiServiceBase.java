package com.bankaya.pokemon_test.pokemon_api.services;

import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.models.PokemonLocationAreaItem;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Getter
public abstract class PokemonApiServiceBase<T> {

    @Value("${pokemon-api.url}")
    private String url;

    protected T get(String path, Class<T> classType) throws PokemonBankayaException {
        RestTemplate restTemplate = new RestTemplate();

        String newPath = url.concat(path);
        try {
            ResponseEntity<T> entity = restTemplate.getForEntity(newPath, classType);
            return entity.getBody();
        } catch (Exception e) {
            String message = String.format("Error trying to consume: %s, message: %s", newPath, e.getMessage());
            throw new PokemonBankayaException(message);
        }
    }

    protected List<T> getList(String path, Class<T[]> classType) throws PokemonBankayaException {
        RestTemplate restTemplate = new RestTemplate();

        String newPath = getUrl().concat(path);
        try {

            ResponseEntity<T[]> entity = restTemplate.getForEntity(newPath, classType);

            return Arrays.asList(Objects.requireNonNull(entity.getBody()));
        } catch (Exception e) {
            String message = String.format("Error trying to consume: %s, message: %s", newPath, e.getMessage());
            throw new PokemonBankayaException(message);
        }
    }

}
