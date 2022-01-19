package pl.unityt.recruitment.github;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepositoriesController {
    private RepositoriesService repositoriesService;

    public RepositoriesController(RepositoriesService repositoryService) {
        this.repositoriesService = repositoryService;
    }

    @GetMapping(value = "/repositories/{owner}/{repositoryName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RepositoryDTO repositories(@PathVariable String owner, @PathVariable String repositoryName) {
        return this.repositoriesService.getRepositories(owner, repositoryName);
    }
}