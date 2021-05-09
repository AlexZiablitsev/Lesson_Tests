package dao;

import enums.ProjectType;
import models.Project;
import services.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProjectDaoImplementation implements ProjectDao {
    static Connection con = DBConnection.getConnection();

    @Override
    public int add(Project project) throws SQLException {
        String query = "insert into project(name, isShowAnnouncement, type, Announcement) values(?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, project.getName());
        ps.setBoolean(2, project.isShowAnnouncement());
        ps.setString(3, project.getProjectType().getValue());
        ps.setString(4, project.getAnnouncement());

        return 0;
    }

    @Override
    public Project getProject(int id) throws SQLException {
        String query = "select * from project where id = ?;";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        boolean check = false;
        Project project = Project.builder().build();
        while (rs.next()) {
            check = true;
            project.setId(rs.getInt("id"));
            project.setName(rs.getString("name"));
            project.setAnnouncement(rs.getString("Announcement"));
            project.setShowAnnouncement(rs.getBoolean("isShowAnnouncement"));
            project.setProjectType(ProjectType.getEnumByValue(rs.getInt("type")));
        }
        return check ? project : null;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(Project project) throws SQLException {

    }

    @Override
    public List<Project> getProjects() throws SQLException {
        return null;
    }
}
