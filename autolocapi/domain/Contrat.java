package tn.esprit.autoloc.autolocapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contrat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Contrat {
    //Reservation/Contrat
    @OneToOne (mappedBy = "contrat")
    Reservation reservation;
    //Contart/Paiement
    @OneToMany(mappedBy = "contrat" , cascade = CascadeType.ALL , orphanRemoval = true)
    List<Paiement> paiements = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    @Column(nullable = false)
    private LocalDate dateSignature;

    @Column(nullable = false)
    private BigDecimal montantTotal;

    @Column(nullable = false)
    private boolean valide;
}
