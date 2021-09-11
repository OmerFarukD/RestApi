package teknosa.store.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import teknosa.store.core.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
