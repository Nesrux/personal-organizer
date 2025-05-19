package com.nesrux.organizer.infrastructure.api.docs;

import com.nesrux.organizer.infrastructure.api.models.task.TaskInputDto;
import com.nesrux.organizer.infrastructure.api.models.task.TaskInputId;
import com.nesrux.organizer.infrastructure.api.models.task.TaskListDTO;
import com.nesrux.organizer.infrastructure.api.models.task.TaskOutputDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "tasks")
@Tag(name = "Task")
public interface TaskApi {
    @GetMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(description = "Get a task by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task retrieved"),
            @ApiResponse(responseCode = "404", description = "Task not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<TaskOutputDto> findById(@PathVariable TaskInputId id);

    @GetMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(description = "List all tasks")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tasks retrieved"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<TaskListDTO> findAll();

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(description = "Create a new Task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Task Created"),
            @ApiResponse(responseCode = "400", description = "A validation error was thrown"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<TaskOutputDto> save(@RequestBody TaskInputDto body);

    @DeleteMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Task deleted"),
            @ApiResponse(responseCode = "404", description = "Task not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Void> delete(@PathVariable TaskInputId id);
}
