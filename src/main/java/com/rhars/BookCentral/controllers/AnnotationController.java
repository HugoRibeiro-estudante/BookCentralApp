package com.rhars.BookCentral.controllers;

import com.rhars.BookCentral.dataVO.AnnotationVO;
import com.rhars.BookCentral.dataVO.BookVO;
import com.rhars.BookCentral.exceptions.RequiredObjectIsNullException;
import com.rhars.BookCentral.mapper.DozerMapper;
import com.rhars.BookCentral.models.Book;
import com.rhars.BookCentral.repositories.BookRepository;
import com.rhars.BookCentral.services.AnnotationService;
import com.rhars.BookCentral.services.BookService;
import com.rhars.BookCentral.utils.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/annotation")
@Tag(name = "Annotation", description = "Endpoint for managing annotations.")
public class AnnotationController {

    @Autowired
    private AnnotationService service;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    // READ - HTTP GET
    // Endpoint: http://localhost:8080/api/v1/annotation
    @CrossOrigin
    @GetMapping
    @Operation(
            summary = "Find all annotations.", description = "Find all annotations.", tags = {"Annotation"},
            responses = {
                    @ApiResponse(description = "Sucess.", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            array = @ArraySchema(schema = @Schema(implementation = AnnotationVO.class)))
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            }
    )
    public List<AnnotationVO> findAll() {
        return service.findAll();
    }


    // READ - HTTP GET
    // Endpoint: http://localhost:8080/api/v1/annotation/ID
    @GetMapping("/{id}")
    @Operation(
            summary = "Find a annotation by ID.", description = "Find a annotation by ID.", tags = {"Annotation"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            schema = @Schema(implementation = AnnotationVO.class)
                                    )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public AnnotationVO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }


    // CREATE - HTTP POST
    // Endpoint: http://localhost:8080/api/v1/annotation
    @PostMapping
    @Operation(
            summary = "Create a annotation.", description = "Create a annotation.", tags = {"Annotation"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = AnnotationVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public AnnotationVO save(@RequestBody AnnotationVO annotationVO) {

        System.out.println("annotationVO: " + annotationVO);

        // Verificar se o livro existe antes de associá-lo à Annotation
        // Long bookId = annotationVO.getBook().getId();
        // BookVO book = bookService.findById(bookId);

        // if (book == null) {
        //         // Lidar com o caso em que o livro não foi encontrado
        //         throw new RequiredObjectIsNullException("Livro não encontrado para o ID: " + bookId);
        // }
        

        // var bookconvert = DozerMapper.parseObject(book, Book.class);
        // annotationVO.setBook(bookconvert);
        return service.save(annotationVO);
    }


    // UPDATE - HTTP PUT
    // Endpoint: http://localhost:8080/api/v1/annotation
    @PutMapping
    @Operation(
            summary = "Update a annotation.", description = "Update a annotation.", tags = {"Annotation"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = AnnotationVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public AnnotationVO update(@RequestBody AnnotationVO annotationVO) {
        return service.update(annotationVO);
    }


    // DELETE - HTTP DELETE
    // Endpoint: http://localhost:8080/api/v1/email/ID
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletes a annotation by ID.", description = "Deletes a annotation by ID.", tags = {"Annotation"},
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
