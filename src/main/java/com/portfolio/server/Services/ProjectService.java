package com.portfolio.server.Services;

import com.portfolio.server.Models.Project;
import com.portfolio.server.Repositories.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService{

    @Autowired
    public ProjectRepository repository;
    
    @Override
    public void createProject(Project pro) {
        repository.save(pro);
    }

    @Override
    public void updateProject(Project update) {
        Project pro = findById(update.getId());
        
        pro.setName(update.getName());
        pro.setDescription(update.getDescription());
        pro.setUrlGit(update.getUrlGit());
        pro.setUrlImg(update.getUrlImg());
        
        repository.save(pro);
    }

    @Override
    public void deleteProject(int id) {
        repository.deleteById(id);
    }

    @Override
    public Project findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Project> findAll() {
        return repository.findAll();
    }
    
}
