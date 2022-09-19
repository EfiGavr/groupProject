package groupproject.projectx.services;

import groupproject.projectx.dtos.AdminDto;
import groupproject.projectx.model.Admin;
import groupproject.projectx.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AdminRepository adminRepository;

    public AdminDto getAdminByCredentials(String username, String password) {
        Admin admin = adminRepository.findByAdUsernameAndAdPassword(username, password);
        if (admin == null) {
            throw new IllegalArgumentException("Admin Did Not Found");
        } else {
            return convertToAdminDto(admin);
        }
    }

    public AdminDto convertToAdminDto(Admin admin) {
        return modelMapper.map(admin, AdminDto.class);
    }
}
