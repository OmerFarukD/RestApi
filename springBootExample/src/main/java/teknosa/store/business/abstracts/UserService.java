package teknosa.store.business.abstracts;

import java.util.List;

import teknosa.store.core.entity.User;
import teknosa.store.core.utilities.results.DataResult;
import teknosa.store.core.utilities.results.Result;

public interface UserService {
Result add(User user);
	DataResult<List<User>> getAll();
}
