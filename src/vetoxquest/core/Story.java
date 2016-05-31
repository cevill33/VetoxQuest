package vetoxquest.core;

import java.util.List;

/**
 * Created by Jakob on 16.04.2016.
 */
public class Story {

    private String name;
    private List<String> description;

    public Story(String name, List<String> description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public List<String> getDescription() {
        return description;
    }
}
