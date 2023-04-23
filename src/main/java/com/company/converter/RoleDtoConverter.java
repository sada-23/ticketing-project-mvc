package com.company.converter;

import com.company.dto.RoleDTO;
import com.company.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding // TThis annotation does data type conversion automatically.
public class RoleDtoConverter implements Converter<String,RoleDTO> {

    RoleService roleService;

    public RoleDtoConverter(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDTO convert(String source) {

        // convert String id in the map that comes from UI to Long (Object)
        return roleService.findById(Long.parseLong(source));
    }
}
