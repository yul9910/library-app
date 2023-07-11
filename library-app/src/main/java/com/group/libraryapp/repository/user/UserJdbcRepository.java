package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserJdbcRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isUserNotExist(long id){
        String readSql = "select * from user where id=?";
        // 결과가 하나라도 있다면 0이 담긴 List로 반환(데이터가 있는 상태)
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();
    }

    public void updateUserName(String name, long id){
        String sql = "update user set name = ? where id =?";
        jdbcTemplate.update(sql, name, id);
    }

    //이름 체크
    public boolean isUserNotExist(String name){
        String readSql = "select * from user where name=?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
    }

    //삭제
    public void deleteUser(String name){
        String sql = "delete from user where name = ?";
        jdbcTemplate.update(sql, name);
    }

    public void saveUser(String name, int age){
        String sql = "insert into user (name, age) values(?,?)";
        jdbcTemplate.update(sql,name,age);
    }

    public List<UserResponse> getUsers() {
        String sql =  "select * from user";
        // 쿼리의 결과를 받아, 객체를 반환한다. (RowMapper)
        // jdbcTemplate.query의 반환 타입은 List
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id,name,age);
        });
        // 같은 코드 (위에는 람다)
        /* return jdbcTemplate.query(sql, new RowMapper<UserResponse>() { // 쿼리의 결과를 받아, 객체를 반환한다.
            @Override
            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                return new UserResponse(id,name,age);
            }
        });*/
    }
}
