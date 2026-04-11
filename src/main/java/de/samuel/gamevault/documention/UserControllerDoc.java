package de.samuel.gamevault.documention;

import de.samuel.gamevault.dto.GameDTO;
import de.samuel.gamevault.dto.UserDTO;
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

@Tag(name = "Users", description = "Recurso responsavel pelo gerenciamento de usuarios da API")
public interface UserControllerDoc {

    @Operation(summary = "Salvar Usuario", description = "Metodo responsavel por cadastrar e salvar novos usuarios no banco de dados")
    @ApiResponse(responseCode = "201", description = "Usuario salvo com sucesso", content = @Content(schema = @Schema(implementation = GameDTO.class)))
    public ResponseEntity<UserDTO> saveUser(@RequestBody @Valid UserDTO userDTO);


    @Operation(summary = "Busca Usuario", description = "Metodo responsavel por buscar todos os usuarios cadastrados no banco de dados",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todos os usuarios cadastrados", content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameDTO.class))))
    public ResponseEntity<List<UserDTO>> getAll();


    @Operation(summary = "Busca os usuarios pelo ID", description = "Metodo responsavel por buscar usuarios pelo ID",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Usuario encontrado com sucesso", content = @Content(schema = @Schema(implementation = GameDTO.class)))
    @ApiResponse(responseCode = "404", description = "Usuario não encontrado", content = @Content())
    public ResponseEntity<UserDTO> getById(@PathVariable Long id);


    @Operation(summary = "Atualizar usuario", description = "Metodo responsavel por atualizar os usuarios cadastrados no banco de dados",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Usuario atualizado com sucesso", content = @Content(schema = @Schema(implementation = GameDTO.class)))
    @ApiResponse(responseCode = "404", description = "Usuario não encontrado", content = @Content())
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody @Valid UserDTO userDTO);


    @Operation(summary = "Deleta Usuarios por ID", description = "Metodo responsavel por deletar usuarios pelo ID",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Usuario deletado com sucesso", content = @Content())
    @ApiResponse(responseCode = "404", description = "Usuario não encontrada", content = @Content())
    public ResponseEntity<Void> deleteUser(@PathVariable Long id);



}
