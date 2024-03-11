package no.hvl.dat251.group_c.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredients")
public class Ingredient {
  @Id
  private Long ean;

  @Column(nullable = false, length = 255)
  private String amount;

  @ManyToOne
  @JoinColumn(name = "category_id", nullable = false)
  private Category category; 
}
