package com.system.system_pos.dto.user;

import com.system.system_pos.model.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

public record UserRequest(
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    String name,

    @NotNull(message = "El rol es requerido")
    Role role,

    @NotBlank(message = "El usuario no puede estar vacío")
    @Size(min = 3, max = 20, message = "El usuario debe tener entre 3 y 20 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "El usuario solo puede contener letras, números, guiones y guiones bajos")
    String username,

    @NotBlank(message = "El NIT no puede estar vacío")
    @Size(min = 5, max = 20, message = "El NIT debe tener entre 5 y 20 caracteres")
    String nit,

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, max = 255, message = "La contraseña debe tener al menos 8 caracteres")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
             message = "La contraseña debe contener mayúsculas, minúsculas, números y caracteres especiales (@$!%*?&)")
    String password,

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El email debe ser válido")
    String email
) {
}