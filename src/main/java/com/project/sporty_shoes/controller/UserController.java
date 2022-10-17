package com.project.sporty_shoes.controller;

import static com.project.sporty_shoes.constant.SecurityConstant.JWT_TOKEN_HEADER;
import static org.springframework.http.HttpStatus.OK;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.sporty_shoes.dto.LoginRequestDto;
import com.project.sporty_shoes.dto.LoginResponseDto;
import com.project.sporty_shoes.dto.SignupRequestDto;
import com.project.sporty_shoes.exception.EmailExistException;
import com.project.sporty_shoes.exception.ExceptionHandling;
import com.project.sporty_shoes.exception.UserNotFoundException;
import com.project.sporty_shoes.exception.UsernameExistException;
import com.project.sporty_shoes.model.User;
import com.project.sporty_shoes.model.UserPrincipal;
import com.project.sporty_shoes.response.ApiResponse;
import com.project.sporty_shoes.service.OrderService;
import com.project.sporty_shoes.service.UserService;
import com.project.sporty_shoes.utility.JWTTokenProvider;

@RestController
public class UserController extends ExceptionHandling {
	public static final String REGISTER_MSG_TO_USER = "User registered successfully with username:  ";
	public static final String USER_DELETED_SUCCESSFULLY = "User deleted successfully";
	private AuthenticationManager authenticationManager;
	private UserService userService;
	private JWTTokenProvider jwtTokenProvider;

	@Autowired
	public ModelMapper modelMapper;

	@Autowired
	public OrderService orderService;

	public UserController(AuthenticationManager authenticationManager, UserService userService,
			JWTTokenProvider jwtTokenProvider) {
		this.authenticationManager = authenticationManager;
		this.userService = userService;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
		User user = modelMapper.map(loginRequestDto, User.class);
		User loginUser = userService.findUserByEmailId(user.getEmailId());
		authenticate(loginUser.getUsername(), user.getPassword());
		UserPrincipal userPrincipal = new UserPrincipal(loginUser);
		loginUser.setIsactive(true);
		loginUser.setNotLocked(userPrincipal.isEnabled());
		HttpHeaders jwtHeader = getJwtHeader(userPrincipal);
		LoginResponseDto loginResponse = modelMapper.map(loginUser, LoginResponseDto.class);
		return new ResponseEntity<>(loginResponse, jwtHeader, OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<ApiResponse> register(@RequestBody SignupRequestDto signupRequestDto)
			throws UserNotFoundException, UsernameExistException, EmailExistException {
		User user = modelMapper.map(signupRequestDto, User.class);
		User newUser = userService.register(user);
		ApiResponse loginResponse = new ApiResponse(OK, REGISTER_MSG_TO_USER + newUser.getUsername());
		return new ResponseEntity<>(loginResponse, OK);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable(name = "id") int id) throws UserNotFoundException {
		userService.deleteUser(id);
		ApiResponse apiResponse = new ApiResponse(OK, USER_DELETED_SUCCESSFULLY);
		return new ResponseEntity<>(apiResponse, OK);
	}

	private HttpHeaders getJwtHeader(UserPrincipal user) {
		HttpHeaders headers = new HttpHeaders();
		String jwtToken = jwtTokenProvider.generateJwtToken(user);
		headers.add(JWT_TOKEN_HEADER, jwtToken);
		return headers;
	}

	private void authenticate(String username, String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}
}
