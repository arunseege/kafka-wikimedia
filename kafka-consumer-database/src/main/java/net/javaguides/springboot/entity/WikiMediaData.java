package net.javaguides.springboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="wikimedia_recentchange")
@Setter
@Getter
public class WikiMediaData {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String wikiEventData;

}
