package de.samuel.gamevault.documention;

import de.samuel.gamevault.dto.GameDTO;
import de.samuel.gamevault.enums.Platform;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "Games", description = "Recurso responsavel pelo gerenciamento de games na API")
public interface GameControllerDoc {

    @Operation(summary = "Salvar Game", description = "Metodo responsavel por cadastrar e salvar novos jogos no banco de dados",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Game salvo com sucesso", content = @Content(schema = @Schema(implementation = GameDTO.class)))
    public ResponseEntity<GameDTO> saveGame(@RequestBody GameDTO gameDTO);


    @Operation(summary = "Busca games", description = "Metodo responsavel por buscar todos os games cadastrados no banco de dados",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todos os games cadastrados", content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameDTO.class))))
    public ResponseEntity<List<GameDTO>> getAll();


    @Operation(summary = "Busca os games pelo ID", description = "Metodo responsavel por buscar games pelo ID",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Game encontrado com sucesso", content = @Content(schema = @Schema(implementation = GameDTO.class)))
    @ApiResponse(responseCode = "404", description = "Game não encontrado", content = @Content())
    public ResponseEntity<GameDTO> getById(@PathVariable @Valid Long id);


    @Operation(summary = "Atualizar Game", description = "Metodo responsavel por atualizar jogos no banco de dados",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Game atualizado com sucesso", content = @Content(schema = @Schema(implementation = GameDTO.class)))
    @ApiResponse(responseCode = "404", description = "Game não encontrado", content = @Content())
    public ResponseEntity<GameDTO> updateGame(@PathVariable Long id, @RequestBody @Valid GameDTO gameDTO);


    @Operation(summary = "Deleta games por ID", description = "Metodo responsavel por deletar games pelo ID",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Game deletado com sucesso", content = @Content())
    @ApiResponse(responseCode = "404", description = "Game não encontrada", content = @Content())
    public ResponseEntity<Void> deleteGame(@PathVariable Long id);

    @Operation(summary = "Busca games pela plataforma", description = "Metodo responsavel por buscar todos os games cadastrados no banco de dados pela plataforma",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todos os games cadastrados pela plataforma correspondente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameDTO.class))))
    @ApiResponse(responseCode = "404", description = "Não há nenhum jogo cadastrado nesta plataforma", content = @Content())
    public ResponseEntity<List<GameDTO>> getByPlatform(@RequestParam List<Platform> platforms);

}
