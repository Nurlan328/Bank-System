package kz.iitu.itse1910.nurlan.oibekuly.repository.impl;


import kz.iitu.itse1910.nurlan.oibekuly.dto.UserDto;
import kz.iitu.itse1910.nurlan.oibekuly.model.Users;
import kz.iitu.itse1910.nurlan.oibekuly.repository.pagination.UserRepo;
import kz.iitu.itse1910.nurlan.oibekuly.repository.pagination.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepoImpl implements UserRepo {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getUsers(int page, int limit) {
        List<UserDto> returnValue = new ArrayList<>();
        Pageable pageableRequest = (Pageable) PageRequest.of(page, limit);
        Page<Users> users = userRepository.findAll((org.springframework.data.domain.Pageable) pageableRequest);
        List<Users> userEntities = users.getContent();
        for (Users userEntity : userEntities) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userEntity, userDto);
            returnValue.add(userDto);
        }
        return returnValue;
    }
}