package com.isi.secureappspring.dto.response;

public record AccountUserDtoResponse(
        Long id,
        String email,
        Boolean status
) {
}
