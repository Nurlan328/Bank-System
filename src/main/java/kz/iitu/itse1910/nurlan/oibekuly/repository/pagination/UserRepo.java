package kz.iitu.itse1910.nurlan.oibekuly.repository.pagination;

import kz.iitu.itse1910.nurlan.oibekuly.dto.UserDto;

import java.util.List;

public interface UserRepo
{
    List<UserDto> getUsers(int page, int limit);
}
