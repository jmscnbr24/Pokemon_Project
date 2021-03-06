package pokemonproject;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class pokemonLevel {
    public accessingDatabase a = new accessingDatabase();
    public ArrayList<myPokemons> mypokemons = a.getMyPokemon();
    public ArrayList<pokemonEvolutions> evolution= a.getPokemonEvolutions();
    
    public Integer levelUp(int level){
        return level+=1;
    }
    
    public Boolean isMAxLevel(int level){
        return level>100;
    }
    
    public void myPokemonLevel(int row){
        int myPokemonId = mypokemons.get(row).getMyPokemonId();
        String pokemon = mypokemons.get(row).getMyPokemon();
        String specie = mypokemons.get(row).getSpecie();
        int level = mypokemons.get(row).getLevel();
        int pokemonId = mypokemons.get(row).getPokemonId();
        level = levelUp(level);
        if(!isMAxLevel(level)){
            int x=0;
            for(pokemonEvolutions evolve: evolution){
                if(evolve.getEvolutionLevel() == level && evolve.getPokemonId()== pokemonId){
                        String temp = evolve.getEvolution();
                        a.updateMyPokemons(level, temp,myPokemonId);
                        JOptionPane.showMessageDialog(null, "Level-Up to Level "+level+" and evolve to "+temp);
                        x++;
                        break;
                }
            }
            if(x==0){
                a.updateMyPokemons(level,myPokemonId);
                JOptionPane.showMessageDialog(null, "Level-Up to Level "+level);
            }
        }
        else
            JOptionPane.showMessageDialog(null, "The pokemon have reach the max level...");
    }
    
}
