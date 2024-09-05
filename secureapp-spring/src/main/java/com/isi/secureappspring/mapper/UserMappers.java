package com.isi.secureappspring.mapper;

import com.isi.secureappspring.dto.request.AccountUserDtoRequest;
import com.isi.secureappspring.dto.response.AccountUserDtoResponse;
import com.isi.secureappspring.entities.AccountUserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMappers {
    AccountUserDtoResponse accountUserEntityToAccountUserDtoResponse(AccountUserEntity accountUserEntity);
    AccountUserEntity AccountUserDtoRequestToAccountUserEntity(AccountUserDtoRequest accountUserDtoRequest);
}
