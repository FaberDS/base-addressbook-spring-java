package at.schuele.addessbookspringjava.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Getter @Setter @ToString @Builder @AllArgsConstructor @NoArgsConstructor
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    /*private String street;
    private String city;
    private int zipCode;
    @Enumerated(EnumType.ORDINAL)
    private Country country;
    private String phoneNumber;
    private String email;
    private boolean isBusiness;
    private LocalDateTime birthday;*/
}
