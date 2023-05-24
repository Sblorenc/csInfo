package pl.coderslab.CsInfo.service;
import pl.coderslab.CsInfo.entity.Role;

public interface RoleService {

    Role findByName(String name);

    void save(Role role);
}
