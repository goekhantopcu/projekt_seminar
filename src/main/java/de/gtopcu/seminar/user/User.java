package de.gtopcu.seminar.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Builder
@Table("hbrs_user")
@AllArgsConstructor
public class User implements Serializable {
    public static final String CREATE_QUERY = "CREATE TABLE `hbrs_user` (`id` SERIAL PRIMARY KEY AUTO_INCREMENT, `firstName` VARCHAR(255), `lastName` VARCHAR(255), `screenName` VARCHAR(255));";
    @Id
    private Long id;

    @Size(max = 255)
    private String firstName;

    @Size(max = 255)
    private String lastName;

    @Size(max = 255)
    private String screenName;
}


