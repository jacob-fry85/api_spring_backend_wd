package com.jacobfrye.myboot.User;

import com.jacobfrye.myboot.user.User;
import com.jacobfrye.myboot.user.UserRepository;
import com.jacobfrye.myboot.user.UserRole;
import com.jacobfrye.myboot.user.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testStoreUser() {
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.STAFF);
        User user = userRepository.save(new User(UUID.randomUUID(), "darwin.tirta@yahoo.com", "password", roles));

        assertThat(user).isNotNull();

        assertThat(userRepository.count()).isEqualTo(1L);
    }

    @Test
    public void testFindByEmail() {
        User user = Users.newRandomOfficer();
        userRepository.save(user);
        Optional<User> optional = userRepository.findByEmailIgnoreCase(user.getEmail());

        assertThat(optional).isNotEmpty().contains(user);
    }

    @Test
    public void testFindByEmailIgnoringCase() {
        User user = Users.newRandomOfficer();
        userRepository.save(user);
        Optional<User> optional = userRepository.findByEmailIgnoreCase(user.getEmail().toUpperCase());
        assertThat(optional).isNotEmpty().contains(user);
    }

    @Test
    public void testFindByUnknownEmail() {
        User user = Users.newRandomOfficer();
        userRepository.save(user);
        Optional<User> optional = userRepository.findByEmailIgnoreCase("balabala@find.me");

        assertThat(optional).isEmpty();
    }
}
