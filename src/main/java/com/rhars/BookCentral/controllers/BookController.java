package com.rhars.BookCentral.controllers;

import com.rhars.BookCentral.dataVO.BookVO;
import com.rhars.BookCentral.models.Book;
import com.rhars.BookCentral.services.BookService;
import com.rhars.BookCentral.utils.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@Tag(name = "Book", description = "Endpoint for managing books.")
public class BookController {

    @Autowired
    private BookService service;

    // READ - HTTP GET
    // Endpoint: http://localhost:8080/api/v1/book
    @GetMapping
    @Operation(
            summary = "Find all books.", description = "Find all books.", tags = {"Book"},
            responses = {
                    @ApiResponse(description = "Sucess.", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            array = @ArraySchema(schema = @Schema(implementation = BookVO.class)))
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            }
    )
    public List<BookVO> findAll() {
        return service.findAll();
    }


    // READ - HTTP GET
    // Endpoint: http://localhost:8080/api/v1/book/ID
    @GetMapping("/{id}")
    @Operation(
            summary = "Find a book by ID.", description = "Find a book by ID.", tags = {"Book"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            schema = @Schema(implementation = BookVO.class)
                                    )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public BookVO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }


    // CREATE - HTTP POST
    // Endpoint: http://localhost:8080/api/v1/book
    @PostMapping
    @Operation(
            summary = "Create a book.", description = "Create a book.", tags = {"Book"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = BookVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public BookVO save(@RequestBody BookVO bookVO) {
        return service.save(bookVO);
    }


    // UPDATE - HTTP PUT
    // Endpoint: http://localhost:8080/api/v1/book
    @PutMapping
    @Operation(
            summary = "Update a book.", description = "Update a book.", tags = {"Book"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = BookVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public BookVO update(@RequestBody BookVO bookVO) {
        return service.update(bookVO);
    }


    // DELETE - HTTP DELETE
    // Endpoint: http://localhost:8080/api/v1/book/ID
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletes a book by ID.", description = "Deletes a book by ID.", tags = {"Book"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public String delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }


}
