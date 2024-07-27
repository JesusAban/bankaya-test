package com.bankaya.pokemon_test.controllers;

import com.bankaya.pokemon_test.controllers.builder.MessageResponseBuilder;
import com.bankaya.pokemon_test.controllers.model.MessageResponse;
import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.locationAreaEncounter.models.PokemonEncounterResponse;
import com.bankaya.pokemon_test.pokemon_api.locationAreaEncounter.service.PokemonEncounterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon/{name}/location-area-encounters")
public class PokemonEncounterRestController {

    private final PokemonEncounterService pokemonEncounterService;

    @Autowired
    public PokemonEncounterRestController(final PokemonEncounterService pokemonEncounterService) {
        this.pokemonEncounterService = pokemonEncounterService;
    }

    @Tag(name = "Location Area Encounters", description = "Methods to retrieves the Pokemon's Location area encounters.")
    @Operation(
            summary = "Retrieves Pokemon's Location Area Encounter by pokemon name...",
            description = "Retrieve Pokemon's Location Area Encounter given us its name..."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Pokemon's Location Area encounters found!",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MessageResponse.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pokemon's Location Area encounters not found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MessageResponse.class)
                    )
            )
    })
    @GetMapping
    public ResponseEntity<MessageResponse<PokemonEncounterResponse>> getLocationAreaEncounterByPokemonName(
            @Parameter(
                    description = "Pokemon's name to retrieve its Location Area Encounter",
                    required = true
            )
            @PathVariable("name") String name
    ) {
        try {
            PokemonEncounterResponse locationsArea = pokemonEncounterService.getLocationAreaEncounterByPokemonName(name);
            return MessageResponseBuilder.success(locationsArea);
        } catch (PokemonBankayaException e) {
            return MessageResponseBuilder.error(e);
        }
    }
}
