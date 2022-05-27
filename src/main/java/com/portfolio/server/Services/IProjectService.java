package com.portfolio.server.Services;

import com.portfolio.server.Models.Project;
import java.util.List;


public interface IProjectService {
    
    public void createProject(Project pro);
    public void updateProject(Project update);
    public void deleteProject(int id);
    public Project findById(int id);
    public List<Project> findAll();
}
