package com.bankaya.pokemon_test.controllers;

import com.bankaya.pokemon_test.controllers.builder.MessageResponseBuilder;
import com.bankaya.pokemon_test.controllers.model.MessageResponse;
import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.pokemon.models.*;
import com.bankaya.pokemon_test.pokemon_api.pokemon.services.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon/{name}")
public class PokemonRestController {

    private final PokemonService pokemonService;

    @Autowired
    private PokemonRestController(final PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @Tag(name = "Pokemon", description = "Methods to retrieves the Pokemon's Information.")
    @Operation(
            summary = "Retrieves Pokemon's name",
            description = "Retrieve Pokemon's name given us its name"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Pokemon found!",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MessageResponse.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pokemon not found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MessageResponse.class)
                    )
            )
    })
    @GetMapping
    public ResponseEntity<MessageResponse<PokemonResponse>> getPokemonName(
            @Parameter(
                    description = "Pokemon's name to retrieve its ID",
                    required = true
            )
            @PathVariable("name") String name
    ) {
        try {
            PokemonResponse pokemon = this.pokemonService.getPokemonResponseByName(name);
            return MessageResponseBuilder.success(pokemon);
        } catch (PokemonBankayaException e) {
            return MessageResponseBuilder.error(e);
        }
    }

    @Tag(name = "Pokemon", description = "Methods to retrieves the Pokemon's Information.")
    @Operation(
            summary = "Retrieves Pokemon's Id",
            description = "Retrieve Pokemon's Id given us its name"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Pokemon found!",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MessageResponse.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pokemon not found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MessageResponse.class)
                    )
            )
    })
    @GetMapping("/id")
    public ResponseEntity<MessageResponse<PokemonIdResponse>> getPokemonIdByPokemonName(
            @Parameter(
                    description = "Pokemon's name to retrieve its ID",
                    required = true
            )
            @PathVariable("name") String name
    ) {
        try {
            PokemonIdResponse id = this.pokemonService.getPokemonIdByPokemonName(name);
            return MessageResponseBuilder.success(id);
        } catch (PokemonBankayaException e) {
            return MessageResponseBuilder.error(e);
        }
    }

    @Tag(name = "Pokemon", description = "Methods to retrieves the Pokemon's Information.")
    @Operation(
            summary = "Retrieves Pokemon's name",
            description = "Retrieve Pokemon's name given us its name"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Pokemon found!",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MessageResponse.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pokemon not found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MessageResponse.class)
                    )
            )
    })
    @GetMapping("/name")
    public ResponseEntity<MessageResponse<PokemonNameResponse>> getPokemonNameByPokemonName(
            @Parameter(
                    description = "Pokemon's name to retrieve its Name",
                    required = true
            )
            @PathVariable("name") String name
    ) {
        try {
            PokemonNameResponse nameFound = this.pokemonService.getPokemonNameByName(name);
            return MessageResponseBuilder.success(nameFound);
        } catch (PokemonBankayaException e) {
            return MessageResponseBuilder.error(e);
        }
    }

    @Tag(name = "Pokemon", description = "Methods to retrieves the Pokemon's Information.")
    @Operation(
            summary = "Retrieves Pokemon's Base Experience by pokemon name...",
            description = "Retrieve Pokemon's Base Experience given us its name..."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Pokemon found!",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MessageResponse.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pokemon not found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MessageResponse.class)
                    )
            )
    })
    @GetMapping("/base-experience")
    public ResponseEntity<MessageResponse<PokemonExperienceResponse>> getBaseExperienceByPokemonName(
            @Parameter(
                    description = "Pokemon's name to retrieve its Base Experience",
                    required = true
            )
            @PathVariable("name") String name
    ) {
        try {
            PokemonExperienceResponse baseExperience = this.pokemonService.getBaseExperienceByPokemonName(name);
            return MessageResponseBuilder.success(baseExperience);
        } catch (PokemonBankayaException e) {
            return MessageResponseBuilder.error(e);
        }
    }

}
