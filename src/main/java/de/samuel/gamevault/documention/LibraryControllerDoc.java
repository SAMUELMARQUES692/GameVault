package de.samuel.gamevault.documention;

import de.samuel.gamevault.dto.GameDTO;
import de.samuel.gamevault.dto.LibraryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Library", description = "Recurso responsavel pelo gerenciamento das bibliotecas de jogos da API")
public interface LibraryControllerDoc {

    @Operation(summary = "Salvar Biblioteca", description = "Metodo responsavel por cadastrar e salvar novas bibliotecas no banco de dados" ,
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "biblioteca salva com sucesso", content = @Content(schema = @Schema(implementation = GameDTO.class)))
    public ResponseEntity<LibraryDTO> saveLibrary(@RequestBody @Valid LibraryDTO libraryDTO);


    @Operation(summary = "Busca Biblioteca", description = "Metodo responsavel por buscar todos as bibliotecas cadastradas no banco de dados",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todas as bibliotecas cadastradas", content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameDTO.class))))
    public ResponseEntity<List<LibraryDTO>> getAll();


    @Operation(summary = "Busca as bibliotecas pelo ID", description = "Metodo responsavel por buscar as bibliotecas pelo ID",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Biblioteca encontrada com sucesso", content = @Content(schema = @Schema(implementation = GameDTO.class)))
    @ApiResponse(responseCode = "404", description = "Biblioteca não encontrada", content = @Content())
    public ResponseEntity<LibraryDTO> findById(@PathVariable Long id);


    @Operation(summary = "Atualizar Biblioteca", description = "Metodo responsavel por atualizar as bibliotecas cadastradas no banco de dados",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Biblioteca atualizada com sucesso", content = @Content(schema = @Schema(implementation = GameDTO.class)))
    @ApiResponse(responseCode = "404", description = "Biblioteca não encontrada", content = @Content())
    public ResponseEntity<LibraryDTO> updateById(@PathVariable Long id, @RequestBody @Valid LibraryDTO libraryDTO);


    @Operation(summary = "Deleta Biblioteca por ID", description = "Metodo responsavel por deletar bibliotecas pelo ID",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Biblioteca deletada com sucesso", content = @Content())
    @ApiResponse(responseCode = "404", description = "Biblioteca não encontrada", content = @Content())
    public ResponseEntity<Void> deleteById(@PathVariable Long id);
}
