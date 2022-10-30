package RoutePlanner.core.domain.survey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table( name="SURVEY" )
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USERID",unique = true)
    private String userID;

    @Column(name = "USERWHERE")
    private String userWhere;

    @Column(name = "USERWHAT")
    private String userWHAT;

    @Column(name = "USERWHO")
    private String userWho;
}
