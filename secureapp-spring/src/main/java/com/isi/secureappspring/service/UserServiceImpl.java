package com.isi.secureappspring.service;

import com.isi.secureappspring.dao.UserRepository;
import com.isi.secureappspring.dto.request.AccountUserDtoRequest;
import com.isi.secureappspring.dto.response.AccountUserDtoResponse;
import com.isi.secureappspring.entities.AccountUserEntity;
import com.isi.secureappspring.mapper.UserMappers;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private static final UserMappers userMappers = Mappers.getMapper(UserMappers.class);

    @Override
    public AccountUserDtoResponse saveUser(AccountUserDtoRequest accountUserDtoRequest) {
        AccountUserEntity accountUserEntity = userMappers.AccountUserDtoRequestToAccountUserEntity(accountUserDtoRequest);
        accountUserEntity = userRepository.save(accountUserEntity);
        return userMappers.accountUserEntityToAccountUserDtoResponse(accountUserEntity);
    }

    @Override
    public List<AccountUserDtoResponse> getUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable).getContent().stream()
                .map(userMappers::accountUserEntityToAccountUserDtoResponse)
                .toList();
    }

    @Override
    public AccountUserDtoResponse getUserById(Long id) {
        if (userRepository.existsById(id)) {
            return userMappers.accountUserEntityToAccountUserDtoResponse(userRepository.findById(id).get());
        }
        return null;
    }

    @Override
    public AccountUserDtoResponse getUserByEmail(String email) {
        Optional<AccountUserEntity> accountUserEntity = userRepository.findByEmail(email);
        return accountUserEntity.map(userMappers::accountUserEntityToAccountUserDtoResponse).orElse(null);
    }

    @Override
    public AccountUserDtoResponse editUser(AccountUserDtoResponse accountUserDtoResponse) {
        Optional<AccountUserEntity> accountUserEntity = userRepository.findById(accountUserDtoResponse.id());
        if (accountUserEntity.isPresent()) {
            if(accountUserDtoResponse.email()!=null){
                accountUserEntity.get().setEmail(accountUserDtoResponse.email());
                return userMappers.accountUserEntityToAccountUserDtoResponse(userRepository.save(accountUserEntity.get()));
            }
        }
        return null;
    }

    @Override
    public void deleteUserById(Long id) {
        if(userRepository.existsById(id)){
            AccountUserEntity accountUserEntity = userRepository.findById(id).get();
            userRepository.delete(accountUserEntity);
        }
    }

    @Override
    public void changeSatus(Long id) {
        if(userRepository.existsById(id)){
            AccountUserEntity accountUserEntity = userRepository.findById(id).get();
            accountUserEntity.setStatus(!accountUserEntity.getStatus());
            userRepository.save(accountUserEntity);
        }
    }
}
