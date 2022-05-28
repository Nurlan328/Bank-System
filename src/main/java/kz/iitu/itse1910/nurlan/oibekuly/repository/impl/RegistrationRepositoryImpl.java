package kz.iitu.itse1910.nurlan.oibekuly.repository.impl;

import kz.iitu.itse1910.nurlan.oibekuly.model.Users;
import kz.iitu.itse1910.nurlan.oibekuly.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RegistrationRepositoryImpl implements RegistrationRepository {

    public JdbcTemplate jdbcTemplate;

    @Autowired
    public RegistrationRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void updatePhotoByUsername(byte[] photo, String username) {
//        jdbcTemplate.update("update users u set u.photo = ? where u.username = ?");
        jdbcTemplate.update("update users set photo = ? where username = ?");
    }

    @Override
    public Users findByUsername(String username) {
        String sql = "select * from users where username=? ";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, new UserRowMapper());
    }

    @Override
    public List<Users> getAllUsers() {
        String sql = "select * from users";
        return jdbcTemplate.query(sql, new UserRowMapper() );
    }

    @Override
    public List<Users> findAll() {
        String sql = "select * from users";
        return jdbcTemplate.query(sql, new UserRowMapper() );
    }

    @Override
    public Users save(Users user) {
        jdbcTemplate.update(
                "insert into users (  id, first, last, age, username, password, photo ) values ( ?,?, ?, ?, ?,?,? )",
                user.getId(),
                user.getFirst(),
                user.getLast(),
                user.getAge(),
                user.getUsername(),
                user.getPassword(),
                user.getPhoto()
        );
        return user;
    }

    @Override
    public Users findById(int id) {
        String sql = "select * from users  where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());

    }
}
class UserRowMapper  implements RowMapper<Users> {

    public Users mapRow(ResultSet rs, int i) throws SQLException {
        Users user = new Users();
        user.setId(rs.getInt("ID"));
        user.setFirst(rs.getString("FIRST"));
        user.setLast(rs.getString("LAST"));
        user.setAge(rs.getInt("age"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setUsername(rs.getString("username"));
        user.setPhoto(rs.getBytes("photo"));
        return user;
    }
}







/*
<!--<!DOCTYPE html>-->
<!--<html xmlns:th="http://www.thymeleaf.org"-->
<!--      xmlns:sec="http://www.thymeleaf.org/extras/spring-security">-->

<!--<head th:insert="fragments.html :: headerfiles"></head>-->
<!--<header th:insert="fragments.html :: nav"></header>-->

<!--<html>-->
<!--<head>-->
<!--    <meta name="viewport" content="width=device-width, initial-scale=1">-->
<!--    <style>-->
<!--        html {-->
<!--            box-sizing: border-box;-->
<!--        }-->

<!--        *, *:before, *:after {-->
<!--            box-sizing: inherit;-->
<!--        }-->

<!--        .column {-->
<!--            float: left;-->
<!--            width: 33.3%;-->
<!--            margin-bottom: 16px;-->
<!--            padding: 0 8px;-->
<!--        }-->

<!--        @media screen and (max-width: 650px) {-->
<!--            .column {-->
<!--                width: 100%;-->
<!--                display: block;-->
<!--            }-->
<!--        }-->

<!--        .card {-->
<!--            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);-->
<!--        }-->

<!--        .container {-->
<!--            padding: 0 16px;-->
<!--        }-->

<!--        .container::after, .row::after {-->
<!--            content: "";-->
<!--            clear: both;-->
<!--            display: table;-->
<!--        }-->

<!--        .title {-->
<!--            color: grey;-->
<!--        }-->

<!--        .button {-->
<!--            border: none;-->
<!--            outline: 0;-->
<!--            display: inline-block;-->
<!--            padding: 8px;-->
<!--            color: white;-->
<!--            background-color: #000;-->
<!--            text-align: center;-->
<!--            cursor: pointer;-->
<!--            width: 100%;-->
<!--        }-->

<!--        .button:hover {-->
<!--            background-color: #555;-->
<!--        }-->
<!--    </style>-->
<!--</head>-->
<!--<Body background='https://catherineasquithgallery.com/uploads/posts/2021-03/1614857842_161-p-kulinarnii-fon-226.jpg'-->
<!--      style="background-size: cover;">-->
<!--<div class="container center">-->
<!--    <h2 class="text-center text-light">Your user profile</h2>-->
<!--    <br>-->
<!--    <div class="row" style="margin-left: auto; margin-right: auto">-->
<!--        <div class="card col-sm-6" style="width: 18rem;" align="center">-->
<!--            <div class="card-body" align="center">-->
<!--                <h2 class="card-title">Upload your avatar</h2>-->
<!--                <h6 class="text-success">[[${success}]]</h6>-->
<!--                <div class="mb-3">-->
<!--                    <span th:text="${#authentication.getName()}"></span>-->
<!--                    <form th:action="@{'/profile/upload?username='+ ${#authentication.getName()}}" method="post"-->
<!--                          enctype="multipart/form-data">-->
<!--                        <input-->
<!--                                class="form-control" name="file" type="file" id="formFile"><br/>-->
<!--                        <input type="submit" value="Upload" class="btn btn-warning">-->
<!--                    </form>-->
<!--                </div>-->
<!--            </div>-->
<!--        </div>-->
<!--        <div class="card col-sm-6" style="width: 18rem; round-clip: 50%"><img-->
<!--                th:src="@{'/profile/image1?username='+ ${#authentication.getName()}}" class="card-img-top">-->
<!--            <div class="card-body"><p class="card-text">Your photo</p>-->
<!--                <tr>-->
<!--                    <td>Username</td>-->
<!--                    <td><span sec:authentication="name"></span></td>-->
<!--                </tr>-->
<!--                <br>-->
<!--                <br>-->
<!--                <tr>-->
<!--                    <td>Authorities</td>-->
<!--                    <td><span sec:authentication="principal.authorities"></span></td>-->
<!--                </tr>-->
<!--            </div>-->
<!--        </div>-->
<!--    </div>-->
<!--    <br>-->
<!--    <br>-->
<!--</div>-->
<!--<div>-->
<!--    <li sec:authorize="hasRole('ROLE_ADMIN')" class="nav-item">-->
<!--        <p class="text-center text-light" style=" font-size:20px ; font-weight: bold">As admin you may see other user's-->
<!--            photos</p>-->
<!--        <div class="container mt-5">-->
<!--            <div class="card">-->
<!--                <div class="card-body">-->
<!--                    <div class="row">-->
<!--                        <th:block th:each="studList: ${list}">-->
<!--                            <div class="col-sm-3">-->
<!--                                <div><a th:href="@{'/profile/downloadfile?id=' + ${studList.id}}"><i-->
<!--                                        class="fa fa-download"></i></a>-->
<!--                                </div>-->
<!--                                <div><img th:src="@{'/profile/image?id='+ ${studList.id}}" width="200px" height="140px">-->
<!--                                </div>-->
<!--                                <div>[[${studList.photo}]]</div>-->
<!--                            </div>-->
<!--                        </th:block>-->
<!--                    </div>-->
<!--                </div>-->
<!--            </div>-->
<!--        </div>-->

<!--</div>-->
<!--</div>-->
<!--</div>-->

<!--</div>-->
<!--</div>-->
<!--</body>-->
<!--</html>-->
*/






