package info.mlstech.tutorial.todoapi;

import info.mlstech.tutorial.todoapi.model.Todo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoApiApplicationTests {

	@LocalServerPort
	int randomServerPort;

	@Test
	public void testTodoOk() throws URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:"+randomServerPort+"/ok";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		Assertions.assertEquals(200, result.getStatusCodeValue());

		Assertions.assertEquals("ok", result.getBody());
	}

	@Test
	public void testListTodos() throws URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:"+randomServerPort+"/todo";
		URI uri = new URI(baseUrl);

		ResponseEntity<List<Todo>> result = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Todo>>(){});

		Assertions.assertEquals(200, result.getStatusCodeValue());

		List<Todo> todos = result.getBody();
		Assertions.assertEquals(0, todos.size());

	}

}
