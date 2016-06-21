package vetoxquest.core;

import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Jakob on 17.04.2016.
 */
public class Playing {

    private boolean playing;
    private String quest;
    private List<String> order;
    private int step;
    private List<String> killmethods;
    private List<String> interactmethod;
    private String talkname;
    private int talkstep;
    private String answer;


    public Playing(boolean playing, String quest) {
        this.playing = playing;
        this.quest = quest;
        this.talkname = "";
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public List<String> getKillmethods() {
        return killmethods;
    }

    public void setKillmethods(List<String> killmethods) {
        this.killmethods = killmethods;
    }

    public List<String> getInteractmethod() {
        return interactmethod;
    }

    public void setInteractmethod(List<String> interactmethod) {
        this.interactmethod = interactmethod;
    }

    public String getTalkname() {
        return talkname;
    }

    public void setTalkname(String talkname) {
        this.talkname = talkname;
    }

    public int getTalkstep() {
        return talkstep;
    }

    public void setTalkstep(int talkstep) {
        this.talkstep = talkstep;
    }

    public List<String> getOrder() {
        return order;
    }

    public void setOrder(List<String> order) {
        this.order = order;
    }

    public static Playing get(Player p) {
        return Quest.playing.get(p.getUniqueId());
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
