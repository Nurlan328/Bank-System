package kz.iitu.itse1910.nurlan.oibekuly.controller.pagination;

import kz.iitu.itse1910.nurlan.oibekuly.dto.UserDto;
import kz.iitu.itse1910.nurlan.oibekuly.model.Users;
import kz.iitu.itse1910.nurlan.oibekuly.repository.impl.UserRepoImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllerPagination {

    @Autowired
    UserRepoImpl userRepoImpl;

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<Users> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
                                @RequestParam(value = "limit", defaultValue = "30") int limit) {
        List<Users> returnValue = new ArrayList<>();

        List<UserDto> users = userRepoImpl.getUsers(page, limit);

        for (UserDto userDto : users) {
            Users userModel = new Users();
            BeanUtils.copyProperties(userDto, userModel);
            userModel.setId(Integer.parseInt("/users/" + userDto.getId()));
            returnValue.add(userModel);
        }

        return returnValue;
    }
}