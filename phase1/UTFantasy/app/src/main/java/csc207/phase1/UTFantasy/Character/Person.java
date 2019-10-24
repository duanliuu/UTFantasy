package csc207.phase1.UTFantasy.Character;

import java.io.Serializable;
import java.util.ArrayList;

import csc207.phase1.UTFantasy.Pet.Pokemon;

class Person implements Serializable {
    Person(){}

    Person(String name, String gender){
        this.name = name;
        this.gender = gender;
        this.bag = new ArrayList<>();
        this.pokemon = new ArrayList<Pokemon>();
    }
    /**
     * name of this person*/
    protected String name;

    String getName(){
        return name;
    }

    /**
     * first coordinate*/
    protected int x;

    public int getX(){
        return x;
    }
    void set(int x){
        this.x = x;
    }
    /**
     * second coordinate*/
    protected int y;

    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    /**
     * gender of this person*/
    protected String gender;

    public String getGender(){
        return gender;
    }

    /**
     * objects in this person's bag*/
    protected ArrayList<String> bag;

    ArrayList<String> getBag(){
        return bag;
    }

    public void setBag(String item){
        bag.add(item);
    }

    /**
     * pokemons this person has*/
    protected ArrayList<Pokemon> pokemon;

    ArrayList<Pokemon> getPokemon(){
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon){
        this.pokemon.add(pokemon);
    }


    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
}
