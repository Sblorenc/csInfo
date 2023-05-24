package pl.coderslab.CsInfo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.CsInfo.entity.Role;
import pl.coderslab.CsInfo.repository.RoleRepo;
import pl.coderslab.CsInfo.service.RoleService;

@RequiredArgsConstructor
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    @Override
    public Role findByName(String name){
        return  roleRepo.findByName(name).get();
    }

    @Override
    public void save(Role role){roleRepo.save(role);}
}
