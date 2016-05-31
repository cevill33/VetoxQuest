package vetoxquest.core.manager;

import vetoxquest.core.QuestNPC;
import vetoxquest.npc.*;

/**
 * Created by Jakob on 17.04.2016.
 */
public class ManagerQuestNPC {

    public static void registerNPC() {
        //Max
        QuestNPC npcMax = new NPC_ClickMich();
        npcMax.register("Klick auf mich!");

        //Swen
        QuestNPC npcSwen = new NPC_Swen();
        npcSwen.register("Swen");

        //Hannes
        QuestNPC npcHannes = new NPC_Hannes();
        npcHannes.register("Hannes");

        //Yakuru
        QuestNPC npcYakuru = new NPC_Yakuru();
        npcYakuru.register("Yakuru");

        //Wilma
        QuestNPC npcWilma = new NPC_Wilma();
        npcWilma.register("Wilma");

        //Elfride
        QuestNPC npcElfride = new NPC_Elfride();
        npcElfride.register("Elfride");

        //Pilot Berblinger
        QuestNPC npcBerblinger = new NPC_PilotBarblinger();
        npcBerblinger.register("Pilot Berblinger");



    }



}
