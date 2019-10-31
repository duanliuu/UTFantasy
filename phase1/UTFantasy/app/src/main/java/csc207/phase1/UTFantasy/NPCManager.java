package csc207.phase1.UTFantasy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import csc207.phase1.UTFantasy.Character.FighterNPC;
import csc207.phase1.UTFantasy.Character.HealerNPC;
import csc207.phase1.UTFantasy.Character.NPC;
import csc207.phase1.UTFantasy.Character.SellerNPC;

public class NPCManager implements Serializable{

    /**
     * A  HashMap that keys are UserName, values are User instance.
     */
    private HashMap<String, NPC> npcHashMap;

    /**
     * The array list of all npc
     */
    private ArrayList<NPC> npcArrayList = new ArrayList<>();


    /**
     * Where all user data are stored.
     */

    /**
     * Singleton Constructor of npcManager.
     */
    public NPCManager() {
        npcHashMap = new HashMap<>();
        String seller = "Alice";
        String fighter = "Professor. P";
        String healer = "SecondCup";
        SellerNPC sellerNPC = new SellerNPC(seller);
        FighterNPC fighterNPC = new FighterNPC(fighter);
        HealerNPC healerNPC = new HealerNPC(healer);
        addNPC(seller, sellerNPC);
        addNPC(fighter, fighterNPC);
        addNPC(healer, healerNPC);
        npcArrayList.add(salerNPC);
        npcArrayList.add(fighterNPC);
        npcArrayList.add(healerNPC);
        salerNPC.setLocation(10,15);
        fighterNPC.setLocation(10,5);
        healerNPC.setLocation(10,10);
    }


    /**
     * Get the User in npcHashMap if the username is in the userHapMap.
     *
     * @param NPCname the NPCname of the User.
     * @return a User if the NPCname is in the npcHashMap, null if not.
     */
    public NPC getNPC(String NPCname) {
        if (npcHashMap.containsKey((NPCname))) {
            return npcHashMap.get(NPCname);
        }
        return null;
    }

    /**
     * Register using username and password. Update the userHapMap after resisting.
     *
     * @param NPCname the username of the User.
     * @return A new User.
     */
    public void addNPC(String NPCname, NPC npc) {
        npcHashMap.put(NPCname, npc);
    }

    /**
     * @return the array list of all npc
     */
    public ArrayList<NPC> getNpcArrayList(){
        return npcArrayList;
    }
}