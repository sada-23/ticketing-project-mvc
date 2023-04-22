package com.company.service.impl;

import com.company.dto.RoleDTO;
import com.company.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

// We can use annotation for @Service instead of @Component implementation classes.
@Service
public class RoleServiceImpl extends AbstractMapService<RoleDTO,Long> implements RoleService {


    @Override
    public RoleDTO save(RoleDTO object) {
        return super.save(object.getId(), object);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }


    @Override
    public RoleDTO findById(Long id) {
        return super.findById(id);
    }
}