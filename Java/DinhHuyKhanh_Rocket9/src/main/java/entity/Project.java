package entity;


/**
 * @Description
 * @author: Đinh Huy Khánh
 * @creat_date: 13-1-2021
 * @modifer:
 * @modifer_date:
 * */

public class Project {
    private  int projectId;
    private int teamsize;
    private int idManager;
//    private int[] idEmployee;

    public Project(int projectId, int teamsize, int idManager) {
        this.projectId = projectId;
        this.teamsize = teamsize;
        this.idManager = idManager;
        //this.idEmployee = idEmployee;
    }

    public Project(){

    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getTeamsize() {
        return teamsize;
    }

    public void setTeamsize(int teamsize) {
        this.teamsize = teamsize;
    }

    public int getIdManager() {
        return idManager;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

}
