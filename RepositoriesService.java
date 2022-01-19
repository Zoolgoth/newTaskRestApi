package pl.unityt.recruitment.github;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RepositoriesService {
    private RestTemplate restTemplate;

    public RepositoriesService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public RepositoryDTO getRepositories(String owner, String repositoryName) {
        String url = "https://api.github.com/repos/" + owner + "/" + repositoryName;
        return this.restTemplate.getForObject(url, RepositoryDTO.class);
    }

}