package com.example.vivriti.serviceimpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vivriti.entity.User;
import com.example.vivriti.exception.ResourceNotfoundexception;
import com.example.vivriti.repository.UserRepository;
import com.example.vivriti.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	// create a parmaterized constructor

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);

	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getById(Integer uid) {

		Optional<User> optional = userRepository.findById(uid);
		if (optional.isPresent()) {
			return optional.get();

		} else {
			throw new ResourceNotfoundexception("No Details Found :" + "User", "Id", uid);

		}
	}

	@Override
	public User update(User user, Integer uid) {
		User existingUser = userRepository.findById(uid)
				.orElseThrow(() -> new ResourceNotfoundexception("User", "uid", uid));
		existingUser.setFirstname(user.getFirstname());
		existingUser.setLastname(user.getLastname());
		existingUser.setUsername(user.getUsername());
		existingUser.setPassword(user.getPassword());
		existingUser.setDob(user.getDob());

		userRepository.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteById(Integer uid) {
		User existingUser = userRepository.findById(uid)
				.orElseThrow(() -> new ResourceNotfoundexception("User", "uid", uid));
		userRepository.deleteById(uid);
	}

}
