package se331.project2.rest.security.user;

public interface UserDao {
    User findByUsername(String username);

    User save(User user);
}