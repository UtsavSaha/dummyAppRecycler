package apps.org.dummyapprecycler;

import java.util.List;

/**
 * Created by UtsavSaha on 13/06/18.
 */

public class Group {
     Group(String groupName, List<Team> teams){
         this.groupName = groupName;
         this.teams = teams;
     }

    private String groupName;
    List<Team> teams;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
