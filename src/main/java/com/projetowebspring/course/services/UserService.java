package com.projetowebspring.course.services;

import com.projetowebspring.course.entities.User;
import com.projetowebspring.course.repositories.UserRepository;
import com.projetowebspring.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public User delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        userRepository.delete(user.get());
        return user.get();
    }

    public User update(Long id, User user) {
        User user1 = userRepository.getReferenceById(id);
        updateData(user1, user);
        return userRepository.save(user1);
    }

    private void updateData(User user1, User user) {
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPhone(user.getPhone());
    }
}
