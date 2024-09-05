package com.isi.secureappspring.dto.request;

public record AccountUserDtoRequest(
        Long id,
        String email,
        String password,
        Boolean status
) {
}
