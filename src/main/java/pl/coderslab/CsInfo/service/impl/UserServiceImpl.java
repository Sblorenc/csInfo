package pl.coderslab.CsInfo.service.impl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.CsInfo.entity.User;
import pl.coderslab.CsInfo.repository.UserRepo;
import pl.coderslab.CsInfo.service.UserService;

import java.net.http.HttpRequest;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public void save(User user){
        userRepo.save(user);
    }

}
