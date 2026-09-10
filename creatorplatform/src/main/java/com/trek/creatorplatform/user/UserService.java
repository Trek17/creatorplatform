package com.trek.creatorplatform.user;

import com.trek.creatorplatform.user.dto.CreateUserRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService( UserRepository userRepository,SecurityConfig passwordEncoder)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder.encoder();
    }

    public UserResponse createUser(CreateUserRequest request)
    {
        if(userRepository.existsByEmail(request.getEmail()))
        {
            throw new DuplicateUserException("Email already exists");
        }
        if (userRepository.existsByUsername(request.getUsername()))
        {
            throw new DuplicateUserException("Username already exists");

        }
        String hashedPass = passwordEncoder.encode(request.getPassword());

            User user = new User(request.getUsername(),
                    hashedPass,
                request.getEmail(),
                        Role.USER);

            User saveUser = userRepository.save(user);
        return new UserResponse(
                saveUser.getId(),
                saveUser.getUsername(),
                saveUser.getEmail(),
                saveUser.getRole(),
                saveUser.getCreatedAt()
        );
    }

}
