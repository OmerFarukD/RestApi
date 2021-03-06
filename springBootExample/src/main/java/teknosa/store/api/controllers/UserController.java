package teknosa.store.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import teknosa.store.business.abstracts.UserService;
import teknosa.store.core.entity.User;
import teknosa.store.core.utilities.results.DataResult;
import teknosa.store.core.utilities.results.ErrorDataResult;


@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	private UserService userService;
	
@GetMapping("/getAll")
public DataResult<List<User>> getAll(){
	return this.userService.getAll();
}
@PostMapping(value="/add")
public ResponseEntity<?> add(@Valid @RequestBody User user) {
	return ResponseEntity.ok(this.userService.add(user));
}


@ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public ErrorDataResult<Object> handleValidationException
(MethodArgumentNotValidException exceptions){
	Map<String,String> validationErrors = new HashMap<String, String>();
	for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
		validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
	}
	
	ErrorDataResult<Object> errors 
	= new ErrorDataResult<Object>(validationErrors,"Do??rulama hatalar??");
	return errors;
}

}
