package csc207.phase2.UTFantasy.Products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.R;

public class InfoMediator {
  /** the player. */
  private Player player;

  private String description;

  private List<Pokemon> selectedPokemon;

  public InfoMediator(Player player) {
    this.player = player;
    this.setDescription("This is the character in U of T.");
  }

  public List<Pokemon> getSelectedPokemon() {
    return selectedPokemon;
  }

  public void setSelectedPokemon(List<Pokemon> selectedPokemon) {
    this.selectedPokemon = selectedPokemon;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Pokemon> getPokemonList() {
    return player.getPokemonList();
  }

  public HashMap<Product, Integer> getProductHashMap() {
    return player.getBag();
  }

  public String getGender() {
    if (player.getGender().equals("boy")) {
      return "Gender: Male";
    } else {
      return "Gender: Female";
    }
  }

  public int getGenderImage() {
    if (player.getGender().equals("boy")) {
      return R.drawable.charater_male;
    } else {
      return R.drawable.character_female;
    }
  }

  public String getMoney() {
    return "Money: $" + player.getMoney();
  }
}