package com.nesrux.organizer.infrastructure.api.docs;

import com.nesrux.organizer.infrastructure.api.models.category.CategoryIdInput;
import com.nesrux.organizer.infrastructure.api.models.category.CategoryInputDto;
import com.nesrux.organizer.infrastructure.api.models.category.CategoryListDTO;
import com.nesrux.organizer.infrastructure.api.models.category.CategoryOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/categories")
@Tag(name = "categories")
public interface CategoryApi {

    @GetMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(description = "Get a category by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "category retrieved"),
            @ApiResponse(responseCode = "404", description = "category not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<CategoryOutput> findById(@PathVariable CategoryIdInput inputId);

    @Operation(description = "List all categorys")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categories retrieved"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<CategoryListDTO> findAll();

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(description = "Create a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "category Created"),
            @ApiResponse(responseCode = "400", description = "A validation error was thrown"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<CategoryOutput> save(@RequestBody CategoryInputDto category);

    @DeleteMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "category deleted"),
            @ApiResponse(responseCode = "404", description = "category not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Void> delete(@PathVariable CategoryIdInput inputId);

}
