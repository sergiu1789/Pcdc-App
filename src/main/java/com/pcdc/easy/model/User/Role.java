package com.pcdc.easy.model.User;

import com.pcdc.easy.model.enums.UserRoles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;


 @Enumerated(EnumType.STRING)
    private UserRoles role;



}

