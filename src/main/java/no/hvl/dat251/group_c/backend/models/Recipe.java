package no.hvl.dat251.group_c.backend.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe {
  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false, length = 255)
  private String name;

  @Column(nullable = false, length = 255)
  private String description;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
    name = "recipe_ingredients",
    joinColumns = { @JoinColumn(name = "recipe_id") },
    inverseJoinColumns = { @JoinColumn(name = "ingredient_id") }
  )
  private List<Ingredient> ingredients;

  @ManyToOne
  @JoinColumn(name = "owner_id", nullable = false)
  private User owner;
}
