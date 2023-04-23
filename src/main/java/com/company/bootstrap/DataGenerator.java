package com.company.bootstrap;

import com.company.dto.ProjectDTO;
import com.company.dto.RoleDTO;

import com.company.dto.UserDTO;
import com.company.entity.Role;
import com.company.enums.Gender;
import com.company.enums.Status;
import com.company.service.ProjectService;
import com.company.service.RoleService;
import com.company.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/*
 * Bootstrap : Initiated (Initial loading). When the Application starts, the bootstrap will be initiated (executed) right away.
 * · "CommandLineRunner" interface from SprintBoot. When the Application starts, the application CommandLineRunner implemented class runs first.
 *
 */
@Component
public class DataGenerator implements CommandLineRunner {

     RoleService roleService;
     UserService userService;
     ProjectService projectService;

    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
    }

    @Override
    public void run(String... args) throws Exception {

        // These are fake data. Normally these data should come from DB
        RoleDTO adminRole = new RoleDTO(1L,"Admin");
        RoleDTO managerRole = new RoleDTO(2L,"Manager");
        RoleDTO employeeRole = new RoleDTO(3L,"Employee");


        // save data to map that used to fake the DB (RoleServiceImpl extends AbstractMapService)
        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);


        UserDTO user1 = new UserDTO("John", "Kesy",
                "john@company.com", "Abc1", true, "7459684532", managerRole, Gender.MALE);
        UserDTO user5 = new UserDTO("Mike", "Smith",
                "mike@company.com", "Abc2", true, "7459684532", adminRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Delisa",
                "Norre", "delisa@company.com", "123", true, "8567412358", managerRole, Gender.FEMALE);
        UserDTO user3 = new UserDTO("Craig", "Jark",
                "craig@company.com", "Abc3", true, "7777775566", employeeRole, Gender.MALE);
        UserDTO user4 = new UserDTO("Shaun",
                "Hayns", "shaun@company.com", "Abc4", true, "3256987412", managerRole, Gender.MALE);
        UserDTO user6 = new UserDTO("Elizebeth",
                "Loren", "elizebeth@company.com", "Abc4", true, "5306987412", employeeRole, Gender.FEMALE);
        UserDTO user7 = new UserDTO("Maria",
                "Ada", "maria@company.com", "Abc4", true, "9996987412", employeeRole, Gender.FEMALE);
        UserDTO user8 = new UserDTO("Bill",
                "Matt", "bill@company.com", "Abc4", true, "8881239846", employeeRole, Gender.MALE);


        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);



        ProjectDTO project1 = new ProjectDTO("Spring MVC","PR001",user1, LocalDate.now(),LocalDate.now().plusDays(25),"Creating Controllers", Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("Spring ORM","PR002",user2, LocalDate.now(),LocalDate.now().plusDays(10),"Creating Database", Status.IN_PROGRESS);
        ProjectDTO project3 = new ProjectDTO("Spring Container","PR003",user1, LocalDate.now(),LocalDate.now().plusDays(32),"Creating Container", Status.IN_PROGRESS);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);





    }
}
