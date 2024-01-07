package fr.polytech.fsback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Evaluation")
public class EvaluationEntity {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "evaluateur")
    private String evaluateur;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "note")
    private int note;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private RestaurantEntity restaurant;

}
