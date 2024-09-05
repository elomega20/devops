package com.isi.secureappspring.service;

import com.isi.secureappspring.dto.request.AccountUserDtoRequest;
import com.isi.secureappspring.dto.response.AccountUserDtoResponse;

import java.util.List;

public interface UserService {
    AccountUserDtoResponse saveUser(AccountUserDtoRequest accountUserDtoRequest);
    List<AccountUserDtoResponse> getUsers(int page, int size);
    AccountUserDtoResponse getUserById(Long id);
    AccountUserDtoResponse getUserByEmail(String email);
    AccountUserDtoResponse editUser(AccountUserDtoResponse accountUserDtoResponse);
    void deleteUserById(Long id);
    void changeSatus(Long id);
}
