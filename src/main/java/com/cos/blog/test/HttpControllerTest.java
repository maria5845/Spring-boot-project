package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응답(HTML 파일이 있는경우)
//@Controller
//사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

	// 인터넷 브라우저 요청은 Get 요청만 된다.
	// http://localhost:8080 /http/get(select)
	@GetMapping("/http/get")
	public String getTest(Member m) { // ?id=1&username=ssar&password=1234&email=ssar@nate.com -> MessageConverter(스프링 부트)
		return "get 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}

	// http://localhost:8080 /http/post(insert)
	@PostMapping("/http/post") // text /plain , application/json
	public String postTest(@RequestBody Member m) { // MessageConverter(스프링 부트)
		// JSON 타입으로 보내면 파라미터를 해당 Member 오브젝트 에 자동적으로 매핑해 주는데 이것을 메시지 컨버터가 자동적으로 매핑해서넣어줌
		return "post 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}

	// http://localhost:8080 /http/put(update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		// body에 데이터를 담아서 보내면 오브젝트로 받아서 매핑해주는데 RequestBody라는 어노테이션을 통해서 오브젝트로 매핑해서 받을 수  있음
		return "put요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}

	// http://localhost:8080 /http/delete(delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
