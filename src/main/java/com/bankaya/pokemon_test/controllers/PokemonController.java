package com.bankaya.pokemon_test.controllers;

import com.bankaya.pokemon_test.controllers.builder.MessageResponseBuilder;
import com.bankaya.pokemon_test.controllers.model.MessageResponse;
import com.bankaya.pokemon_test.exceptions.PokemonBankayaException;
import com.bankaya.pokemon_test.pokemon_api.models.Pokemon;
import com.bankaya.pokemon_test.pokemon_api.models.PokemonAbility;
import com.bankaya.pokemon_test.pokemon_api.models.PokemonHeldItem;
import com.bankaya.pokemon_test.pokemon_api.models.PokemonLocationAreaItem;
import com.bankaya.pokemon_test.pokemon_api.services.PokemonAbilityApiService;
import com.bankaya.pokemon_test.pokemon_api.services.PokemonApiService;
import com.bankaya.pokemon_test.pokemon_api.services.PokemonEncounterApiService;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController("/")
public class PokemonController {

    private final PokemonApiService pokemonApiService;
    private final PokemonEncounterApiService pokemonEncounterService;
    private final PokemonAbilityApiService pokemonAbilityService;

    @Autowired
    public PokemonController(
            final PokemonApiService pokemonApiService,
            final PokemonEncounterApiService pokemonEncounterService,
            final PokemonAbilityApiService pokemonAbilityService
            ) {
        this.pokemonApiService = pokemonApiService;
        this.pokemonEncounterService = pokemonEncounterService;
        this.pokemonAbilityService = pokemonAbilityService;
    }

    @Tag(name = "pokemon", description = "Methods to retrieves the Pokemon's Information.")
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
    @GetMapping("pokemon/{name}/id")
    public ResponseEntity<MessageResponse> getPokemonIdByPokemonName(
            @Parameter(
                    description = "Pokemon's name to retrieve its ID",
                    required = true
            )
            @PathVariable String name
    ) {
        try {
            Integer id = this.pokemonApiService.getPokemonIdByPokemonName(name);
            return MessageResponseBuilder.success(id);
        } catch (PokemonBankayaException e) {
            return MessageResponseBuilder.error(e);
        }
    }

    @Tag(name = "pokemon", description = "Methods to retrieves the Pokemon's Information.")
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
    @GetMapping("pokemon/{name}/name")
    public ResponseEntity<MessageResponse> getPokemonNameByPokemonName(
            @Parameter(
                    description = "Pokemon's name to retrieve its Name",
                    required = true
            )
            @PathVariable String name
    ) {
        try {
            String nameFound = this.pokemonApiService.getPokemonNameByName(name);
            return MessageResponseBuilder.success(nameFound);
        } catch (PokemonBankayaException e) {
            return MessageResponseBuilder.error(e);
        }
    }

    @Tag(name = "pokemon", description = "Methods to retrieves the Pokemon's Information.")
    @Operation(
            summary = "Retrieves Pokemon's Location Area Encounter by pokemon name...",
            description = "Retrieve Pokemon's Location Area Encounter given us its name..."
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
    @GetMapping("pokemon/{name}/location-area-encounter")
    public ResponseEntity<MessageResponse> getLocationAreaEncounterByPokemonName(
            @Parameter(
                    description = "Pokemon's name to retrieve its Location Area Encounter",
                    required = true
            )
            @PathVariable String name
    ) {
        try {
            List<PokemonLocationAreaItem> locationsArea = pokemonEncounterService.getLocationAreaEncounterByPokemonName(name);
            return MessageResponseBuilder.success(locationsArea);
        } catch (PokemonBankayaException e) {
            return MessageResponseBuilder.error(e);
        }
    }

    @Tag(name = "pokemon", description = "Methods to retrieves the Pokemon's Information.")
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
    @GetMapping("pokemon/{name}/base-experience")
    public ResponseEntity<MessageResponse> getBaseExperienceByPokemonName(
            @Parameter(
                    description = "Pokemon's name to retrieve its Base Experience",
                    required = true
            )
            @PathVariable String name
    ) {
        try {
            Integer baseExperience = this.pokemonApiService.getBaseExperienceByPokemonName(name);
            return MessageResponseBuilder.success(baseExperience);
        } catch (PokemonBankayaException e) {
            return MessageResponseBuilder.error(e);
        }
    }

    @Tag(name = "pokemon", description = "Methods to retrieves the Pokemon's Information.")
    @Operation(
            summary = "Retrieves Pokemon's Held Items by pokemon name...",
            description = "Retrieve Pokemon's Held Items given us its name..."
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
    @GetMapping("pokemon/{name}/held-items")
    public ResponseEntity<MessageResponse> getPokemonHeldItemsByPokemonName(
            @Parameter(
                    description = "Pokemon's name to retrieve its Held Items",
                    required = true
            )
            @PathVariable String name
    ) {
        try {
            List<PokemonHeldItem> heldItems = this.pokemonApiService.getPokemonHeldItemsByPokemonName(name);
            return MessageResponseBuilder.success(heldItems);
        } catch (PokemonBankayaException e) {
            return MessageResponseBuilder.error(e);
        }
    }

    @Tag(name = "pokemon", description = "Methods to retrieves the Pokemon's Information.")
    @Operation(
            summary = "Retrieves Pokemon's Abilities by pokemon name...",
            description = "Retrieve Pokemon's Abilities given us its name..."
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
    @GetMapping("pokemon/{name}/abilities")
    public ResponseEntity<MessageResponse> getAllAbilitiesByPokemon(
            @Parameter(
                    description = "Pokemon's name to retrieve its Abilities",
                    required = true
            )
            @PathVariable String name
    ) {
        try {
            Pokemon pokemon = this.pokemonApiService.getPokemonByName(name);
            List<PokemonAbility> heldItems = this.pokemonAbilityService.getAllAbilitiesByPokemon(pokemon);
            return MessageResponseBuilder.success(heldItems);
        } catch (PokemonBankayaException e) {
            return MessageResponseBuilder.error(e);
        }
    }

}
