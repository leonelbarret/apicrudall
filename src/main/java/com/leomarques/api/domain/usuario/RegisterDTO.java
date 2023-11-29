package com.leomarques.api.domain.usuario;

public record RegisterDTO(String login, String password, UserRole role) {
}
