package apps.org.dummyapprecycler;

import android.support.annotation.NonNull;

/**
 * Created by UtsavSaha on 12/06/18.
 */

public class Team implements Comparable<Team>{

    Team(String teamName,int teamRank){
        this.teamName = teamName;
        this.teamRank = teamRank;
    }

    private String teamName;
    private int teamRank;
    private int predictedGroupPosition=0;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamRank() {
        return teamRank;
    }

    public void setTeamRank(int teamRank) {
        this.teamRank = teamRank;
    }

    public int getPredictedGroupPosition() {
        return predictedGroupPosition;
    }

    public void setPredictedGroupPosition(int predictedGroupPosition) {
        this.predictedGroupPosition = predictedGroupPosition;
    }

    @Override
    public int compareTo(@NonNull Team team) {
        if(this.predictedGroupPosition ==0 || team.predictedGroupPosition ==0){ //input not provided. sort by Fifa rank
            return this.teamRank > team.teamRank ? 1 : -1;
        }
        else{
            return this.predictedGroupPosition > team.predictedGroupPosition ? 1 : -1;
        }

    }
}
