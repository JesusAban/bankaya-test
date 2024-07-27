package com.bankaya.pokemon_test.pokemon_api.services;

import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.services.constants.PokemonApiServiceBaseMessage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public abstract class PokemonApiServiceBase<T> {

    @Value("${pokemon-api.url}")
    private String url;

    protected T get(String path, Class<T> classType) throws PokemonBankayaException {
        RestTemplate restTemplate = new RestTemplate();

        String newPath = url.concat(path);
        try {
            ResponseEntity<T> entity = restTemplate.getForEntity(newPath, classType);
            return entity.getBody();
        } catch (HttpClientErrorException ex) {
            ex.printStackTrace();
            String message = String.format(PokemonApiServiceBaseMessage.ERROR_TRYING_TO_CONSUME_API, newPath, ex.getMessage());
            throw new PokemonBankayaException(message, ex.getStatusCode().value());
        } catch (Exception e) {
            e.printStackTrace();
            String message = String.format(PokemonApiServiceBaseMessage.ERROR_TRYING_TO_CONSUME_API, newPath, e.getMessage());
            throw new PokemonBankayaException(message, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    protected List<T> getList(String path, Class<T[]> classType) throws PokemonBankayaException {
        RestTemplate restTemplate = new RestTemplate();

        String newPath = getUrl().concat(path);
        try {

            ResponseEntity<T[]> entity = restTemplate.getForEntity(newPath, classType);

            return Arrays.asList(Objects.requireNonNull(entity.getBody()));
        } catch (HttpClientErrorException ex) {
            ex.printStackTrace();
            String message = String.format(PokemonApiServiceBaseMessage.ERROR_TRYING_TO_CONSUME_API, newPath, ex.getMessage());
            throw new PokemonBankayaException(message, ex.getStatusCode().value());
        } catch (Exception e) {
            e.printStackTrace();
            String message = String.format(PokemonApiServiceBaseMessage.ERROR_TRYING_TO_CONSUME_API, newPath, e.getMessage());
            throw new PokemonBankayaException(message, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

}
