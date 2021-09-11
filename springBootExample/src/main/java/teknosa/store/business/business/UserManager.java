package teknosa.store.business.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teknosa.store.business.abstracts.UserService;
import teknosa.store.core.dataAccess.UserDao;
import teknosa.store.core.entity.User;
import teknosa.store.core.utilities.results.DataResult;
import teknosa.store.core.utilities.results.Result;
import teknosa.store.core.utilities.results.SuccessDataResult;
import teknosa.store.core.utilities.results.SuccessResult;
@Service
public class UserManager implements UserService {
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
private UserDao userDao;
@Override
public Result add(User user) {
	this.userDao.save(user);
	return new SuccessResult();
}
@Override
public DataResult<List<User>> getAll() {
	
	return new SuccessDataResult<List<User>>(this.userDao.findAll());
}

}
